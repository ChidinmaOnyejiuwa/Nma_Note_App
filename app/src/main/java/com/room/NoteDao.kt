package com.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.models.Note

@Dao
interface NoteDao {

    @Insert
    //suspend helps with asycronous operation
    //saving note should not be done on the main thread that why the
    // suspend was put in place
     suspend fun saveNote(note: Note)

     //helps to fetch all the note in the database
     @Query("select * from notes order by id DESC")
     fun fetchNotes (): LiveData<List<Note>>

     //query to edit a note by id
     @Query("SELECT*FROM notes WHERE id = :noteId")
     fun fetchNote(noteId:String) :LiveData<Note>

     //query to delete a note by id
     @Delete
     suspend fun deleteNote(note : Note )

     @Update
     suspend fun updateNote(note: Note)
}