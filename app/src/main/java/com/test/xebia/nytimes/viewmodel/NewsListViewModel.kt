package com.test.xebia.nytimes.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

import com.test.xebia.nytimes.data.NewsRepository
import com.test.xebia.nytimes.model.NewsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class NewsListViewModel constructor(application: Application,repository: NewsRepository) : AndroidViewModel(application) {
   val news = repository.news
}