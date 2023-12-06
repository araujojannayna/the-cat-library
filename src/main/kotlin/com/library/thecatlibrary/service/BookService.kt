package com.library.thecatlibrary.service

import com.library.thecatlibrary.domain.Book
import com.library.thecatlibrary.domain.UpdateBook
import com.library.thecatlibrary.domain.UpdateBookStars
import com.library.thecatlibrary.domain.CreateBook
import com.library.thecatlibrary.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(var repository: BookRepository) {

    fun findBook(id: Int): Book{
        return try {
            repository.findById(id).get()
        } catch (ex: NoSuchElementException){
            generateErrorBook()
        }
    }

    fun createBook(book: CreateBook): Book{
        val entityBook = Book(title = book.title,
            author = book.author,
            pagesQtde = book.pagesQtde,
            availableToChange = book.availableToChange,
            availableToSell = book.availableToSell,
            stars = book.stars,
            id = null)
        return repository.save(entityBook)
    }

    fun updateBook(id: Int, book: UpdateBook): Book{
        return try{
            val actualBook = repository.findById(id).get()
            actualBook.title = book.title ?: actualBook.title
            actualBook.author = book.author ?: actualBook.author
            actualBook.pagesQtde = book.pagesQtde ?: actualBook.pagesQtde
            actualBook.stars = book.stars ?: actualBook.stars
            actualBook.availableToChange = book.availableToChange ?: actualBook.availableToChange
            actualBook.availableToSell = book.availableToSell ?: actualBook.availableToSell
            repository.save(actualBook)
        } catch (ex: NoSuchElementException){
            generateErrorBook()
        }
    }

    fun removeBook(id: Int){
        repository.deleteById(id)
    }

    fun updateBook(bookId: Int, updateBookStars: UpdateBookStars): Book{
        return try{
            val actualBook = repository.findById(bookId).get()
            actualBook.stars = updateBookStars.stars
            repository.save(actualBook)
        } catch (ex: NoSuchElementException){
            generateErrorBook()
        }
    }

    private fun generateErrorBook(): Book =
        Book(id = null, title = "", pagesQtde = 0, availableToChange = false, availableToSell = false, stars = 0, author = mutableListOf())
}