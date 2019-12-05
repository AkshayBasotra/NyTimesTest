package com.test.xebia.nytimes.view

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.test.xebia.nytimes.R
import com.test.xebia.nytimes.data.AppDatabase
import com.test.xebia.nytimes.data.NewsRepository
import com.test.xebia.nytimes.databinding.FragmentNewsListBinding
import com.test.xebia.nytimes.view.adapter.NewsAdapter
import com.test.xebia.nytimes.viewmodel.NewsListViewModel
import com.test.xebia.nytimes.data.Result
import com.test.xebia.nytimes.hide
import com.test.xebia.nytimes.show
import timber.log.Timber


class NewsListFragment : Fragment() {
    val TAG = "ProjectListFragment"
    lateinit var newsAdapter: NewsAdapter
    lateinit var binding: FragmentNewsListBinding
    lateinit var newsRepository: NewsRepository
    lateinit var ctx: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ctx = activity as MainActivity
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_list,container,false)
        initViews()

        return binding.root
    }

    private fun initViews() {
        newsAdapter = NewsAdapter()
        val db = AppDatabase.getInstance(context = ctx).newsDao()
        newsRepository = NewsRepository(Application(),db)
        val viewModel = ViewModelProviders.of(this, CustomViewModelFactory(Application(),newsRepository) ).get(NewsListViewModel::class.java)
        binding.recyclerView.adapter = newsAdapter
        subscribeUi(viewModel)
        setHasOptionsMenu(true)
    }


    private fun subscribeUi(viewModel: NewsListViewModel) {
        viewModel.news.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
               Result.Status.SUCCESS -> {
                    binding.progressBar.hide()
                    result.data?.let { newsAdapter.submitList(it) }
                }
                Result.Status.LOADING -> binding.progressBar.show()
                Result.Status.ERROR -> {
                    binding.progressBar.hide()
                    Log.d(TAG,"error")
                   // Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_LONG).show()
                }
            }
        })
    }

    inner class CustomViewModelFactory(private val application: Application, private val newsRepository: NewsRepository) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return NewsListViewModel(application,newsRepository) as T
        }

    }




}
