package com.example.kreedaankana

import android.app.Application
import com.example.kreedaankana.data.local.AppDatabase
import com.example.kreedaankana.data.remote.FirebaseRepository
import com.example.kreedaankana.data.repository.AppRepository

class KreedaApplication : Application() {
    val database by lazy { AppDatabase.getInstance(this) }
    val firebaseRepository by lazy { FirebaseRepository() }
    val repository by lazy { AppRepository(firebaseRepository, database.scoreDao()) }
}
