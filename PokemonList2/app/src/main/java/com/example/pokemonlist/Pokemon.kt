package com.example.pokemonlist

import android.os.Parcel
import android.os.Parcelable

data class Pokemon(
    val name: String?,
    val description: String?,
    val photo: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeInt(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pokemon> {
        override fun createFromParcel(parcel: Parcel): Pokemon {
            return Pokemon(parcel)
        }

        override fun newArray(size: Int): Array<Pokemon?> {
            return arrayOfNulls(size)
        }
    }
}
