package com.example.newrickandmorty.base

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding, V : BaseViewModel>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    protected fun isOnline(context: Context?): Boolean {
        val cs: ConnectivityManager = context?.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cs.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }

    protected abstract val binding: B
    protected abstract val viewModel: V

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupViews()
        setupListeners()
        setupRequests()
        setupObserves()
    }

    open fun setupObserves() {
    }

    open fun setupRequests() {
    }

    open fun setupListeners() {
    }

    open fun setupViews() {
    }

    open fun initialize() {
    }

}