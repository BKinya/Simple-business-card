package com.example.mycomposeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.mycomposeapp.ui.MyComposeAppTheme
import com.example.mycomposeapp.ui.lightBlue200
import com.example.mycomposeapp.ui.lightBlue500

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyLayout()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MyComposeAppTheme {
        content()
    }
}

@Composable
fun MyLayout() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "M. D. C.")
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Favorite)
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ThumbUp)
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ThumbDown)
                    }
                }
            )
        },
        bottomBar = {

            BottomNavigation(
                backgroundColor = Color(0xFFffffff)
            ) {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Home, tint = lightBlue500,)
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Favorite, tint = lightBlue500,)
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.LibraryAdd, tint = lightBlue500,)
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Bookmark, tint = lightBlue500,)
                }
            }
        }
    ) { _ ->
        BodyContent(modifier = Modifier.padding(16.dp))

    }
}

@Composable
fun BodyContent(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Hi there. What's up with JetPack compose?",
        )
        Text(text = "We'll find out.")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyLayout()
    }
}