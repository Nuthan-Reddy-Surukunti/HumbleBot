package com.humblecoders.humblebot.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.humblecoders.humblebot.model.ChatMessage
import com.humblecoders.humblebot.ui.theme.*

@Composable
fun MessageBubble(
    message: ChatMessage,
    modifier: Modifier = Modifier
) {
    val isDarkTheme = isSystemInDarkTheme()

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 4.dp),
        horizontalArrangement = if (message.isFromUser) Arrangement.End else Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .widthIn(max = 280.dp)
                .clip(
                    if (message.isFromUser) {
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomStart = 20.dp,
                            bottomEnd = 4.dp
                        )
                    } else {
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                            bottomStart = 4.dp,
                            bottomEnd = 20.dp
                        )
                    }
                )
                .background(
                    color = if (message.isFromUser) {
                        if (isDarkTheme) DarkUserBubble else UserBubble
                    } else {
                        if (isDarkTheme) DarkAIBubble else AIBubble
                    }
                )
                .padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Text(
                text = message.text,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 16.sp,
                    lineHeight = 22.sp
                ),
                color = if (message.isFromUser) {
                    if (isDarkTheme) DarkOnUserBubble else OnUserBubble
                } else {
                    if (isDarkTheme) DarkOnAIBubble else OnAIBubble
                }
            )
        }
    }
}

