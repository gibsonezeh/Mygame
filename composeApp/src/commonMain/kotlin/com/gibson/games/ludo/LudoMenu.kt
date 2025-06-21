package com.gibson.games.ludo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * The main menu screen for Ludo game with Play, Exit options and hamburger menu
 */
@Composable
fun LudoMainMenuScreen(
    onPlayClicked: () -> Unit,
    onExitClicked: () -> Unit,
    onSettingsClicked: () -> Unit
) {
    var showDropdownMenu by remember { mutableStateOf(false) }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1E3A8A), // Deep blue
                        Color(0xFF3B82F6), // Blue
                        Color(0xFF60A5FA)  // Light blue
                    )
                )
            )
    ) {
        // Hamburger Menu Icon (Top Right)
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            IconButton(
                onClick = { showDropdownMenu = true }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
            
            // Dropdown Menu
            DropdownMenu(
                expanded = showDropdownMenu,
                onDismissRequest = { showDropdownMenu = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = {
                        showDropdownMenu = false
                        onSettingsClicked()
                    }
                )
                DropdownMenuItem(
                    text = { Text("About") },
                    onClick = {
                        showDropdownMenu = false
                        // TODO: Implement About screen
                    }
                )
                DropdownMenuItem(
                    text = { Text("Help") },
                    onClick = {
                        showDropdownMenu = false
                        // TODO: Implement Help screen
                    }
                )
            }
        }
        
        // Main Content (Centered)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Game Title
            Text(
                text = "LUDO",
                fontSize = 72.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            Text(
                text = "Classic Board Game",
                fontSize = 20.sp,
                color = Color.White.copy(alpha = 0.8f),
                modifier = Modifier.padding(bottom = 64.dp)
            )
            
            // Menu Buttons
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                // Play Button
                LudoMenuButton(
                    text = "PLAY",
                    backgroundColor = Color(0xFF10B981), // Green
                    onClick = onPlayClicked
                )
                
                // Exit Button
                LudoMenuButton(
                    text = "EXIT",
                    backgroundColor = Color(0xFFEF4444), // Red
                    onClick = onExitClicked
                )
            }
        }
        
        // Version info at bottom
        Text(
            text = "Version 1.0",
            fontSize = 12.sp,
            color = Color.White.copy(alpha = 0.6f),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}

/**
 * Reusable menu button component for Ludo
 */
@Composable
fun LudoMenuButton(
    text: String,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(300.dp)
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 4.dp
        )
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}
