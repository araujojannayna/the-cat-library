package com.library.thecatlibrary.repository

import com.library.thecatlibrary.domain.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CrudRepository<Book, Int>