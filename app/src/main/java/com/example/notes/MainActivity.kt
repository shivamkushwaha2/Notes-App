package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

lateinit var viewModel: NoteViewModel


class MainActivity : AppCompatActivity(), rv {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycle.layoutManager=LinearLayoutManager(this)
        val adapter = myadapter(this,this)
        recycle.adapter=adapter



        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)

        viewModel.allNotes.observe(this, Observer { list->
            list?.let {

                adapter.update(it)
            }
        }

        ) }

    override fun onitemclick(note: Note) {
    viewModel.deletenote(note)
        Toast.makeText(this,"Note Deleted",Toast.LENGTH_SHORT).show()

    }

    fun submit(view: View) {
        val notetext = input.text.toString()
        if(notetext.isNotEmpty()){
            viewModel.insertnote(Note(notetext))
        }
        input.text.clear()
        Toast.makeText(this,"Note Inserted",Toast.LENGTH_SHORT).show()
    }
}