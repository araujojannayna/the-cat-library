package com.library.thecatlibrary.domain

data class CreateBook(var title: String,
                      var author: MutableList<String>,
                      var pagesQtde: Int,
                      var availableToChange: Boolean,
                      var availableToSell: Boolean,
                      var stars: Int
)