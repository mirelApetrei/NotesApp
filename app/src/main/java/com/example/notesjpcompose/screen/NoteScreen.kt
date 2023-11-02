package com.example.notesjpcompose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesjpcompose.R
import com.example.notesjpcompose.components.NoteButton
import com.example.notesjpcompose.components.NoteInputText

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun NoteScreen() {
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
                onTextChange = {},
                modifier = Modifier.padding(4.dp))

            NoteInputText(
                text = description,
                label = "Add a note",
                maxLine = 1,
                onTextChange = {},
                modifier = Modifier.padding(8.dp))

            NoteButton(text = "Save", onClick = { /*TODO*/ })
        }

    }
}


@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {
    NoteScreen()
}