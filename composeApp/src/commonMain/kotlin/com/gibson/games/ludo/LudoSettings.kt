package com.gibson.games.ludo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.activity.compose.BackHandler

/**
 * Settings screen for Ludo game
 */
@Composable
fun LudoSettingsScreen(onBackClicked: () -> Unit) {
    // Handle back navigation
    BackHandler {
        onBackClicked()
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF374151), // Dark gray
                        Color(0xFF4B5563), // Gray
                        Color(0xFF6B7280)  // Light gray
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            // Top Bar with Back Button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClicked
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }
                
                Spacer(modifier = Modifier.width(16.dp))
                
                Text(
                    text = "SETTINGS",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            
            // Settings Content
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Game Settings Section
                SettingsSection(title = "Game Settings") {
                    SettingsToggleItem(
                        title = "Sound Effects",
                        description = "Enable game sound effects",
                        isChecked = true,
                        onCheckedChange = { /* TODO: Implement sound toggle */ }
                    )
                    
                    SettingsToggleItem(
                        title = "Music",
                        description = "Enable background music",
                        isChecked = true,
                        onCheckedChange = { /* TODO: Implement music toggle */ }
                    )
                    
                    SettingsToggleItem(
                        title = "Vibration",
                        description = "Enable haptic feedback",
                        isChecked = false,
                        onCheckedChange = { /* TODO: Implement vibration toggle */ }
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Display Settings Section
                SettingsSection(title = "Display") {
                    SettingsToggleItem(
                        title = "Animations",
                        description = "Enable smooth animations",
                        isChecked = true,
                        onCheckedChange = { /* TODO: Implement animation toggle */ }
                    )
                    
                    SettingsToggleItem(
                        title = "Dark Mode",
                        description = "Use dark theme",
                        isChecked = false,
                        onCheckedChange = { /* TODO: Implement theme toggle */ }
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Gameplay Settings Section
                SettingsSection(title = "Gameplay") {
                    SettingsItem(
                        title = "Game Speed",
                        description = "Normal",
                        onClick = { /* TODO: Implement speed selection */ }
                    )
                    
                    SettingsItem(
                        title = "Difficulty",
                        description = "Medium",
                        onClick = { /* TODO: Implement difficulty selection */ }
                    )
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Footer
            Text(
                text = "More settings coming soon!",
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.7f),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

/**
 * Settings section with title and content
 */
@Composable
fun SettingsSection(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.1f)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                content = content
            )
        }
    }
}

/**
 * Settings item with toggle switch
 */
@Composable
fun SettingsToggleItem(
    title: String,
    description: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.7f)
            )
        }
        
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFF10B981),
                checkedTrackColor = Color(0xFF10B981).copy(alpha = 0.5f)
            )
        )
    }
}

/**
 * Settings item without toggle (for selection items)
 */
@Composable
fun SettingsItem(
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color(0xFF60A5FA)
            )
        }
        
        TextButton(onClick = onClick) {
            Text(
                text = "Change",
                color = Color(0xFF60A5FA)
            )
        }
    }
}
