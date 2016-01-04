package br.com.marcellogalhardo.lynx

import android.app.Application
import android.support.multidex.MultiDex
import com.parse.Parse

class AndroidApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        initializeParse()
    }

    private fun initializeParse() {
        Parse.enableLocalDatastore(this);
        Parse.initialize(this);
    }

}