package com.hadirahimi.splashandonboarding

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import androidx.viewpager2.widget.ViewPager2
import java.lang.StrictMath.abs

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity,OnBoardingActivity::class.java))
            finish()
        } ,2000)
    }
    
    
}
