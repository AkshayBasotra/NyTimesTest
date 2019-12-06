package com.test.xebia.nytimes.newsList.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel

import com.test.xebia.nytimes.newsList.data.NewsRepository
import javax.inject.Inject

class NewsListViewModel @Inject constructor(application: Application,repository: NewsRepository) : AndroidViewModel(application) {
   val news = repository.news
}