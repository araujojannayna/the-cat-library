package com.library.thecatlibrary.service

import com.library.thecatlibrary.repository.entity.BookEntity
import com.library.thecatlibrary.domain.Book
import com.library.thecatlibrary.extension.toBook
import com.library.thecatlibrary.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepository) {

    fun findBook(id: Int): Book {
        return try {
            repository.findById(id).get().toBook()
        } catch (ex: NoSuchElementException){
            generateErrorBook()
        }
    }

    fun createBook(book: Book): Book {
        val entityBookEntity = BookEntity(title = book.title!!,
            author = book.author!!,
            pagesQtde = book.pagesQtde!!,
            availableToChange = book.availableToChange!!,
            availableToSell = book.availableToSell!!,
            stars = book.stars!!)
        return repository.save(entityBookEntity).toBook()
    }

    fun updateBook(id: Int, book: Book): Book {
        return try{
            val actualBook = repository.findById(id).get()
            actualBook.title = book.title ?: actualBook.title
            actualBook.author = book.author ?: actualBook.author
            actualBook.pagesQtde = book.pagesQtde ?: actualBook.pagesQtde
            actualBook.stars = book.stars ?: actualBook.stars
            actualBook.availableToChange = book.availableToChange ?: actualBook.availableToChange
            actualBook.availableToSell = book.availableToSell ?: actualBook.availableToSell
            repository.save(actualBook).toBook()
        } catch (ex: NoSuchElementException){
            generateErrorBook()
        }
    }

    fun removeBook(id: Int){
        repository.deleteById(id)
    }

    private fun generateErrorBook(): Book =
        Book(title = "", pagesQtde = 0, availableToChange = false, availableToSell = false, stars = 0, author = mutableListOf())

    fun findBookByFilter(title: String?, author: String?, availableToChange: Boolean?, availableToSell: Boolean?): List<Book> {
        title?.let { return repository.findByTitle(title).map { it.toBook() } }
        author?.let { return repository.findByAuthor(author).map { it.toBook() } }
        availableToChange?.let { return repository.findByAvailableToChange(availableToChange).map { it.toBook() } }
        availableToSell?.let { return repository.findByAvailableToSell(availableToSell).map { it.toBook() } }
        return listOf(generateErrorBook())
    }
}