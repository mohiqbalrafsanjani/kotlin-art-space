package com.example.artspaceapp

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                ArtSpace()
            }
        }
    }
}

@Composable
fun ArtSpace(){
    ArtSpaceWall(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ArtSpaceWall(modifier: Modifier){

    var result by remember {
        mutableStateOf(1)
    }

    if (result > 6){
        result = 1
    }else if (result < 1){
        result = 6
    }

    val imageResource = when(result){
        1 -> R.drawable.the_old_guitarist
        2 -> R.drawable.the_mona_lisa
        3 -> R.drawable.self_portrait_pc
        4 -> R.drawable.the_vitruvian_man
        5 -> R.drawable.girl_with_mandolin
        6 -> R.drawable.self_portrait
        else -> R.drawable.self_portrait
    }
    val imageTitle = when(result){
        1 -> "The Old Guitarist"
        2 -> "The Mona Lisa"
        3 -> "Self Portrait Picasso"
        4 -> "The Vitruvian Man"
        5 -> "Girl With Mandolin"
        6 -> "Self Portrait Da Vinci"
        else -> "Self Portrait Da Vinci"
    }

    val artistDesc = when(result){
        1 -> "Pablo Picasso"
        2 -> "Leonardo da Vinci"
        3 -> "Pablo Picasso"
        4 -> "Leonardo da Vinci"
        5 -> "Pablo Picasso"
        6 -> "Leonardo da Vinci"
        else -> "Leonardo da Vinci"
    }

    val yearDesc = when(result){
        1 -> "1903"
        2 -> "1519"
        3 -> "1901"
        4 -> "1487"
        5 -> "1910"
        6 -> "1512"
        else -> "1512"
    }
    Column (
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Image(
            painter = painterResource(imageResource),
            contentDescription = null,
            modifier = Modifier
                .height(500.dp)
                .width(450.dp)
                .fillMaxWidth()
                .border(width = 5.dp, color = Color.DarkGray)
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Column(modifier = Modifier.size(height = 80.dp, width = 250.dp)
            .shadow(
                elevation = 2.dp,
                shape = RectangleShape,

            ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = imageTitle,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
            Row() {
                Text(
                    text = artistDesc,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "(" + yearDesc + ")")
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        Row() {
            Button(onClick = { result -= 1}) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { result += 1}) {
                Text(text = "Next")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        ArtSpace()
    }
}