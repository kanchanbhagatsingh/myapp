package com.example.myfirstapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(applicationContext: Context, arrayList: ArrayList<RecyclerModel>) : RecyclerView.Adapter<ItemsAdapter.myViewHolder>() {

    private var arrayList: ArrayList<RecyclerModel>
    private var context : Context

    // initialize the variables
    init {
        this.arrayList = arrayList
        this.context = applicationContext
    }

    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var logo : ImageView
        var title : TextView
        var desc : TextView
        var price : TextView
        var type : TextView

        init {
            logo = itemView.findViewById(R.id.ivLogo)
            title = itemView.findViewById(R.id.tvTitle)
            desc = itemView.findViewById(R.id.tvDesc)
            price = itemView.findViewById(R.id.cashback)
            type = itemView.findViewById(R.id.tvStoreType)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
       val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val recyclerModel = arrayList[position]

        Log.d("ASHISH KR", "onBindViewHolder: ${recyclerModel.title}")

        holder.logo.setImageResource(recyclerModel.logo)
        holder.title.text = recyclerModel.title
        holder.desc.text = recyclerModel.desc

        holder.price.text = recyclerModel.cashback
        holder.type.text = recyclerModel.type


    }
}