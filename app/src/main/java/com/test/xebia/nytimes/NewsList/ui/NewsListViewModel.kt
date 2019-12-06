package com.test.xebia.nytimes.NewsList.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel

import com.test.xebia.nytimes.NewsList.data.NewsRepository
import javax.inject.Inject

class NewsListViewModel @Inject constructor(application: Application,repository: NewsRepository) : AndroidViewModel(application) {
   val news = repository.news
}