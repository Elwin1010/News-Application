package com.ekstrlabs.newsapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ekstrlabs.newsapplication.ui.components.ArticleRow
import com.ekstrlabs.newsapplication.viewmodels.ArticlesListViewModel


@Composable
fun ArticlesListScreen(
    // Let Hilt inject the viewmodel
    viewModel: ArticlesListViewModel = hiltViewModel()
) {

    // Get the articles from the viewmodel
    val articles = viewModel.articles.collectAsState(initial = emptyList())


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Nieuws App") }
            )
        }
    ) {

        Surface(
            modifier = Modifier.padding(it)
        ) {
            // Articles are not yet loaded: show loading indicator
            if (articles.value.isEmpty()) {

                Box(
                    modifier = Modifier.fillMaxSize()
                ) {

                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )

                }

            } else {


                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    items(articles.value) { article ->

                        ArticleRow(
                            modifier = Modifier
                                .padding(8.dp)
                                .clickable {
                                    viewModel.onArticleClick(article)
                                },
                            article = article,
                        )
                        Spacer(modifier = Modifier.height(8.dp))

                    }
                }


            }
        }


    }



}