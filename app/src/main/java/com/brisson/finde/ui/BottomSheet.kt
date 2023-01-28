package com.brisson.finde.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brisson.finde.ui.theme.FindeTheme

@Composable
fun CreateNoteBottomSheet(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        var value by remember {
            mutableStateOf("")
        }

        BasicTextField(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(MaterialTheme.colors.surface)
                .fillMaxWidth()
                .height(200.dp),
            value = value,
            onValueChange = { newText ->
                value = newText
            },
            textStyle = TextStyle(),
            cursorBrush = Brush.verticalGradient(listOf(Color.Cyan, Color.Green)),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    if (value.isEmpty()) {
                        Text("Tell us something...", style = TextStyle(color = Color.Gray))
                    } else {
                        innerTextField()
                    }
                }
            }
        )

        TextButton(modifier = Modifier.fillMaxWidth(), onClick = { /*TODO*/ }) {
            Text(text = "create post")
        }
    }
}

@Preview
@Composable
fun PreviewCreateNoteBottomSheet() {
    FindeTheme {
        CreateNoteBottomSheet()
    }
}