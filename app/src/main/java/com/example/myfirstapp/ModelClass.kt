package com.example.myfirstapp

class RecyclerModel(logo: Int, title: String, desc: String, cashback: String, type : String) {
    // create model class for storing & populate the data on recyclerview
     var title : String = ""
     var desc : String = ""
     var logo : Int = 0
     var cashback : String = ""
    var type : String = ""

    init {
        this.desc = desc
        this.title = title
        this.logo = logo
        this.cashback = cashback
        this.type = type
    }

}
