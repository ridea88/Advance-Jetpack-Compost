package com.example.advance_jetpack_compost.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.advance_jetpack_compost.R
import com.example.advance_jetpack_compost.model.Movie

@Composable
fun MovieItem(movie: Movie) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Surface {
            Row (
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ){

                Image(painter = rememberImagePainter(data = movie.imageUrl,
                    builder = {
                        scale(Scale.FIT)
                        placeholder(coil.base.R.drawable.notification_action_background)
                        transformations(CircleCropTransformation())
                    }), contentDescription = movie.desc,
                    Modifier
                        .fillMaxHeight()
                        .weight(0.2f))
                Column (verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)){


                    Text(text = movie.name, style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold)
                    Text(text = movie.category, style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(4.dp))
                    
                    Text(text = movie.desc, style = MaterialTheme.typography.bodySmall, maxLines = 2, overflow = TextOverflow.Ellipsis)
                }
            }
        }

    }
}