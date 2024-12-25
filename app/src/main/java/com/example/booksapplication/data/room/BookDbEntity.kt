package com.example.booksapplication.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.booksapplication.data.entities.BookEntity
import com.example.booksapplication.data.entities.Genre
import com.example.booksapplication.data.entities.Language

/**
 * Created by Nadya N. on 10.12.2024.
 */
@Entity(
//    tableName = "books",
    indices = [
        Index("name", unique = true)
    ]
)
data class BookDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @ColumnInfo(collate = ColumnInfo.NOCASE)
    val name: String,

    val genre: Genre,
    val rating: Int,
    val releaseYear: Int,
    val author: String,
    val description: String,
    val language: Language,
    val numberOfPages: Int,
) {

    fun toEntity() = BookEntity(
        id = this.id,
        name = this.name,
        genre = this.genre,
        rating = this.rating,
        releaseYear = this.releaseYear,
        author = this.author,
        description = this.description,
        language = this.language,
        numberOfPages = this.numberOfPages
    )

    companion object {
        const val TABLE_NAME = "books"

        fun fromEntity(bookEntity: BookEntity) = BookDbEntity(
            id = bookEntity.id,
            name = bookEntity.name,
            genre = bookEntity.genre,
            rating = bookEntity.rating,
            releaseYear = bookEntity.releaseYear,
            author = bookEntity.author,
            description = bookEntity.description,
            language = bookEntity.language,
            numberOfPages = bookEntity.numberOfPages
        )
    }
}
