package com.home.androidComposable.di

import com.home.data.di.dataModules
import com.home.domain.di.domainModule
import org.koin.core.module.Module

val appModules: List<Module> = mutableListOf<Module>().apply {
    addAll(dataModules)
    add(domainModule)
    addAll(presentationModule)
}