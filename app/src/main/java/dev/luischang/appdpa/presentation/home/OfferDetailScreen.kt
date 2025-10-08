package dev.luischang.appdpa.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import dev.luischang.appdpa.data.model.OfferModel

@Composable
fun OfferDetailScreen(navController: NavController, offer: OfferModel) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D0D0D))
            .verticalScroll(scrollState)
    ) {
        // 🔙 Flecha superior
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

        // 🖼 Imagen principal del producto
        Image(
            painter = rememberAsyncImagePainter(offer.imageUrl),
            contentDescription = offer.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .padding(horizontal = 16.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 📋 Información del producto
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = offer.title,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 6.dp, bottom = 4.dp)
            ) {
                Text(
                    text = offer.category,
                    color = Color(0xFFB026FF),
                    fontSize = 14.sp,
                    modifier = Modifier
                        .background(Color(0x22B026FF), RoundedCornerShape(12.dp))
                        .padding(horizontal = 10.dp, vertical = 2.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "${offer.location}, Perú",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Publicado por: **Carlos**",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )

            Text(
                text = "Fecha de publicación: 29 de febrero de 2025",
                color = Color.Gray,
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 🧾 Descripción completa
            Text(
                text = "Descripción Completa",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Vendo mi PlayStation 5, versión con lector de discos. Se ha usado muy poco (menos de 50 horas de juego total). Incluye dos mandos DualSense adicionales y los siguientes juegos digitales: Elden Ring, Horizon Forbidden West y Gran Turismo 7.\n\n" +
                        "Busco una laptop de gama media-alta o una bicicleta de montaña de valor similar. Estoy abierto a negociar.",
                color = Color.LightGray,
                fontSize = 14.sp,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 🖼 Imagen referencial (simulada)
            Text(
                text = "Imagen referencial",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = rememberAsyncImagePainter("https://cdn.sstatic.net/Sites/es/Img/apple-touch-icon@2.png"),
                contentDescription = "Imagen referencial",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(Color(0xFF1C1C1C), RoundedCornerShape(10.dp))
                    .padding(8.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 🔘 Botón de propuesta
            Button(
                onClick = { navController.navigate("mis_propuestas") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB026FF))
            ) {
                Text("Enviar Propuesta de Trueque", color = Color.White)
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
