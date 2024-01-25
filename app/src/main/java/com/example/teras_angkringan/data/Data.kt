package com.example.teras_angkringan.data

import android.os.Parcel
import android.os.Parcelable

class Data : Parcelable {
    var name: String?
    var description: String?
    var photo: Int

    constructor(name: String?, description: String?, photo: Int) {
        this.name = name
        this.description = description
        this.photo = photo
    }

    protected constructor(`in`: Parcel) {
        name = `in`.readString()
        description = `in`.readString()
        photo = `in`.readInt()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(description)
        dest.writeInt(photo)
    }

    companion object CREATOR : Parcelable.Creator<Data> {
        override fun createFromParcel(parcel: Parcel): Data {
            return Data(parcel)
        }

        override fun newArray(size: Int): Array<Data?> {
            return arrayOfNulls(size)
        }
    }
}
