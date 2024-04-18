package com.example.myfirstapp

import android.os.Parcel
import android.os.Parcelable

class RecyclerModel(
    var logo: Int,
    var title: String,
    var desc: String,
    var cashback: String,
    var type: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(logo)
        parcel.writeString(title)
        parcel.writeString(desc)
        parcel.writeString(cashback)
        parcel.writeString(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RecyclerModel> {
        override fun createFromParcel(parcel: Parcel): RecyclerModel {
            return RecyclerModel(parcel)
        }

        override fun newArray(size: Int): Array<RecyclerModel?> {
            return arrayOfNulls(size)
        }
    }
}
