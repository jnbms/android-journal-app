package com.example.streotypenote.Screens

import android.graphics.Bitmap
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

//@Preview
@Composable
fun PostScreen(navController: NavController) {
    Scaffold(
        content = {

            val scrollstate = rememberScrollState()
            Column(
                modifier = Modifier
                    .verticalScroll(scrollstate)
            ) {

                val result = remember { mutableStateOf<Bitmap?>(null) }
                val launcher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicturePreview()) {
                    result.value = it
                }

                Button(onClick = { launcher.launch() }) {
                    Text(text = "Take a picture")
                }

                result.value?.let { image ->
                    Image(image.asImageBitmap(), null, modifier = Modifier.fillMaxWidth())
                }


                Text(text = "A", modifier = Modifier
                    .padding(bottom = 300.dp))
//                Spacer(modifier = Modifier.height(440.dp))
                TextField(value = "", onValueChange = {})
                TextField(value = "", onValueChange = {})
            }
        }
    )
}

@Preview
@Composable
fun Post() {
    Text(text = "ASD")
    OutlinedTextField(value = "", onValueChange = {})
}