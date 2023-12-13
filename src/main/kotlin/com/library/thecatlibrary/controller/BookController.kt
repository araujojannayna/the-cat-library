package com.library.thecatlibrary.controller

import com.library.thecatlibrary.repository.entity.BookEntity
import com.library.thecatlibrary.controller.request.UpdateBook
import com.library.thecatlibrary.controller.request.UpdateBookStars
import com.library.thecatlibrary.controller.request.CreateBook
import com.library.thecatlibrary.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController(val service: BookService) {

    @GetMapping("/{id}")
    fun find(@PathVariable id: Int): BookEntity = service.findBook(id)

    @GetMapping
    fun findByFilter(@RequestParam title: String?,
                     @RequestParam author: String?,
                     @RequestParam availableToChange: Boolean?,
                     @RequestParam availableToSell: Boolean?): List<BookEntity> = service.findBookByFilter(title, author, availableToChange, availableToSell)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody book: CreateBook): BookEntity = service.createBook(book)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody book: UpdateBook): BookEntity = service.updateBook(id, book)

    @PatchMapping("/{id}")
    fun updateStars(@PathVariable id: Int, @RequestBody boostStars: UpdateBookStars): BookEntity = service.updateBook(id, boostStars)

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: Int) = service.removeBook(id)
}