package com.library.thecatlibrary.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Book(@Id @GeneratedValue val id: Int?,
                var title: String,
                var pages: String)