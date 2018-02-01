package com.belatrix.kotlintemplate

import android.animation.Animator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.ViewAnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainKotlinActivity : AppCompatActivity() {

    var snackbar:Snackbar?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
