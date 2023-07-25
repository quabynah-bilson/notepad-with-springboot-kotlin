package com.example.notepadkotlin.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.*

@Entity(name = "notes")
data class NoteEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,
    var title: String,
    var description: String
)
