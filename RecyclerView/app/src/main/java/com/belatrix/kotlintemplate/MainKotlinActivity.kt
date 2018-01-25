package com.belatrix.kotlintemplate

import android.animation.Animator
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.view.ViewCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.ImageView
import android.widget.Toast
import com.belatrix.kotlintemplate.data.PokemonData
import com.belatrix.kotlintemplate.model.Pokemon
import com.belatrix.kotlintemplate.ui.adapter.MyInterface
import com.belatrix.kotlintemplate.ui.adapter.MyPokemonAdapter
import com.belatrix.kotlintemplate.ui.adapter.OnItemClickListener
import com.belatrix.kotlintemplate.ui.adapter.PokemonAdapter
import com.belatrix.kotlintemplate.ui.events.ClickListener
import com.belatrix.kotlintemplate.ui.events.RecyclerTouchListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pokemon_details.*

/*
    Kotlin
    Basic Types https://kotlinlang.org/docs/reference/basic-types.html
    String https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html
 */
class MainKotlinActivity : AppCompatActivity(),OnItemClickListener,MyInterface {


    val DEFAULT_SPANCOUNT:Int=3

    private var mLayoutManager:RecyclerView.LayoutManager?=null

    private var pokemonList:List<Pokemon>?=null
    private var pokemonAdapter:PokemonAdapter?=null
    private var myPokemonAdapter:MyPokemonAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ui()

        loadPokemonData()
    }


    var onItemClick=object :ClickListener{
        override fun onClick(view: View?, position: Int) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            val pokemon:Pokemon?= pokemonList!!.get(position)
            goToDetails(pokemon)
        }

        override fun onLongClick(view: View?, position: Int) {
            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    fun ui(){
        mLayoutManager= GridLayoutManager(this,DEFAULT_SPANCOUNT)
        recyclerViewPokemon.layoutManager=mLayoutManager

        //events
        //recyclerViewPokemon.addOnItemTouchListener(RecyclerTouchListener(this,recyclerViewPokemon,onItemClick))
    }

    fun goToDetails(pokemon: Pokemon?){
        val intent:Intent= Intent(this,PokemonDetailsActivity::class.java)
        intent.putExtra("POKEMON", pokemon);
        startActivity(intent)
    }

    fun goToDetailsAnimation(pokemon: Pokemon?,imageView: ImageView?){
        val intent:Intent= Intent(this,PokemonDetailsActivity::class.java)
        intent.putExtra("POKEMON",pokemon)
        intent.putExtra("IMAGE_TRANSITION",ViewCompat.getTransitionName(imageView))

        val options:ActivityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                imageView,
                ViewCompat.getTransitionName(imageView)
        )

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.JELLY_BEAN){
            startActivity(intent,options.toBundle())
        }
    }

    override fun onClikListener(position: Int, container: View?, imageView: ImageView?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val pokemon:Pokemon?= pokemonList!!.get(position)
        goToDetailsAnimation(pokemon,imageView)
    }

    override fun showItemMessage(position: Int, message: String?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Toast.makeText(this, "Item ${position} ${message}",Toast.LENGTH_LONG).show()
    }

    fun renderPokemons(){
        pokemonAdapter= PokemonAdapter(this,pokemonList)
        pokemonAdapter!!.setOnItemClickListener(this)
        myPokemonAdapter= MyPokemonAdapter(this,this,pokemonList)

        recyclerViewPokemon.adapter=pokemonAdapter
    }

    fun loadPokemonData(){
        pokemonList = PokemonData().generate()
        renderPokemons()
    }

}
