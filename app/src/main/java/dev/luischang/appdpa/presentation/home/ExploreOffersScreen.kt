package dev.luischang.appdpa.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import dev.luischang.appdpa.data.model.OfferModel

@Composable
fun ExploreOffersScreen(navController: NavController) {

    val offers = listOf(
        OfferModel("PlayStation 5", "Electrónica", "Lima", "https://cdn.sstatic.net/Sites/es/Img/apple-touch-icon@2.png"),
        OfferModel("Casaca de cuero", "Ropa y accesorios", "Lima", "https://cdn.sstatic.net/Sites/es/Img/apple-touch-icon@2.png"),
        OfferModel("Mesa de comedor", "Hogar", "Arequipa", "https://cdn.sstatic.net/Sites/es/Img/apple-touch-icon@2.png")
    )

    // Estados para los menús desplegables
    var expandedCategory by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf("Todas las categorías") }

    val categories = listOf(
        "Todas las categorías",
        "Electrónica",
        "Ropa y accesorios",
        "Hogar",
        "Deporte y ocio"
    )

    var expandedLocation by remember { mutableStateOf(false) }
    var selectedLocation by remember { mutableStateOf("Todas las ubicaciones") }

    val locations = listOf(
        "Todas las ubicaciones",
        "Lima",
        "Arequipa",
        "Cusco",
        "Piura",
        "Trujillo"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFF0D0D0D))
    ) {
        Text(
            text = "Explorar ofertas",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 🔽 FILTROS
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            // 🔹 MENÚ DE CATEGORÍAS
            Box {
                Button(
                    onClick = { expandedCategory = !expandedCategory },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB026FF)),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.height(40.dp)
                ) {
                    Text(text = selectedCategory, color = Color.White, fontSize = 14.sp)
                }

                DropdownMenu(
                    expanded = expandedCategory,
                    onDismissRequest = { expandedCategory = false }
                ) {
                    categories.forEach { category ->
                        DropdownMenuItem(
                            text = { Text(category) },
                            onClick = {
                                selectedCategory = category
                                expandedCategory = false
                            }
                        )
                    }
                }
            }

            // 🔹 MENÚ DE UBICACIONES
            Box {
                Button(
                    onClick = { expandedLocation = !expandedLocation },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB026FF)),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.height(40.dp)
                ) {
                    Text(text = selectedLocation, color = Color.White, fontSize = 14.sp)
                }

                DropdownMenu(
                    expanded = expandedLocation,
                    onDismissRequest = { expandedLocation = false }
                ) {
                    locations.forEach { location ->
                        DropdownMenuItem(
                            text = { Text(location) },
                            onClick = {
                                selectedLocation = location
                                expandedLocation = false
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 LISTA DE OFERTAS
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(offers) { offer ->
                OfferCard(offer) {
                    navController.currentBackStackEntry
                        ?.savedStateHandle
                        ?.set("offer", offer)
                    navController.navigate("offer_detail")
                }
            }
        }
    }
}

@Composable
fun OfferCard(offer: OfferModel, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        border = ButtonDefaults.outlinedButtonBorder.copy(
            width = 2.dp,
            brush = Brush.linearGradient(listOf(Color.Magenta, Color(0xFFB026FF)))
        ),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1C1C1C))
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(offer.imageUrl),
                contentDescription = offer.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = offer.title, color = Color.White, fontWeight = FontWeight.Bold)
            Text(text = "${offer.category} • ${offer.location}", color = Color.Gray, fontSize = 13.sp)
        }
    }
}
