package com.crownedjester.soft.waterdrinkremainder.di

import android.content.Context
import com.crownedjester.soft.waterdrinkremainder.domain.data_source.DataStoreManager
import com.crownedjester.soft.waterdrinkremainder.domain.data_source.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesDataStore(@ApplicationContext context: Context): DataStoreRepository =
        DataStoreManager(context)

}