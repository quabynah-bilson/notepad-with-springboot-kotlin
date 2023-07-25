package com.example.notepadkotlin.service

import com.example.notepadkotlin.entity.NoteEntity
import com.example.notepadkotlin.model.CreateNoteModel
import com.example.notepadkotlin.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class NoteService {
    @Autowired
    lateinit var repository: NoteRepository

    fun getAllNotes(): List<NoteEntity> = repository.findAll()

    fun getNoteById(id: String): NoteEntity = repository.findById(UUID.fromString(id)).orElseThrow()

    fun createNote(model: CreateNoteModel): NoteEntity =
        try {
            repository.save(NoteEntity(UUID.randomUUID(), model.title, model.description))
        } catch (e: RuntimeException) {
            throw e
        }

    fun updateNote(model: CreateNoteModel, id: String) =
        try {
            val note = getNoteById(id)
            note.title = model.title
            note.description = model.description
            repository.save(note)
        } catch (e: RuntimeException) {
            throw e
        }

    fun deleteNoteById(id: String) = try {
        repository.deleteById(UUID.fromString(id))
    } catch (e: RuntimeException) {
        throw e
    }

    fun deleteAllNotes() = repository.deleteAll()
}