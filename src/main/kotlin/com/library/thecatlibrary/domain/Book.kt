package com.library.thecatlibrary.domain


data class Book(val id: Int? = null,
                var title: String? = null,
                var author: MutableList<String>? = null,
                var pagesQtde: Int? = null,
                var availableToChange: Boolean? = null,
                var availableToSell: Boolean? = null,
                var stars: Int? = null
)