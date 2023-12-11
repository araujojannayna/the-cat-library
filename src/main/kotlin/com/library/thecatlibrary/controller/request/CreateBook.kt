package com.library.thecatlibrary.controller.request

data class CreateBook(var title: String,
                      var author: MutableList<String>,
                      var pagesQtde: Int,
                      var availableToChange: Boolean,
                      var availableToSell: Boolean,
                      var stars: Int
)