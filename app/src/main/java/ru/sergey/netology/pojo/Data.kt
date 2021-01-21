package ru.sergey.netology.pojo

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class Data : Parcelable {
    @SerializedName("groups")
    @Expose
    var groups: List<Group?> = ArrayList()

    @SerializedName("direction")
    @Expose
    var direction: Direction? = null

     constructor(`in`: Parcel) {
        `in`.readList(groups, Group::class.java.classLoader)
        direction = `in`.readValue(Direction::class.java.classLoader) as Direction?
    }

    constructor() {}

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeList(groups)
        dest.writeValue(direction)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Data?> = object : Parcelable.Creator<Data?> {
            override fun createFromParcel(`in`: Parcel): Data? {
                return Data(`in`)
            }

            override fun newArray(size: Int): Array<Data?> {
                return arrayOfNulls(size)
            }
        }
    }
}