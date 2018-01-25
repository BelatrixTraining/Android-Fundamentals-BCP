package com.belatrix.kotlintemplate

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainKotlinActivity : AppCompatActivity() {

    var snackbar:Snackbar?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ui()
    }

    fun ui(){

        btnSimpleList.setOnClickListener {
            goToSimpleList()
        }

        btnSimpleGrid.setOnClickListener {
            goToSimpleGrid()
        }

        btnCustomList.setOnClickListener {
            goToCustomList()
        }

        btnViewHolder.setOnClickListener {

        }

        btnMoviegrid.setOnClickListener {
            goToMoviewGrid()
        }
    }

    fun goToSimpleList(){
        startActivity(Intent(this,SimpleListActivity::class.java))
    }

    fun goToSimpleGrid(){
        startActivity(Intent(this,SimpleGridActivity::class.java))
    }

    fun goToCustomList(){
        startActivity(Intent(this,CustomListActivity::class.java))
    }

    fun goToMoviewGrid(){
        startActivity(Intent(this,MovieGridActivity::class.java))
    }


}
