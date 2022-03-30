package com.zawinski.dreamvalley

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen

class DreamValleyApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}