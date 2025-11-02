package com.humblecoders.humblebot.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmptyState(
    onSuggestedPromptClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "👋",
            style = MaterialTheme.typography.displayLarge.copy(
                fontSize = 72.sp
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Hello! I'm HumbleBot",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "How can I help you today?",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Try asking me:",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SuggestedPromptChip(
                text = "Tell me a fun fact",
                onClick = { onSuggestedPromptClick("Tell me a fun fact") }
            )
            SuggestedPromptChip(
                text = "Help me with coding",
                onClick = { onSuggestedPromptClick("Help me with coding") }
            )
            SuggestedPromptChip(
                text = "Explain quantum computing",
                onClick = { onSuggestedPromptClick("Explain quantum computing") }
            )
            SuggestedPromptChip(
                text = "Write a short story",
                onClick = { onSuggestedPromptClick("Write a short story") }
            )
        }
    }
}

@Composable
private fun SuggestedPromptChip(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    SuggestionChip(
        onClick = onClick,
        label = {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        modifier = modifier,
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = MaterialTheme.colorScheme.surface,
            labelColor = MaterialTheme.colorScheme.onSurface
        )
    )
}

