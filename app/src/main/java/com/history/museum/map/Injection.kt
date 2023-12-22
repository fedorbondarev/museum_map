package com.history.museum.map

import com.history.museum.map.data.Repository
import com.history.museum.map.data.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class RepositoryModule {
    @Provides
    fun bindRepository(): Repository = RepositoryImpl()
}