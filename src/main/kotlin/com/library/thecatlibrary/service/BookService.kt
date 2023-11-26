package com.library.thecatlibrary.service

import com.library.thecatlibrary.domain.Book
import com.library.thecatlibrary.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(var repository: BookRepository) {

    fun findBook(id: Int): Book{
        return repository.findById(id).get()
    }

    fun createBook(book: Book): Book{
        return repository.save(book)
    }
}