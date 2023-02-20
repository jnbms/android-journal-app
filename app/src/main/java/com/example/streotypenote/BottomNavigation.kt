package com.example.streotypenote

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

sealed class BottomNavigationItems(val route: String, val name: String, val icon: String) {
    object First
}

@Composable
fun  BottomNavBar() {
    var navBottomContoller = rememberNavController();
}