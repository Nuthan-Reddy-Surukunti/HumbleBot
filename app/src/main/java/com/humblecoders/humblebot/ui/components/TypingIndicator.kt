package com.humblecoders.humblebot.ui.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TypingIndicator(
    modifier: Modifier = Modifier,
    dotColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(3) { index ->
            DotIndicator(
                dotColor = dotColor,
                delay = index * 150
            )
        }
    }
}

@Composable
private fun DotIndicator(
    dotColor: Color,
    delay: Int
) {
    val infiniteTransition = rememberInfiniteTransition(label = "dot_animation")

    val scale by infiniteTransition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 600,
                delayMillis = delay,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "dot_scale"
    )

    Box(
        modifier = Modifier
            .size(8.dp)
            .scale(scale)
            .background(
                color = dotColor,
                shape = CircleShape
            )
    )
}

