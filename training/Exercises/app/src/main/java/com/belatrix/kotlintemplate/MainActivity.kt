package com.belatrix.kotlintemplate

import android.animation.Animator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.ViewAnimationUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var snackbar:Snackbar?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ui()
        app()
    }

    fun ui(){
        snackbar= Snackbar.make(constraintLayoutContainer,"Message",Snackbar.LENGTH_LONG)
    }

    fun app(){
        imageViewBx.setOnClickListener({
            //bla bla bla bla
            //updateText()
            //showMessage()
            rippleEffect()
        })
    }

    fun updateText(){
        textViewHello.text="Hello Android"
    }

    fun showMessage(){
        snackbar!!.setText("Hello Belatrix")
        snackbar!!.show()
    }

    fun rippleEffect(){
        val cx:Int= (imageViewBx.left+imageViewBx.right)/2
        val cy:Int= (imageViewBx.top+imageViewBx.bottom)/2

        val finalRadius= Math.max(constraintLayoutContainer.width/2, constraintLayoutContainer.height/2)

        var anim:Animator?=null;

        if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.LOLLIPOP){
            anim= ViewAnimationUtils.createCircularReveal(constraintLayoutContainer,cx,cy,0.toFloat(),finalRadius.toFloat())
            anim.duration=2000
            anim.start()
        }
    }
}
