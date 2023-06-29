package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface noteDao {
@Insert(onConflict = OnConflictStrategy.IGNORE)
suspend fun insert(note: Note)
@Delete
suspend fun delete(note: Note)
@Query("Select * from notestable order by id ASC")
fun getallnotes(): LiveData<List<Note>>

}