package ar.reloadersystem.storepersistenciadatos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ar.reloadersystem.storepersistenciadatos.ui.AddNoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ui()

    }

    private fun ui() {

        floatingActionButton.setOnClickListener {
            goToAddNote()
        }

    }

    private fun goToAddNote() {

        startActivity(Intent(this, AddNoteActivity::class.java))
    }
}
