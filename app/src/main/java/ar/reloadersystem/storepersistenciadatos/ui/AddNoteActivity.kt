package ar.reloadersystem.storepersistenciadatos.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ar.reloadersystem.storepersistenciadatos.R
import ar.reloadersystem.storepersistenciadatos.model.Note
import ar.reloadersystem.storepersistenciadatos.storage.NoteDataSource
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    private var name: String? = null
    private var desc: String? = null
    //private var notedataSource:NoteDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        ui()
    }

    private fun ui() {
        btnAddNote.setOnClickListener {
            if (validateForm()) {
                addNote()
                finish()
            }
        }
    }

    private fun validateForm(): Boolean {

        clearForm()
        name = eteName.text.toString().trim()
        desc = eteDesc.text.toString().trim()

        if (name.isNullOrEmpty()) {
            eteName.error = "Campo nombre inválido"
            return false
        }

        if (desc.isNullOrEmpty()) {
            eteDesc.error = "Campo descripción inválido"
        }

        return true
    }

    private fun clearForm() {
        eteName.error = null
        eteDesc.error = null
    }

    private fun addNote() {
        val note = Note(null, name, desc)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
