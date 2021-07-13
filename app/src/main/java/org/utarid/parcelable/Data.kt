package org.utarid.parcelable

import android.os.Parcel
import android.os.Parcelable

class Data() : Parcelable {

    var dataInt: Int? = null
    var dataStr: String? = null

    constructor(dataInt: Int?, dataStr: String?) : this() {
        this.dataInt = dataInt
        this.dataStr = dataStr
    }

    constructor(parcel: Parcel) : this() {
        this.dataInt = parcel.readInt()
        this.dataStr = parcel.readString()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(this.dataInt!!)
        dest.writeString(this.dataStr)
    }

    override fun describeContents(): Int {
        return 0
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