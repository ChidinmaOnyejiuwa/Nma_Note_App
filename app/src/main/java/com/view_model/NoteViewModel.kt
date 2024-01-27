package com.view_model

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.models.Note
import com.room.AppDataBase
import com.room.DatabaseConfig
import kotlinx.coroutines.launch

class NoteViewModel(val applicationn: Application) : AndroidViewModel(applicationn) {
    //calling the save function
   private var db = DatabaseConfig.getInstance(applicationn)


    fun saveNote(title : String, content:String){
        // you can change the && sign to //(or) sign
        //the or implies that no note will be save if the title or content is empty
        // && note will be save even if content or title is empty
        if(title.isNullOrEmpty() && content.isNullOrEmpty())return
        //creating a note instance
        val note = Note(
            title = title,
            content = content)

            viewModelScope.launch{
                db.noteDao().saveNote(note)
            }
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return db.noteDao().fetchNotes()
    }
    fun getNote(noteId: String): LiveData<Note>{
        return db.noteDao().fetchNote(noteId)
    }
    fun deleteNote (note: Note){
        viewModelScope.launch{
            db.noteDao().deleteNote(note)
        }
    }
}
