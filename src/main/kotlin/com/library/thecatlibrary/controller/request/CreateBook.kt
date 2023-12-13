package com.library.thecatlibrary.controller.request

import com.library.thecatlibrary.domain.Book

data class CreateBook(var title: String,
                      var author: MutableList<String>,
                      var pagesQtde: Int,
                      var availableToChange: Boolean,
                      var availableToSell: Boolean,
                      var stars: Int
){
    fun toBook(): Book{
        return Book(title = this.title,
                    author = this.author,
                    pagesQtde = this.pagesQtde,
                    availableToChange = this.availableToChange,
                    availableToSell = this.availableToSell,
                    stars = this.stars)
    }
}