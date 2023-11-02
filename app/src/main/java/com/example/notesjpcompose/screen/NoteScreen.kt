package com.example.notesjpcompose.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesjpcompose.R
import com.example.notesjpcompose.components.NoteButton
import com.example.notesjpcompose.components.NoteInputText
import com.example.notesjpcompose.data.NotesDataSource
import com.example.notesjpcompose.model.Note
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun NoteScreen(
    notes: List<Note>,
    onAddNote: (Note) -> Unit,
    onRemoveNote: (Note) -> Unit
) {
    // Variables
        var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }


    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        }, actions = {
            Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "Icon")
        },
            colors = TopAppBarDefaults.largeTopAppBarColors(
                containerColor = Color(0xFFDADFE3),
                titleContentColor = Color.Black)
        )

        // Content
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            NoteInputText(
                text = title,
                label = "Title",
                maxLine = 1,
                onTextChange = {
                       if (it.all { char ->
                               char.isLetter() || char.isWhitespace()
                       }) title = it
                },
                modifier = Modifier.padding(4.dp))

            NoteInputText(
                text = description,
                label = "Add a note",
                maxLine = 1,
                onTextChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) description = it
                },
                modifier = Modifier.padding(8.dp))

            NoteButton(text = "Save",
                onClick = {
                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        // save/ add to a list

                        title = ""
                        description = ""
                    }
                 })
        }
        Divider(modifier = Modifier.padding(12.dp))

        LazyColumn {
            items(notes) { note ->
                NoteRow(note = note, onNoteClicked = {})
            }
        }
    }
}

@Composable
fun NoteRow(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit
) {
    Surface(
        modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(topEnd = 36.dp, bottomEnd = 16.dp))
            .fillMaxWidth()
    ) {
        Column(modifier
            .clickable { }
            .padding(
                horizontal = 14.dp,
                vertical = 8.dp
            ),
            horizontalAlignment = Alignment.Start) {
            Text(
                text = note.title,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = note.description,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = note.entryPoint.format(DateTimeFormatter.ofPattern("EEE, d MMM")),
                style = MaterialTheme.typography.bodySmall
            )

        }
    }
 }



@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen(notes = NotesDataSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
}