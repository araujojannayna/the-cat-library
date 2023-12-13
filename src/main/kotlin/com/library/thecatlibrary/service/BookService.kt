package com.library.thecatlibrary.service

import com.library.thecatlibrary.repository.entity.BookEntity
import com.library.thecatlibrary.controller.request.UpdateBook
import com.library.thecatlibrary.controller.request.UpdateBookStars
import com.library.thecatlibrary.controller.request.CreateBook
import com.library.thecatlibrary.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepository) {

    fun findBook(id: Int): BookEntity {
        return try {
            repository.findById(id).get()
        } catch (ex: NoSuchElementException){
            generateErrorBook()
        }
    }

    fun createBook(book: CreateBook): BookEntity {
        val entityBookEntity = BookEntity(title = book.title,
            author = book.author,
            pagesQtde = book.pagesQtde,
            availableToChange = book.availableToChange,
            availableToSell = book.availableToSell,
            stars = book.stars,
            id = null)
        return repository.save(entityBookEntity)
    }

    fun updateBook(id: Int, book: UpdateBook): BookEntity {
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

    fun updateBook(bookId: Int, updateBookStars: UpdateBookStars): BookEntity {
        return try{
            val actualBook = repository.findById(bookId).get()
            actualBook.stars = updateBookStars.stars
            repository.save(actualBook)
        } catch (ex: NoSuchElementException){
            generateErrorBook()
        }
    }

    private fun generateErrorBook(): BookEntity =
        BookEntity(id = null, title = "", pagesQtde = 0, availableToChange = false, availableToSell = false, stars = 0, author = mutableListOf())

    fun findBookByFilter(title: String?, author: String?, availableToChange: Boolean?, availableToSell: Boolean?): List<BookEntity> {
        title?.let { return repository.findByTitle(title) }
        author?.let { return repository.findByAuthor(author) }
        availableToChange?.let { return repository.findByAvailableToChange(availableToChange) }
        availableToSell?.let { return repository.findByAvailableToSell(availableToSell) }
        return listOf(generateErrorBook())
    }
}