package com.library.thecatlibrary.extension

import com.library.thecatlibrary.controller.request.CreateBook
import com.library.thecatlibrary.controller.request.UpdateBook
import com.library.thecatlibrary.controller.request.UpdateBookStars
import com.library.thecatlibrary.domain.Book
import com.library.thecatlibrary.repository.entity.BookEntity

fun CreateBook.toBook(): Book {
    return Book(title = this.title,
        author = this.author,
        pagesQtde = this.pagesQtde,
        availableToChange = this.availableToChange,
        availableToSell = this.availableToSell,
        stars = this.stars)
}

fun UpdateBook.toBook(): Book {
    return Book(title = this.title,
        author = this.author,
        pagesQtde = this.pagesQtde,
        availableToChange = this.availableToChange,
        availableToSell = this.availableToSell,
        stars = this.stars)
}

fun UpdateBookStars.toBook(): Book {
    return Book(stars = this.stars)
}

fun BookEntity.toBook(): Book {
    return Book(id = this.id,
        title = this.title,
        author = this.author,
        pagesQtde = this.pagesQtde,
        availableToChange = this.availableToChange,
        availableToSell = this.availableToSell,
        stars = this.stars)
}