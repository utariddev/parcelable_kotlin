package org.utarid.parcelable

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class Data : Parcelable {
    var dataInt: Int?
    var dataStr: String?

    constructor(dataInt: Int?, dataStr: String?) {
        this.dataInt = dataInt
        this.dataStr = dataStr
    }

    constructor(parcel: Parcel) {
        this.dataInt = parcel.readInt()
        this.dataStr = parcel.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(this.dataInt!!)
        dest.writeString(this.dataStr)
    }

    companion object {
        @JvmField
        val CREATOR: Creator<*> = object : Creator<Any?> {
            override fun createFromParcel(parcel: Parcel): Data {
                return Data(parcel)
            }

            override fun newArray(size: Int): Array<Data?> {
                return arrayOfNulls(size)
            }
        }
    }
}