package com.library.thecatlibrary.controllers

import com.library.thecatlibrary.domain.Book
import com.library.thecatlibrary.domain.UpdateBook
import com.library.thecatlibrary.domain.UpdateBookStars
import com.library.thecatlibrary.domain.CreateBook
import com.library.thecatlibrary.service.BookService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/books")
class BookController(var service: BookService) {

    @GetMapping("/{id}")
    fun find(@PathVariable id: Int): Book = service.findBook(id)

    @PostMapping
    fun create(@RequestBody book: CreateBook): Book = service.createBook(book)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody book: UpdateBook): Book = service.updateBook(id, book)

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: Int) = service.removeBook(id)

    @PatchMapping("/{id}")
    fun updateStars(@PathVariable id: Int, @RequestBody boostStars: UpdateBookStars): Book = service.updateBook(id, boostStars)
}