package com.vension.mutiltheme.demo

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

/**
 * ===================================================================
 * @author: Created by Vension on 2019/6/24 10:12.
 * @email:  250685***4@qq.com
 * @update: update by *** on 2019/6/24 10:12
 * @desc:   character determines attitude, attitude determines destiny
 * ===================================================================
 */

open class MyApplication : Application(){

    companion object {
        private val TAG = "CoreApplication"
        var context: Context by Delegates.notNull()
            private set

        lateinit var instance: Application
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
        context = applicationContext
    }

}