package com.crownedjester.soft.waterdrinkremainder.di

import android.content.Context
import androidx.room.Room
import com.crownedjester.soft.waterdrinkremainder.data.data_source.AlarmDao
import com.crownedjester.soft.waterdrinkremainder.data.data_source.HydrationDailyDao
import com.crownedjester.soft.waterdrinkremainder.data.data_source.UserDao
import com.crownedjester.soft.waterdrinkremainder.data.database.HydrationDatabase
import com.crownedjester.soft.waterdrinkremainder.domain.data_source.DataStoreManager
import com.crownedjester.soft.waterdrinkremainder.domain.data_source.DataStoreRepository
import com.crownedjester.soft.waterdrinkremainder.domain.repository.alarm.AlarmRepository
import com.crownedjester.soft.waterdrinkremainder.domain.repository.alarm.AlarmRepositoryManager
import com.crownedjester.soft.waterdrinkremainder.domain.repository.hydration_daily.HydrationDailyRepository
import com.crownedjester.soft.waterdrinkremainder.domain.repository.hydration_daily.HydrationDailyRepositoryManager
import com.crownedjester.soft.waterdrinkremainder.domain.repository.user.UserRepository
import com.crownedjester.soft.waterdrinkremainder.domain.repository.user.UserRepositoryManager
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

    @Provides
    @Singleton
    fun provideHydrationDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            HydrationDatabase::class.java,
            HydrationDatabase.database_name
        ).build()


    @Provides
    @Singleton
    fun provideAlarmRepo(alarmDao: AlarmDao): AlarmRepository =
        AlarmRepositoryManager(alarmDao)

    @Provides
    @Singleton
    fun provideHydrationDailyRepo(hydrationDailyDao: HydrationDailyDao): HydrationDailyRepository =
        HydrationDailyRepositoryManager(hydrationDailyDao)

    @Provides
    @Singleton
    fun provideUserRepo(userDao: UserDao): UserRepository =
        UserRepositoryManager(userDao)
}