package com.library.thecatlibrary.repository.entity

import com.library.thecatlibrary.domain.Book
import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class BookEntity(@Id @GeneratedValue val id: Int? = null,
                      var title: String,
                      @ElementCollection
                      var author: MutableList<String>,
                      var pagesQtde: Int,
                      var availableToChange: Boolean,
                      var availableToSell: Boolean,
                      var stars: Int
){
    fun toBook(): Book {
        return Book(id = this.id,
            title = this.title,
            author = this.author,
            pagesQtde = this.pagesQtde,
            availableToChange = this.availableToChange,
            availableToSell = this.availableToSell,
            stars = this.stars)
    }
}