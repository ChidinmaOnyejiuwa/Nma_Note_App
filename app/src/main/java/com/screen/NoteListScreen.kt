package com.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.AppNavigation
import com.Routes
import com.component.NoteItem
import com.models.Note
import com.view_model.NoteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteListScreen(navController: NavController){
    //used to access avie model so create a view model instance
    //it has the history of all the view model you have created
    val nViewModel : NoteViewModel = viewModel()
    val listOfNotes by nViewModel.getAllNotes().observeAsState(emptyList())

    //val noteListRoute ="add_note"

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Nma Notepad") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Search,
                            contentDescription = "Search for Note")
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.MoreVert,
                            contentDescription = "More Icon")
                    }
                }
            )
        },
        content= {paddingValues ->
            //lazycolumn helps us with lists that comes during run time
            LazyColumn (
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ){
                //NOTE ITEMS WILL BE ADDED HERE
               items(listOfNotes){note ->
                   NoteItem(note = note, navController = navController)
               }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {navController
                .navigate(Routes.AddNoteRoute) }) {
                Icon(imageVector =Icons.Default.Add,
                    contentDescription = "Add New Note")
            }
        }
    )
}

@Preview
@Composable
fun NoteListScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        AppNavigation()
    }
}