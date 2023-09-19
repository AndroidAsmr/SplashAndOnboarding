package com.hadirahimi.splashandonboarding

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.hadirahimi.splashandonboarding.databinding.ActivityOnBoardingBinding
import kotlin.math.abs
import kotlin.math.max


class OnBoardingActivity : AppCompatActivity()
{
    private lateinit var binding : ActivityOnBoardingBinding
    private val images = intArrayOf(
        R.drawable.image2 , R.drawable.image3 , R.drawable.image1
    )
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        val sliderAdapter = SliderAdapter(images , this)
        binding.apply {
    
            viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL;
            viewPager.adapter = sliderAdapter
            viewPager.offscreenPageLimit = 3;
            val pageMargin = resources.getDimensionPixelOffset(R.dimen.pageMargin).toFloat()
            val pageOffset = resources.getDimensionPixelOffset(R.dimen.offset).toFloat()
            wormDotsIndicator.attachTo(viewPager)
            viewPager.currentItem = 1
            viewPager.setPageTransformer { page, position ->
                val myOffset = position * - (2 * pageOffset + pageMargin)
                if (position < - 1)
                {
                    page.translationX = - myOffset
                }
                else if (position <= 1)
                {
                    val scaleFactor = max(0.7f , 1 - abs(position - 0.14285715f))
                    page.translationX = myOffset
                    page.scaleY = scaleFactor
                    page.alpha = scaleFactor
                }
                else
                {
                    page.alpha = 0f
                    page.translationX = myOffset
                }
            }
            btnHome.setOnClickListener {
                startActivity(Intent(this@OnBoardingActivity,MainActivity::class.java))
                finish()
            }
        }
        
    }
    
}