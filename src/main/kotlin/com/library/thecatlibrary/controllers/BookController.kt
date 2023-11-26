package com.library.thecatlibrary.controllers

import com.library.thecatlibrary.domain.Book
import com.library.thecatlibrary.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(var service: BookService) {

    @GetMapping("/{id}")
    fun find(@PathVariable id: Int): Book{
        return service.findBook(id)
    }

    @PostMapping
    fun create(@RequestBody book: Book): Book{
        return service.createBook(book)
    }
}