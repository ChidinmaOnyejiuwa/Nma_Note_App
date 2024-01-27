package com.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.Routes
import com.models.Note

@Composable
fun NoteItem(note : Note,navController: NavController){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        //you can change the $ note.id to (note.id.tostring())
        .clickable { navController.navigate(Routes.NoteDetail("${note.id}")) }
    )
    {
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            Text(text = note.title,
                fontWeight = FontWeight.Black,
                maxLines = 3
            )
            Text(
                text = note.content,
                maxLines = 4
                )
        }
    }

}
