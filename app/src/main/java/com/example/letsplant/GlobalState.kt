package com.example.letsplant

import android.app.Application


class GlobalState : Application() {

    private var database: DatabaseHelper? = null

    // Called when the application is starting, before any other application objects have been created.
    override fun onCreate() {
        super.onCreate()
        database = DatabaseHelper(this)
    }

    public fun getDatabase (): DatabaseHelper {
        return database!!
    }
}
