package dev.luischang.appdpa.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import dev.luischang.appdpa.data.model.OfferModel
import androidx.navigation.NavController

@Composable
fun OfferDetailScreen(navController: NavController, offer: OfferModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D0D0D))
    ) {
        // 🔙 Flecha y título superior
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = Color.White
                )
            }

            Text(
                text = "Detalles de la oferta",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        // 🖼 Imagen principal
        Image(
            painter = rememberAsyncImagePainter(offer.imageUrl),
            contentDescription = offer.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(horizontal = 16.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 📋 Información del producto
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = offer.title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "${offer.category} • ${offer.location}",
                color = Color(0xFFB026FF),
                fontSize = 15.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Descripción de la oferta:\n\nAquí puedes mostrar los detalles del producto, su estado, condiciones de intercambio o información adicional.",
                color = Color.LightGray,
                fontSize = 15.sp
            )
        }
    }
}
