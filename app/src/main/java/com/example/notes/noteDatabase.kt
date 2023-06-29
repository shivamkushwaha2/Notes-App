package com.example.notes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
abstract class noteDatabase:RoomDatabase() {
abstract fun getNoteDao(): noteDao
companion object {
    @Volatile
    private var INSTANCE: noteDatabase? = null

    fun getDatabase(context: Context): noteDatabase {
        // if the INSTANCE is not null, then return it,
        // if it is, then create the database
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                noteDatabase::class.java,
                "word_database"
            ).build()
            INSTANCE = instance
            // return instance
            instance
        }
    }

}
}