package com.library.thecatlibrary.controller.request

import com.library.thecatlibrary.domain.Book

data class UpdateBookStars(var stars: Int){
    fun toBook(): Book {
        return Book(stars = this.stars)
    }
}