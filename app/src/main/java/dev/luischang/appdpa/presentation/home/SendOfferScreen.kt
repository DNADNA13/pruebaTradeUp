package dev.luischang.appdpa.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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

@Composable
fun SendOfferScreen(navController: NavController) {
    var ofertaTexto by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D0D0D))
            .padding(16.dp)
    ) {

        // 🔙 Flecha de regreso y título
        Row(
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
                text = "Mis propuestas",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            text = "Envía tu oferta y comienza la negociación",
            color = Color.LightGray,
            fontSize = 14.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 🧾 Tarjeta con detalles del producto
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter("https://cdn-icons-png.flaticon.com/512/433/433087.png"),
                    contentDescription = "Producto",
                    modifier = Modifier
                        .size(64.dp)
                        .padding(end = 12.dp),
                    contentScale = ContentScale.Crop
                )

                Column {
                    Text(
                        text = "Control inalámbrico RGB",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Categoría: Electrónica — Publicado por: Pepito",
                        color = Color.LightGray,
                        fontSize = 13.sp
                    )
                    Text(
                        text = "Disponible",
                        color = Color(0xFF00FF88),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        // Campo de texto para la descripción de la propuesta
        OutlinedTextField(
            value = ofertaTexto,
            onValueChange = { ofertaTexto = it },
            placeholder = { Text("Ej: Te doy este mando adicional + 2 juegos físicos...") },
            label = { Text("Describe tu oferta (qué ofreces a cambio)") },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedBorderColor = Color(0xFFB026FF),
                unfocusedBorderColor = Color.DarkGray,
                cursorColor = Color(0xFFB026FF)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 🔘 Botones Enviar / Cancelar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { /* Acción enviar */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB026FF)),
                modifier = Modifier.weight(1f)
            ) {
                Text("Enviar propuesta", color = Color.White)
            }

            Spacer(modifier = Modifier.width(8.dp))

            OutlinedButton(
                onClick = { navController.popBackStack() },
                border = ButtonDefaults.outlinedButtonBorder.copy(width = 1.dp),
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
            ) {
                Text("Cancelar")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Al enviar, el propietario recibirá una notificación.\nEstado inicial: Pendiente",
            color = Color.LightGray,
            fontSize = 13.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 🧾 Código QR (imagen simulada)
        Image(
            painter = rememberAsyncImagePainter("https://upload.wikimedia.org/wikipedia/commons/8/8f/Qr-Example.svg"),
            contentDescription = "Código QR",
            modifier = Modifier
                .size(160.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 📤 Botón compartir
        Button(
            onClick = { /* Acción compartir */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB026FF)),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Compartir", color = Color.White)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Si ocurre un error, verás un mensaje claro aquí.",
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}
