package com.library.thecatlibrary.domain

data class UpdateBook(var title: String?,
                      var author: MutableList<String>?,
                      var pagesQtde: Int?,
                      var availableToChange: Boolean?,
                      var availableToSell: Boolean?,
                      var stars: Int?
)