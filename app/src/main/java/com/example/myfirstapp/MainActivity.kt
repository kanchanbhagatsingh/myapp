package com.example.myfirstapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.codebyashish.autoimageslider.AutoImageSlider
import com.codebyashish.autoimageslider.Enums.ImageActionTypes
import com.codebyashish.autoimageslider.Enums.ImageAnimationTypes
import com.codebyashish.autoimageslider.Enums.ImageScaleType
import com.codebyashish.autoimageslider.ExceptionsClass
import com.codebyashish.autoimageslider.Interfaces.ItemsListener
import com.codebyashish.autoimageslider.Models.ImageSlidesModel
import java.util.Collections

class MainActivity : AppCompatActivity(), ItemsListener {

    var autoImageList = ArrayList<ImageSlidesModel>()
    private lateinit var autoImageSlider: AutoImageSlider
    private var arrayList : ArrayList<RecyclerModel> = ArrayList()// array list by extending the RecyclerModel class

    private lateinit var recyclerView: RecyclerView // create variable for recyclerview

    private lateinit var adapter : ItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        autoImageSlider = findViewById(R.id.autoImageSlider)
        recyclerView = findViewById(R.id.recyclerView)  // initialize recyclerview
        try {
            autoImageList.add(
                ImageSlidesModel(
                    "https://www.indiablooms.com/life_pic/2021/b4808a3bcb22cc05b4f0219ace491ce1.jpg",
                    "https://google.com",
                    "Wow China",
                    ImageScaleType.FIT
                )
            )

            autoImageList.add(
                ImageSlidesModel(
                    "https://wakefitdev.gumlet.io/consumer-react/store-locator/store/R014/Wakefit_Furniture_Stores_BanjaraHills_0_1.jpg",
                    "https://wakefit.co",
                    "Wake Fit",
                    ImageScaleType.FIT
                )
            )

            autoImageSlider.setImageList(autoImageList, ImageScaleType.FIT)
            autoImageSlider.setSlideAnimation(ImageAnimationTypes.ZOOM_IN)
        } catch (e: ExceptionsClass) {
            e.printStackTrace()
        }
        autoImageSlider.onItemClickListener(this)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)

        button1.setOnClickListener {
            openLink("https://www.facebook.com")
        }

        button2.setOnClickListener {
            openLink("https://www.google.com")
        }

        // perform this reverse on any button click

        /*button2.setOnLongClickListener {
            arrayList.reverse()
            adapter.notifyDataSetChanged()
            true
        }*/


        saveData()
    }

    private fun saveData(){

        // add some static data into the arrayList by using model class

        arrayList.add(RecyclerModel(R.drawable.vhlogo, "Van Heusen", "Clothing & fashion", "5%", "Instore"))
        arrayList.add(RecyclerModel(R.drawable.veromoda, "Vero Moda", "Clothing & fashion", "5%", "Online"))
        arrayList.add(RecyclerModel(R.drawable.vlcc, "VLCC", "Health & Beauty", "5%", "Instore"))
        arrayList.add(RecyclerModel(R.drawable.vhlogo, "Van Heusen", "Clothing & fashion", "5%", "Online"))
        arrayList.add(RecyclerModel(R.drawable.vhlogo, "Van Heusen", "Clothing & fashion", "5%", "Instore"))
        arrayList.add(RecyclerModel(R.drawable.sotc, "SOTC", "Travel & Hoter", "5%", "Online"))
        arrayList.add(RecyclerModel(R.drawable.peter_eng, "Peter England", "Clothing & fashion", "5%", "Instore"))
        arrayList.add(RecyclerModel(R.drawable.rey_ban, "Rey Ban", "Accessories & Watches", "5%", "Online"))
        arrayList.add(RecyclerModel(R.drawable.peter_eng, "Peter England", "Clothing & fashion", "5%", "Instore"))
        arrayList.add(RecyclerModel(R.drawable.peter_eng, "Planet Fashion", "Clothing & fashion", "5%", "Online"))
        arrayList.add(RecyclerModel(R.drawable.planet_fashion, "Peter England", "Clothing & fashion", "5%", "Instore"))


        arrayList.reverse() // to reverse order just call this function


        adapter = ItemsAdapter(applicationContext, arrayList)
        val layoutManager : LayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter



    }
    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun onItemChanged(position: Int) {

    }

    override fun onTouched(actionTypes: ImageActionTypes?, position: Int) {

    }

    override fun onItemClicked(position: Int) {
        val model = autoImageList[position]
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(model.clickUrl))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

}