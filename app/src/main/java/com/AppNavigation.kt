package com

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.screen.AddNoteScreen
import com.screen.NoteDetailScreen
import com.screen.NoteListScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.NoteListRoute
    ){
        composable(Routes.NoteListRoute){
            NoteListScreen(navController)
        }
        composable(Routes.AddNoteRoute){
            AddNoteScreen(navController)
        }
        //use a template(/) also the !! indicates that the empty note will come here
        composable("note-detail/{noteId}"){
                NoteDetailScreen(
                    navController = navController,
                    noteId = it.arguments!!.getString("noteId")!!
                )
        }

    }
}

object Routes{
    val NoteListRoute = "note-list"
    val AddNoteRoute = "add-note"

    fun NoteDetail(noteId : String): String {
        return "note-detail/$noteId"
    }

}
