package ru.sergey.netology.pojo

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Group : Parcelable {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("link")
    @Expose
    var link: String? = null

    @SerializedName("badge")
    @Expose
    var badge: Badge? = null

    @SerializedName("items")
    @Expose
    var items: List<Item?> = ArrayList()

    @SerializedName("title")
    @Expose
    var title: String? = null

     constructor(`in`: Parcel) {
        id = `in`.readValue(String::class.java.classLoader) as String?
        link = `in`.readValue(String::class.java.classLoader) as String?
        badge = `in`.readValue(Badge::class.java.classLoader) as Badge?
        `in`.readList(items, Item::class.java.classLoader)
        title = `in`.readValue(String::class.java.classLoader) as String?
    }

    constructor() {}

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(id)
        dest.writeValue(link)
        dest.writeValue(badge)
        dest.writeList(items)
        dest.writeValue(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Group?> = object : Parcelable.Creator<Group?> {
            override fun createFromParcel(`in`: Parcel): Group? {
                return Group(`in`)
            }

            override fun newArray(size: Int): Array<Group?> {
                return arrayOfNulls(size)
            }
        }
    }
}