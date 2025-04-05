package com.example.mysystemtest.domain.model

data class DashboardModel(
    val sectionType: String,
    val items: List<Item>
)

data class Item(
    val title: String,
    val image: String
)
