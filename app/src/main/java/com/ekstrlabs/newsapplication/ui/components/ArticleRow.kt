package com.ekstrlabs.newsapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.ekstrlabs.newsapplication.models.Article

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ArticleRow(
    modifier: Modifier,
    article: Article,
) {

    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Column{

            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            ) {
                GlideImage(
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    model = article.imageUrl,
                    contentDescription = "Afbeelding voor: ${article.title}",
                )

                // Add a 60% opacity black overlay over the image when the article is read
                if (article.isRead) {
                    Surface(
                        color = Color.Black.copy(alpha = 0.6f),
                        modifier = Modifier.fillMaxSize()
                    ) {}
                }
            }


            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    modifier = Modifier.weight(1f),
                    text = article.title,
                    style = MaterialTheme.typography.subtitle1
                )

                if (article.isRead) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = "Read"
                    )
                }

            }


        }
    }

}