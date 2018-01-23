package com.belatrix.bxtemplate

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by eduardomedina on 23/01/18.
 */
class MainKotlinActivity :AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ui()
    }

    fun ui(){

        btnClick.setOnClickListener {
            goToBasicEvents()
        }

        btnForm.setOnClickListener {
            goToForm()
        }

        btnItems.setOnClickListener {
            goToItemsEvents()
        }

        btnKeyboard.setOnClickListener {
            gotoKeyboardEvents()
        }
    }

    fun goToBasicEvents(){
        startActivity(Intent(this,BasicEventsActivity::class.java))
    }

    private fun goToItemsEvents() {
        startActivity(Intent(this, ItemsEventsActivity::class.java))
    }

    private fun goToForm() {
        startActivity(Intent(this, FormularioActivity::class.java))
    }

    private fun gotoKeyboardEvents() {
        startActivity(Intent(this, KeyboardEventsActivity::class.java))
    }
}