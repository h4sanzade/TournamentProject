package com.materialdesign.tournamentproject

data class Tournament(
    val id: Int,
    val name: String,
    val dateRange: String,
    val type: String,
    val status: String
)