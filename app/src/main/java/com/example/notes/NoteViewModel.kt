package com.example.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) :AndroidViewModel(application) {
    val allNotes:LiveData<List<Note>>
    val repository:NoteRepository
    init {
        val dao = noteDatabase.getDatabase(application).getNoteDao()
        repository = NoteRepository(dao)
        allNotes=repository.allNotes
    }
  fun deletenote(note: Note)= viewModelScope.launch(Dispatchers.IO){
        repository.delete(note)
    }
    fun insertnote(note: Note)= viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }
}