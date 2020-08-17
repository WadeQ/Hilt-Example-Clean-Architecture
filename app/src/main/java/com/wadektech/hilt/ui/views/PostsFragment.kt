package com.wadektech.hilt.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.wadektech.hilt.R
import com.wadektech.hilt.databinding.FragmentPostsBinding
import com.wadektech.hilt.ui.adapter.PostsAdapter
import com.wadektech.hilt.ui.viewmodels.PostsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class PostsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentPostsBinding.inflate(inflater)

        val postsViewModel : PostsViewModel by viewModels()
        binding.lifecycleOwner = this
        binding.viewModel = postsViewModel
        binding.rvPosts.adapter = PostsAdapter()
        return binding.root
    }

}