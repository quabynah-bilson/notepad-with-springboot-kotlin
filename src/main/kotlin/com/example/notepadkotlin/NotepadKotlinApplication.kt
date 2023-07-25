package com.example.notepadkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NotepadKotlinApplication

fun main(args: Array<String>) {
    runApplication<NotepadKotlinApplication>(*args)
}
