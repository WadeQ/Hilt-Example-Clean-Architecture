package com.wadektech.hilt.presentation.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.wadektech.hilt.databinding.FragmentPostsBinding
import com.wadektech.hilt.presentation.adapter.PostsAdapter
import com.wadektech.hilt.presentation.viewmodels.PostsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class PostsFragment : Fragment() {
    private lateinit var binding : FragmentPostsBinding
    private val postsViewModel : PostsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        initUI(inflater)
        setUpRecyclerview()

        return binding.root
    }

    private fun setUpRecyclerview() {
        binding.viewModel = postsViewModel
        binding.rvPosts.adapter = PostsAdapter()
    }

    private fun initUI(inflater: LayoutInflater) {
        binding = FragmentPostsBinding.inflate(inflater)
        binding.lifecycleOwner = this
    }

}