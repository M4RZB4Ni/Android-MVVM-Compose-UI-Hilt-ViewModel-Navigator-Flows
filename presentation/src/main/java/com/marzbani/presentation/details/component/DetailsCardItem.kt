package com.marzbani.presentation.details.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailsCardItem(label: String, value: String) {
    // Card for styling and elevation
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),  // Padding for the entire card
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),  // Card elevation
        shape = RoundedCornerShape(8.dp)  // Rounded corners for the card
    ) {
        // Column for vertical arrangement of label and value
        Column(
            modifier = Modifier
                .padding(16.dp)  // Padding for the content inside the card
        ) {
            // Text for displaying the label with custom typography and color
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,  // Custom typography for the label
                color = MaterialTheme.colorScheme.primary  // Custom color for the label
            )

            // Text for displaying the value with custom typography and padding
            Text(
                text = value,
                style = MaterialTheme.typography.bodySmall,  // Custom typography for the value
                modifier = Modifier.padding(top = 4.dp)  // Padding between label and value
            )
        }
    }
}
