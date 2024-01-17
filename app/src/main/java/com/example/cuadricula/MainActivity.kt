package com.example.cuadricula

import DataSource
import Topic
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cuadricula.ui.theme.CuadriculaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CuadriculaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CuadriculaApp()
                }
            }
        }
    }
}

@Composable
fun CuadriculaApp(modifier : Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxSize()
        .padding(dimensionResource(id = R.dimen.padding_small))) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            items(DataSource.topics) { topic ->
                Cuadricula(topic)
            }
        }
    }
}

@Composable
fun Cuadricula(topic : Topic, modifier: Modifier = Modifier){
    Card {
        Row {
            Box {
                Image(
                    painter = painterResource(id = topic.imageRes),
                    contentDescription = null,
                    modifier = modifier
                        .size(
                            width = dimensionResource(id = R.dimen.picture_size),
                            height = dimensionResource(id = R.dimen.picture_size)),
                    contentScale = ContentScale.Crop
                )
            }
            Column {
                Text(
                    text = stringResource(id = topic.name),
                    modifier = Modifier
                        .padding(top = dimensionResource(id = R.dimen.padding_medium))
                        .padding(bottom = dimensionResource(id = R.dimen.padding_small))
                        .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(horizontal = dimensionResource(id = R.dimen.padding_medium))
                    )
                    Text(
                        text = topic.availableCourses.toString(),
                        modifier = Modifier
                            .padding(horizontal = dimensionResource(id = R.dimen.padding_small))
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun CuadriculaCardPreview() {
    CuadriculaApp()
}