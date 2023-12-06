package com.library.thecatlibrary.domain

import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Book(@Id @GeneratedValue val id: Int?,
                var title: String,
                @ElementCollection
                var author: MutableList<String>,
                var pagesQtde: Int,
                var availableToChange: Boolean,
                var availableToSell: Boolean,
                var stars: Int
)