package com.example.mycomposeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
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
                ConstraintLayoutContent()
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
fun ConstraintLayoutContent() {
    val surfaceModifier = Modifier.padding(16.dp)
    val image = imageResource(id = R.drawable.flower)
    val imageModifier = Modifier
        .height(180.dp)
        .width(180.dp)
        .clip(CircleShape)


    Surface(
        shape = RectangleShape,
        border = BorderStroke(width = 1.dp, color = Color(0xFF212121)),
        modifier = surfaceModifier
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth()
        ) {
            val (imageRef, nameRow, emailRow, phoneRow) = createRefs()

            Image(asset = image,
                modifier = imageModifier
                    .constrainAs(imageRef){
                          top.linkTo(parent.top, margin = 16.dp)
                        centerHorizontallyTo(parent)
            }, contentScale = ContentScale.Crop)

            CardDetail(label = "Name", value = "Foo Bar", modifier = Modifier.constrainAs(
                nameRow
            ){
                top.linkTo(imageRef.bottom, margin = 8.dp)
                start.linkTo(imageRef.start)
            })
            CardDetail(
                label = "Email",
                value = "foo@example.com",
                modifier = Modifier.constrainAs(emailRow){
                    top.linkTo(nameRow.bottom, margin = 8.dp)
                    start.linkTo(nameRow.start)
                }
            )
            CardDetail(
                label = "Phone",
                value = "000 0000 0000",
                modifier = Modifier.constrainAs(phoneRow){
                    top.linkTo(emailRow.bottom, margin = 8.dp)
                    start.linkTo(emailRow.start)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                })

        }
    }
}


@Composable
fun ConstraintLayoutContent1() {
    ConstraintLayout {

        // Create references for the composables to constrain
        val (button, text) = createRefs()

        Button(
            onClick = { /* Do something */ },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            },
        ) {
            Text("Button")
        }

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 16.dp)
            centerHorizontallyTo(parent)
        })
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
            CardDetail(
                label = "Name",
                value = "Foo Bar", modifier = null)
//            CardDetail(label = "Email", value = "foo@example.com")
//            CardDetail(label = "Phone", value = "000 0000 0000")
        }
    }
}

@Composable
fun CardDetail(label: String, value: String, modifier: Modifier?) {
    val textViewModifier = Modifier.padding(start = 4.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)


    val textStyle = TextStyle(
        fontSize = 17.sp,
        fontWeight = FontWeight.W500,
        fontFamily = FontFamily.Monospace
    )
    Row(
        modifier = modifier!!,
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
        ConstraintLayoutContent1()
    }
}