package com.example.jetpackcompose1

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose1.ui.theme.JetPackCompose1Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackCompose1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {

    var number by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {


        Text(text = "Number: $number", modifier = Modifier.padding(15.dp))
        if (number < 0) {
            Image(
                painterResource(id = R.drawable.baseline_thumb_down_24),
                contentDescription = null
            )
        } else if (number > 0) {
            Image(painterResource(id = R.drawable.baseline_thumb_up_24), contentDescription = null)
        }
        else{

            Image(painterResource(id = R.drawable.baseline_exposure_zero_24), contentDescription = null)

        }
        Row(modifier = Modifier.wrapContentSize()) {
            Button(
                onClick = {

                    number++


                },
                Modifier
                    .wrapContentSize()
                    .padding(12.dp)
            ) {
                Icon(imageVector = Icons.Default.ThumbUp, contentDescription = null)
            }
            Button(
                onClick = {

                    number--

                },
                Modifier
                    .wrapContentSize()
                    .padding(12.dp)

            ) {
                Icon(
                    painterResource(id = R.drawable.baseline_thumb_down_24),
                    contentDescription = null
                )

            }


        }
        Button(
            onClick = {

                number = 0

            },
            Modifier
                .wrapContentSize()
        ) {

            Icon(imageVector = Icons.Default.Refresh, contentDescription = null)

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackCompose1Theme {
        Greeting()
    }
}