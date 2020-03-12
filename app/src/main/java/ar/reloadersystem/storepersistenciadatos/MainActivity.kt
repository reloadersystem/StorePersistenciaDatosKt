package ar.reloadersystem.storepersistenciadatos

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ar.reloadersystem.storepersistenciadatos.model.Note
import ar.reloadersystem.storepersistenciadatos.storage.NoteDataSource
import ar.reloadersystem.storepersistenciadatos.storage.NoteDatabase
import ar.reloadersystem.storepersistenciadatos.ui.AddNoteActivity
import ar.reloadersystem.storepersistenciadatos.ui.EditNoteActivity
import ar.reloadersystem.storepersistenciadatos.ui.NoteAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var listNotes: List<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ui()
    }

    private fun ui() {

        val noteDatabase = NoteDatabase(this)
        val dataSource = NoteDataSource(noteDatabase)
        listNotes = dataSource.notes()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = NoteAdapter(listNotes) { itNote ->

            showMessage(itNote.name.toString())

            goToEditNote(itNote)
        }

        floatingActionButton.setOnClickListener {
            goToAddNote()
        }
    }

    private fun goToEditNote(note: Note) {
        val bundle = Bundle()
        bundle.putSerializable("NOTE", note)

        val intent = Intent(this, EditNoteActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }


    private fun showMessage(message: String) {
        Toast.makeText(this, "item $message", Toast.LENGTH_SHORT).show()
    }

    private fun goToAddNote() {

        startActivity(Intent(this, AddNoteActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
    }
}
