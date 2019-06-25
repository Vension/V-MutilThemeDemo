package com.vension.mutiltheme.demo

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activitty_2.*

/**
 * ===================================================================
 * @author: Created by Vension on 2019/6/24 17:05.
 * @email:  250685***4@qq.com
 * @update: update by *** on 2019/6/24 17:05
 * @desc:   character determines attitude, attitude determines destiny
 * ===================================================================
 */
class Activity2 : AppCompatActivity() {

    private val sp = MyApplication.context.getSharedPreferences("vension", Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        if (sp.getInt("THEME",0) != 0) {
            //设置主题
            setTheme(sp.getInt("THEME",0))
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activitty_2)

        ACBtn_default.text = "室外模式" + if(sp.getInt("THEME",0) == R.style.AppTheme)  "（当前）" else ""
        ACBtn_night.text = "室内模式" + if(sp.getInt("THEME",0) == R.style.AppThemeNight)  "（当前）" else ""

        ACBtn_default.setOnClickListener {
            //将选中的主题资源id保存到静态变量中
            changeTheme(sp.getInt("THEME",0),R.style.AppTheme)
        }
        ACBtn_night.setOnClickListener {
            //将选中的主题资源id保存到静态变量中
            changeTheme(sp.getInt("THEME",0),R.style.AppThemeNight)
        }
    }


    fun changeTheme(current:Int,newTheme:Int){
        if(current != newTheme){
            sp.edit()
                .putInt("THEME",newTheme)
                .putBoolean("isChange",true)
                .apply()
            //重构Activity才能应用新的主题
            recreate()
        }
    }

}