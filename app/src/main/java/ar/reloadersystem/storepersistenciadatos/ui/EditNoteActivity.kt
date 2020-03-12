package ar.reloadersystem.storepersistenciadatos.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ar.reloadersystem.storepersistenciadatos.R
import ar.reloadersystem.storepersistenciadatos.model.Note
import ar.reloadersystem.storepersistenciadatos.storage.NoteDataSource
import ar.reloadersystem.storepersistenciadatos.storage.NoteDatabase
import kotlinx.android.synthetic.main.activity_edit_note.*

class EditNoteActivity : AppCompatActivity() {

    private var note: Note?=null

    private var name:String?=null
    private var desc:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        verifyExtras()
        editarNota()

        ui()

    }

    private fun ui() {

        btnEditNote.setOnClickListener {
            if(validaForm()){
                editNote()
            }
        }
    }

    private fun editNote() {
        val noteId = note?.id
        val nNote = Note(noteId, name, desc)
        val noteDatabase = NoteDatabase(this)
        val dataSource = NoteDataSource(noteDatabase)
        dataSource.updateNote(nNote)
        finish()

    }

    private fun validaForm(): Boolean {

        name= eteName.text.toString()
        desc= eteDesc.text.toString()

        if(name.isNullOrEmpty()){
            return false
        }

        if(desc.isNullOrEmpty()){
            return false
        }
        return true
    }

    private fun deleteNote() {

        val noteDialogFragment= NoteDialogFragment()
        val bundle= Bundle()
        bundle.putString("TITLE", "Deseas eliminar esta nota")
        bundle.putInt("TYPE", 100)

        noteDialogFragment.arguments= bundle
        noteDialogFragment.show(supportFragmentManager, "dialog")
        //updateNote
    }

    private fun editarNota() {
        note?.let {
            eteName.setText(it.name)
            eteDesc.setText(it.description)
        }
    }

    private fun verifyExtras() {
        intent?.extras?.let {
            note= it.getSerializable("NOTE") as Note
        }
    }


}
