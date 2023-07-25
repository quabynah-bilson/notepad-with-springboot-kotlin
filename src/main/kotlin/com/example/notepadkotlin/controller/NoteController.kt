package com.example.notepadkotlin.controller

import com.example.notepadkotlin.entity.NoteEntity
import com.example.notepadkotlin.model.CreateNoteModel
import com.example.notepadkotlin.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1")
class NoteController {
    @Autowired
    lateinit var service: NoteService

    @GetMapping("/notes")
    fun getAllNotes(): ResponseEntity<List<NoteEntity>> = ResponseEntity.ok(service.getAllNotes())

    @GetMapping("/notes/{id}")
    fun getNoteById(@PathVariable id: String): ResponseEntity<NoteEntity> = try {
        val note = service.getNoteById(id)
        ResponseEntity.ok(note)
    } catch (e: RuntimeException) {
        ResponseEntity.notFound().build()
    }

    @PostMapping("/notes")
    fun createNote(
        @RequestBody body: CreateNoteModel
    ): ResponseEntity<NoteEntity> = try {
        ResponseEntity.ok(service.createNote(body))
    } catch (e: RuntimeException) {
        ResponseEntity.badRequest().build()
    }

    @PutMapping("/notes/{id}")
    fun updateNote(
        @RequestBody body: CreateNoteModel,
        @PathVariable id: String
    ): ResponseEntity<NoteEntity> = try {
        ResponseEntity.ok(service.updateNote(body, id))
    } catch (e: RuntimeException) {
        ResponseEntity.notFound().build()
    }

    @DeleteMapping("/notes/{id}")
    fun deleteNoteById(@PathVariable id: String): ResponseEntity<Unit> = try {
        service.deleteNoteById(id)
        ResponseEntity.ok().build()
    } catch (e: RuntimeException) {
        ResponseEntity.notFound().build()
    }

    @DeleteMapping("/notes")
    fun deleteAllNotes(): ResponseEntity<Unit> = try {
        service.deleteAllNotes()
        ResponseEntity.ok().build()
    } catch (e: RuntimeException) {
        ResponseEntity.notFound().build()
    }
}