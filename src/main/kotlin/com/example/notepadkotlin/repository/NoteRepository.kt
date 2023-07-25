package com.example.notepadkotlin.repository

import com.example.notepadkotlin.entity.NoteEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface NoteRepository : JpaRepository<NoteEntity, UUID>