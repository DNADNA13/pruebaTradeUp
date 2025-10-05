package dev.luischang.appdpa.data.model


import java.io.Serializable

data class OfferModel (
    val title: String,
    val category: String,
    val location: String,
    val imageUrl: String
) : Serializable