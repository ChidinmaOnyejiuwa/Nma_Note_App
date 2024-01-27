package com.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.models.Note

@Dao
interface NoteDao {

    @Insert
    //suspend helps with asycronous operation
    //saving note should not be done on the main thread that why the
    // suspend was put in place
     suspend fun saveNote(note: Note)

     //helps to fetch all the note in the database
     @Query("select * from notes")
     fun fetchNotes (): LiveData<List<Note>>

     @Query("SELECT*FROM notes WHERE id = :noteId")
     fun fetchNote(noteId:String) :LiveData<Note>

     @Delete
     suspend fun deleteNote(note : Note )
}