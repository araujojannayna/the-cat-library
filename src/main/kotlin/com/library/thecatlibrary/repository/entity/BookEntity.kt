package com.library.thecatlibrary.repository.entity

import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class BookEntity(@Id @GeneratedValue val id: Int?,
                      var title: String,
                      @ElementCollection
                      var author: MutableList<String>,
                      var pagesQtde: Int,
                      var availableToChange: Boolean,
                      var availableToSell: Boolean,
                      var stars: Int
)