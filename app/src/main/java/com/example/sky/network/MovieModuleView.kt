package com.example.sky.network

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import kotlinx.coroutines.*


    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    fun MovieList() {
        //  java.lang.RuntimeException: Parcel: unable to marshal value
        var movieListResponse : List<Movie> by rememberSaveable() { mutableStateOf(listOf()) }

        CoroutineScope(Dispatchers.IO).launch {
            runCatching {
                movieListResponse = MovieAPI.retrofitService.getMovie()
            }.onFailure { println(it.message) }
        }

        LazyColumn {
            itemsIndexed(items = movieListResponse, itemContent = { index, item ->
                MovieItem(movie = item)
            })
        }
    }

    @OptIn(ExperimentalCoilApi::class)
    @Composable
    fun MovieItem(movie: Movie) {
        Card(
            modifier = Modifier
                .padding(8.dp, 4.dp)
                .fillMaxWidth()
                .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp, content = {
                Surface() {

                    Row(
                        Modifier
                            .padding(4.dp)
                            .fillMaxSize()
                    ) {

                        Image(
                            painter = rememberImagePainter(
                                data = movie.imageUrl,

                                builder = {
                                    scale(Scale.FILL)
                                    placeholder(0)
                                    transformations(CircleCropTransformation())

                                }
                            ),
                            contentDescription = movie.desc,
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(0.2f)
                        )


                        Column(
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxHeight()
                                .weight(0.8f)
                        ) {
                            Text(
                                text = movie.name,
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = movie.category,
                                style = MaterialTheme.typography.caption,
                                modifier = Modifier
                                    .background(
                                        Color.LightGray
                                    )
                                    .padding(4.dp)
                            )
                            Text(
                                text = movie.desc,
                                style = MaterialTheme.typography.body1,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )

                        }
                    }
                }
            }
        )
    }