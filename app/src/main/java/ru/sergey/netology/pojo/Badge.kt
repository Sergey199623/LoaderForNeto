package ru.sergey.netology.pojo

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Badge : Parcelable {
    @SerializedName("text")
    @Expose
    var text: String? = null

    @SerializedName("color")
    @Expose
    var color: String? = null

    @SerializedName("bgColor")
    @Expose
    var bgColor: String? = null

     constructor(`in`: Parcel) {
        text = `in`.readValue(String::class.java.classLoader) as String?
        color = `in`.readValue(String::class.java.classLoader) as String?
        bgColor = `in`.readValue(String::class.java.classLoader) as String?
    }

    constructor() {}

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(text)
        dest.writeValue(color)
        dest.writeValue(bgColor)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Badge?> = object : Parcelable.Creator<Badge?> {
            override fun createFromParcel(`in`: Parcel): Badge? {
                return Badge(`in`)
            }

            override fun newArray(size: Int): Array<Badge?> {
                return arrayOfNulls(size)
            }
        }
    }
}