package ar.reloadersystem.storepersistenciadatos.storage

import ar.reloadersystem.storepersistenciadatos.model.Note

interface DataSource {
    fun notes():List<Note>
    fun addNote(note: Note)
    fun updateNote(note: Note):Int
    fun deleteNote(note:Note):Int
}