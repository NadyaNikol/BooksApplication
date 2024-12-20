package com.example.booksapplication.data.entities

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Nadya N. on 10.12.2024.
 */
data class BookEntity(
    val id: Long = 0L,
    val name: String,
    val genre: Genre,
    val rating: Int,
    val releaseYear: Int,
    val author: String,
    val description: String,
    val language: Language,
    val numberOfPages: Int,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString().toString(),
        Genre.valueOf(parcel.readString()!!),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        Language.valueOf(parcel.readString()!!),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(genre.name)
        parcel.writeInt(rating)
        parcel.writeInt(releaseYear)
        parcel.writeString(author)
        parcel.writeString(description)
        parcel.writeString(language.name)
        parcel.writeInt(numberOfPages)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BookEntity> {
        override fun createFromParcel(parcel: Parcel): BookEntity {
            return BookEntity(parcel)
        }

        override fun newArray(size: Int): Array<BookEntity?> {
            return arrayOfNulls(size)
        }
    }
}