package com.test.xebia.nytimes.newsList.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.test.xebia.nytimes.R
import com.test.xebia.nytimes.databinding.FragmentNewsListBinding
import com.test.xebia.nytimes.data.Result
import com.test.xebia.nytimes.di.Injectable
import com.test.xebia.nytimes.di.injectViewModel
import com.test.xebia.nytimes.ui.hide
import com.test.xebia.nytimes.ui.show
import javax.inject.Inject


class NewsListFragment : Fragment(), Injectable {
    val TAG = "ProjectListFragment"
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: NewsListViewModel
    lateinit var newsAdapter: NewsAdapter
    lateinit var binding: FragmentNewsListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_list,container,false)
        initViews()

        return binding.root
    }

    private fun initViews() {
        newsAdapter = NewsAdapter()
        binding.recyclerView.adapter = newsAdapter
        subscribeUi(viewModel)
       // setHasOptionsMenu(true)
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




}
