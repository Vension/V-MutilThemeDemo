package com.vension.mutiltheme.demo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val sp = MyApplication.context.getSharedPreferences("vension", Context.MODE_PRIVATE)
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (sp.getInt("THEME",0) != 0) {
            //设置主题
            setTheme(sp.getInt("THEME",0))
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setText()
        message.setOnClickListener {
            startActivity(Intent(this@MainActivity,Activity2::class.java))
        }
        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    override fun onResume() {
        super.onResume()
        Log.e("vension-->",sp.getBoolean("isChange",false).toString())
        if (sp.getBoolean("isChange",false)) {
            sp.edit()
                .putBoolean("isChange",false)
                .apply()
            recreate()
        }
    }


    fun setText(){
        when(sp.getInt("THEME",0)){
            R.style.AppTheme -> {
                message.text = "当前为室外模式，点击切换"
            }
            R.style.AppThemeNight -> {
                message.text = "当前为室内模式，点击切换"
            }
            else -> {
                message.text = "点击切换主题"
            }
        }
    }

}
