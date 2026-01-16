package com.example.movieapp.ui.Remote.dto.DataClasses

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import kotlinx.parcelize.Parcelize
@Parcelize
data class Ratings(
    val Source: String,
    val Value: String
): Parcelable

@Entity(tableName = "Movie_Table")
@Parcelize
data class CardViewDataClasses(
    @ColumnInfo("Title")
    val Title: String,
    @ColumnInfo("Year")
    val Year: String,
    @ColumnInfo("Rated")
    val Rated: String,
    @ColumnInfo("Released")
    val Released: String,
    @ColumnInfo("Runtime")
    val Runtime: String,
    @ColumnInfo("Genre")
    val Genre: String,
    @ColumnInfo("Director")
    val Director: String,
    @ColumnInfo("Writer")
    val Writer: String,
    @ColumnInfo("Actors")
    val Actors: String,
    @ColumnInfo("Plot")
    val Plot: String,
    @ColumnInfo("Language")
    val Language: String,
    @ColumnInfo("Country")
    val Country: String,
    @ColumnInfo("Awards")
    val Awards: String,
    @ColumnInfo("Poster")
    val Poster: String,
    @ColumnInfo("Ratings")
    val Ratings: Array<Ratings>,
    @ColumnInfo("Metascore")
    val Metascore: String,
    @ColumnInfo("imdbRating")
    val imdbRating: String,
    @ColumnInfo("imdbVotes")
    val imdbVotes: String,
    @PrimaryKey
    val imdbID: String,
    @ColumnInfo("Type")
    val Type:String,
    @ColumnInfo("DVD")
    val DVD:String,
    @ColumnInfo("BoxOffice")
    val BoxOffice:String,
    @ColumnInfo("Production")
    val Production:String,
    @ColumnInfo("Website")
    val Website:String,
    @ColumnInfo("Response")
    val Response:String,
): Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CardViewDataClasses

        if (Title != other.Title) return false
        if (Year != other.Year) return false
        if (Rated != other.Rated) return false
        if (Released != other.Released) return false
        if (Runtime != other.Runtime) return false
        if (Genre != other.Genre) return false
        if (Director != other.Director) return false
        if (Writer != other.Writer) return false
        if (Actors != other.Actors) return false
        if (Plot != other.Plot) return false
        if (Language != other.Language) return false
        if (Country != other.Country) return false
        if (Awards != other.Awards) return false
        if (Poster != other.Poster) return false
        if (!Ratings.contentEquals(other.Ratings)) return false
        if (Metascore != other.Metascore) return false
        if (imdbRating != other.imdbRating) return false
        if (imdbVotes != other.imdbVotes) return false
        if (imdbID != other.imdbID) return false
        if (Type != other.Type) return false
        if (DVD != other.DVD) return false
        if (BoxOffice != other.BoxOffice) return false
        if (Production != other.Production) return false
        if (Website != other.Website) return false
        if (Response != other.Response) return false

        return true
    }

    override fun hashCode(): Int {
        var result = Title.hashCode()
        result = 31 * result + Year.hashCode()
        result = 31 * result + Rated.hashCode()
        result = 31 * result + Released.hashCode()
        result = 31 * result + Runtime.hashCode()
        result = 31 * result + Genre.hashCode()
        result = 31 * result + Director.hashCode()
        result = 31 * result + Writer.hashCode()
        result = 31 * result + Actors.hashCode()
        result = 31 * result + Plot.hashCode()
        result = 31 * result + Language.hashCode()
        result = 31 * result + Country.hashCode()
        result = 31 * result + Awards.hashCode()
        result = 31 * result + Poster.hashCode()
        result = 31 * result + Ratings.contentHashCode()
        result = 31 * result + Metascore.hashCode()
        result = 31 * result + imdbRating.hashCode()
        result = 31 * result + imdbVotes.hashCode()
        result = 31 * result + imdbID.hashCode()
        result = 31 * result + Type.hashCode()
        result = 31 * result + DVD.hashCode()
        result = 31 * result + BoxOffice.hashCode()
        result = 31 * result + Production.hashCode()
        result = 31 * result + Website.hashCode()
        result = 31 * result + Response.hashCode()
        return result
    }
}

data class Response(val movies: List<CardViewDataClasses>)
class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromRatings(value: Array<Ratings>): String =
        gson.toJson(value)

    @TypeConverter
    fun toRatings(value: String): Array<Ratings> =
        gson.fromJson(value, Array<Ratings>::class.java)
}