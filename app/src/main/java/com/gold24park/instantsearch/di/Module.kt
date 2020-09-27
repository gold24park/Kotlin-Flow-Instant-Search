package com.gold24park.instantsearch.di

import com.gold24park.instantsearch.data.MainRepository
import com.gold24park.instantsearch.presentation.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {
    factory {
        MainRepository()
    }
    viewModel {
        MainViewModel(get(), get())
    }
}