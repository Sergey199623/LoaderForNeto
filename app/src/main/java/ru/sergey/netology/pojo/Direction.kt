package ru.sergey.netology.pojo

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Direction : Parcelable {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("link")
    @Expose
    var link: String? = null

    @SerializedName("badge")
    @Expose
    var badge: Badge? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

     constructor(`in`: Parcel) {
        id = `in`.readValue(String::class.java.classLoader) as String?
        link = `in`.readValue(String::class.java.classLoader) as String?
        badge = `in`.readValue(Badge::class.java.classLoader) as Badge?
        title = `in`.readValue(String::class.java.classLoader) as String?
    }

    constructor() {}

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(id)
        dest.writeValue(link)
        dest.writeValue(badge)
        dest.writeValue(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Direction?> = object : Parcelable.Creator<Direction?> {
            override fun createFromParcel(`in`: Parcel): Direction? {
                return Direction(`in`)
            }

            override fun newArray(size: Int): Array<Direction?> {
                return arrayOfNulls(size)
            }
        }
    }
}