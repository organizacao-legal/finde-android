package com.brisson.finde.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brisson.finde.compactDecimalFormat
import com.brisson.finde.formatLongToDate
import com.brisson.finde.ui.theme.FindeTheme

@Composable
fun Note(
    modifier: Modifier = Modifier,
    upvoteCount: Int = 0,
    timeStamp: Long,
    onUpvote: () -> Unit,
    onReply: () -> Unit,
    onShare: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(vertical = 24.dp, horizontal = 16.dp)

    ) {
        Text(text = "From the chef’s table to restuarants for singles, modern cuisine gets creative")
        Row(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NoteItem(
                icon = Icons.Rounded.KeyboardArrowUp,
                text = compactDecimalFormat(upvoteCount.toLong()),
                onClick = onUpvote,
                iconColor = MaterialTheme.colors.primary
            )
            NoteItem(
                icon = Icons.Rounded.InsertComment,
                text = "reply",
                onClick = onReply
            )
            NoteItem(
                icon = Icons.Rounded.Share,
                text = "share",
                onClick = onShare
            )
            NoteItem(
                icon = Icons.Rounded.HourglassEmpty,
                text = formatLongToDate(timeStamp).toString(),
                onClick = {},
            )
        }
    }
}

@Composable
private fun NoteItem(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconColor: Color = Color.Gray,
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier.clickable { onClick() }, verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            tint = iconColor,
            contentDescription = "",
            modifier = Modifier
                .size(width = 16.dp, height = 16.dp)
        )
        Text(modifier = Modifier.padding(start = 2.dp), text = text, color = Color.Gray)
    }
}

@Composable
fun ReplyItem(modifier: Modifier = Modifier) {
    Row(modifier = modifier.height(IntrinsicSize.Max).background(MaterialTheme.colors.background)) {
        Box(
            modifier = Modifier
                .width(2.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(topEnd = 2.dp, bottomEnd = 2.dp))
                .background(Color.LightGray)
        )
        Text(
            modifier = Modifier.padding(6.dp),
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore"
        )
    }
}

@Preview
@Composable
fun PreviewNote() {
    FindeTheme {
        Note(
            upvoteCount = 3000000,
            onUpvote = {},
            onReply = {},
            onShare = {},
            timeStamp = System.currentTimeMillis()
        )
    }
}

@Preview
@Composable
fun PreviewReplyItem() {
    FindeTheme {
        ReplyItem()
    }
}