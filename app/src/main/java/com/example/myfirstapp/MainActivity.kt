package com.example.myfirstapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.codebyashish.autoimageslider.AutoImageSlider
import com.codebyashish.autoimageslider.Enums.ImageActionTypes
import com.codebyashish.autoimageslider.Enums.ImageAnimationTypes
import com.codebyashish.autoimageslider.Enums.ImageScaleType
import com.codebyashish.autoimageslider.ExceptionsClass
import com.codebyashish.autoimageslider.Interfaces.ItemsListener
import com.codebyashish.autoimageslider.Models.ImageSlidesModel
import com.example.myfirstapp.R.drawable.wow

class MainActivity : AppCompatActivity(), ItemsListener {

    var autoImageList = ArrayList<ImageSlidesModel>()
    private lateinit var autoImageSlider: AutoImageSlider


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        autoImageSlider = findViewById(R.id.autoImageSlider)
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