package com.example.notesjpcompose.data

import com.example.notesjpcompose.model.Note

class NotesDataSource {
    fun loadNotes(): List<Note> {
        println("loadNotes() called")
        return listOf(
            Note(
                title = "A good day",
                description = "We went on vacation on the lake"
            ),
            Note(
                title = "Note 2",
                description = "Description 2"
            ),
            Note(
                title = "Note 3",
                description = "Description 3"
            ),
            Note(
                title = "Note 4",
                description = "Description 4"
            ),
            Note(
                title = "Note 5",
                description = "Description 5"
            ),
            Note(
                title = "Note 6",
                description = "Description 6"
            ),
            Note(
                title = "Note 7",
                description = "Description 7"
            ),
            Note(
                title = "Note 8",
                description = "Description 8"
            ),
            Note(
                title = "Note 9",
                description = "Description 9"
            ),
            Note(
                title = "Note 10",
                description = "Description 10"
            ),
            Note(
                title = "Note 11",
                description = "Description 11"
            ),
            Note(
                title = "Note 12",
                description = "Description 12"
            ),
            Note(
                title = "Note 13",
                description = "Description 13"
            ),
            Note(
                title = "Note 14",
                description = "Description 14"
            ))
    }
}