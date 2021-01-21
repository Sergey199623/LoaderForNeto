package ru.sergey.netology.pojo

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DataContainer : Parcelable {
    @SerializedName("data")
    @Expose
    var data: List<Data?>? = null

     constructor(`in`: Parcel) {
        `in`.readList(data!!, Data::class.java.classLoader)
    }

    constructor() {}

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeList(data)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        val CREATOR: Parcelable.Creator<DataContainer?> = object : Parcelable.Creator<DataContainer?> {
            override fun createFromParcel(`in`: Parcel): DataContainer? {
                return DataContainer(`in`)
            }

            override fun newArray(size: Int): Array<DataContainer?> {
                return arrayOfNulls(size)
            }
        }
    }
}