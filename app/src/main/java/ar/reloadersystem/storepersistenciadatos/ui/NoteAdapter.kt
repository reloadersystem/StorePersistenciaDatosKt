package ar.reloadersystem.storepersistenciadatos.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.reloadersystem.storepersistenciadatos.R
import ar.reloadersystem.storepersistenciadatos.model.Note
import kotlinx.android.synthetic.main.row_note.view.*

class NoteAdapter(
    private var notes: List<Note>,
    private val itemCallback: (note: Note) -> Unit?
) : RecyclerView.Adapter<
        NoteAdapter.NoteViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.row_note,
            parent, false
        )
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {

        holder.bind(notes[position])

        holder.view.setOnClickListener {
            itemCallback(notes[position])
        }
    }

    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(note: Note) {
            view.tviName.text = note.name
        }
    }

    fun update(data:List<Note>){
        notes= data
        notifyDataSetChanged()
        //DiffUtils
    }

}