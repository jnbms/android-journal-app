package com.example.streotypenote

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.compose.rememberNavController
import com.example.streotypenote.ui.theme.setTheme
import com.google.accompanist.insets.ExperimentalAnimatedInsets
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.firebase.database.FirebaseDatabase

@OptIn(ExperimentalAnimatedInsets::class)
class AppActivity : ComponentActivity() {

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val myRef = database.getReference("message")
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//        WindowCompat.setDecorFitsSystemWindows(window, false)
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        setContent {
            setTheme(darkTheme = false) {
                ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
                    val rootNavController = rememberNavController()
                    Routes(rootNavController)
//                    PostScreen(navController = rootNavController)
//                    KeyboardSample()
                }
            }
        }
    }
    val requestActivity: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult() // ◀ StartActivityForResult 처리를 담당
    ) { activityResult ->
        // action to do something
    }

}