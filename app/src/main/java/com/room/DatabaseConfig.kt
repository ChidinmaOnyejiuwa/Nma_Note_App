package com.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.models.Note

object DatabaseConfig {
    fun getInstance(context : Context) : AppDataBase{
        var db =  Room.databaseBuilder(
            context,
            AppDataBase::class.java,
            //note_db is the name of the database
            "note_db"
        ).build()
        return db
    }
}

// we connect 3 things
// table(an entity and the columns it will contain found in the NOTE.KT)
// dao(specify the operation to be perform in the database)
// database(specify the entity it can have)
@Database(entities = [Note::class],version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun noteDao(): NoteDao
}