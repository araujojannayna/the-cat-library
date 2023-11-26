package com.library.thecatlibrary.service

import com.library.thecatlibrary.domain.Book
import com.library.thecatlibrary.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(var repository: BookRepository) {

    fun findBook(id: Int): Book{
        return try {
            repository.findById(id).get()
        } catch (ex: NoSuchElementException){
            Book(id = null, title = "", pagesQtde = 0)
        }
    }

    fun createBook(book: Book): Book{
        return repository.save(book)
    }

    fun updateBook(book: Book): Book{
        return try{
            val actualBook = repository.findById(book.id!!).get()
            actualBook.title = book.title
            actualBook.pagesQtde = book.pagesQtde
            repository.save(actualBook)
        } catch (ex: NoSuchElementException){
            Book(id = null, title = "", pagesQtde = 0)
        }
    }

    fun removeBook(id: Int){
        repository.deleteById(id)
    }
}