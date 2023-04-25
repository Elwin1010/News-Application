package com.ekstrlabs.newsapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ekstrlabs.newsapplication.data.ArticlesRepository
import com.ekstrlabs.newsapplication.models.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesListViewModel @Inject constructor(
    private val repository: ArticlesRepository,
): ViewModel() {

    val articles = repository.articles

    init {
        refreshArticles()
    }

    private fun refreshArticles() {
        viewModelScope.launch {
            repository.refreshAllArticles();
        }
    }

    fun onArticleClick(article: Article) {
        // For now, mark as read
        viewModelScope.launch {
            repository.markAsRead(article)
        }
    }
}
