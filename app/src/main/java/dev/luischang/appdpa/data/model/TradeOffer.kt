package dev.luischang.appdpa.data.model

import java.io.Serializable

data class TradeOffer(
    val id: Int,
    val offerTitle: String,          // Ej: "Zapatillas deportivas Nike"
    val recipientName: String,       // Ej: "Lucía"
    val category: String,            // Ej: "Ropa"
    val yourOfferDetail: String,     // Ej: "Talla 40, poco uso, casi nuevas"
    val status: String,              // Ej: "Aceptada", "Pendiente"
    val responseTime: String,        // Ej: "Hace 5 minutos"
    val imageUrl: String,            // Imagen del producto o referencia
) : Serializable