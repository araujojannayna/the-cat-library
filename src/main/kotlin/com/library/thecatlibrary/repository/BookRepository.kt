package com.library.thecatlibrary.repository

import com.library.thecatlibrary.repository.entity.BookEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<BookEntity, Int>{

    fun findByTitle(title: String): List<BookEntity>

    fun findByAuthor(author: String): List<BookEntity>

    fun findByAvailableToChange(availableToChange: Boolean): List<BookEntity>

    fun findByAvailableToSell(availableToSell: Boolean): List<BookEntity>

}