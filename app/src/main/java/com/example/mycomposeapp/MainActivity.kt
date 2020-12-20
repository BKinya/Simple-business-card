package com.example.mycomposeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.example.mycomposeapp.ui.MyComposeAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                ScreenContent()
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
fun ScreenContent() {
    val image = imageResource(id = R.drawable.flower)
    val surfaceModifier = Modifier.padding(16.dp)
    val columnModifier = Modifier
        .fillMaxWidth()
        .padding(24.dp)

    val imageModifier = Modifier
        .height(180.dp)
        .width(180.dp)
        .clip(CircleShape)

    Surface(
        shape = RectangleShape,
        border = BorderStroke(width = 1.dp, color = Color(0xFF212121)),
        modifier = surfaceModifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = columnModifier

        ) {

                Image(asset = image, modifier = imageModifier, contentScale = ContentScale.Crop)
            CardDetail(label = "Name", value = "Foo Bar")
            CardDetail(label = "Email", value = "foo@example.com")
            CardDetail(label = "Phone", value = "000 0000 0000")
        }
    }
}

@Composable
fun CardDetail(label: String, value: String) {
    val textViewModifier = Modifier.padding(start = 4.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)
    val rowModifier = Modifier.fillMaxWidth()



    val textStyle = TextStyle(
        fontSize = 17.sp,
        fontWeight = FontWeight.W500,
        fontFamily = FontFamily.Monospace
    )
    Row(
        modifier = rowModifier,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(text = "$label:", style = textStyle)
        Text(text = value, modifier = textViewModifier, style = textStyle)
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        ScreenContent()
    }
}