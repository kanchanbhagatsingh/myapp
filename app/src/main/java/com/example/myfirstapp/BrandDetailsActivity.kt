package com.example.myfirstapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfirstapp.databinding.ActivityBrandDetailsBinding

class BrandDetailsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBrandDetailsBinding
    private var title: String = ""

    //TODO : do more for other details


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityBrandDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getBundle()

        initToolBar()

    }

    // get data from intent call which is sent from adapter class of MainActivity
    private fun getBundle(){
        val intent = intent
        if (intent != null) {
            val recyclerModel: RecyclerModel? = intent.getParcelableExtra("model")
            if (recyclerModel != null) {
                title = recyclerModel.title
            }


            //TODO : do more for other details

        }
    }

    // initialize toolbar with actionBar
    private fun initToolBar(){
        setSupportActionBar(binding.toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbarText.text = title

    }

    // to create option (toolbar) menus on the activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    // to select and set action on tool menu clicks
    // by default back button works as home button so its id will be android.R.id.home
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId  == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}