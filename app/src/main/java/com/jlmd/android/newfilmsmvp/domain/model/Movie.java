package com.jlmd.android.newfilmsmvp.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * @author jlmd
 */
public class Movie implements Parcelable {
    private int id;
    private String title;
    private String posterImgUrl;
    private String backdropImgUrl;
    private Date releaseDate;
    private boolean adult;
    private Double voteAverage;
    private float voteCount;
    private double popularity;
    private MovieDetails movieDetails;

    public Movie() {
        // Empty constructor
    }

    protected Movie(Parcel in) {
        id = in.readInt();
        title = in.readString();
        posterImgUrl = in.readString();
        backdropImgUrl = in.readString();
        long tmpReleaseDate = in.readLong();
        releaseDate = tmpReleaseDate != -1 ? new Date(tmpReleaseDate) : null;
        adult = in.readByte() != 0x00;
        voteAverage = in.readByte() == 0x00 ? null : in.readDouble();
        voteCount = in.readFloat();
        popularity = in.readDouble();
        movieDetails = (MovieDetails) in.readValue(MovieDetails.class.getClassLoader());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterImgUrl() {
        return posterImgUrl;
    }

    public void setPosterImgUrl(String posterImgUrl) {
        this.posterImgUrl = posterImgUrl;
    }

    public String getBackdropImgUrl() {
        return backdropImgUrl;
    }

    public void setBackdropImgUrl(String backdropImgUrl) {
        this.backdropImgUrl = backdropImgUrl;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public float getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(float voteCount) {
        this.voteCount = voteCount;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MovieDetails getMovieDetails() {
        return movieDetails;
    }

    public void setMovieDetails(MovieDetails movieDetails) {
        this.movieDetails = movieDetails;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(posterImgUrl);
        dest.writeString(backdropImgUrl);
        dest.writeLong(releaseDate != null ? releaseDate.getTime() : -1L);
        dest.writeByte((byte) (adult ? 0x01 : 0x00));
        if (voteAverage == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeDouble(voteAverage);
        }
        dest.writeFloat(voteCount);
        dest.writeDouble(popularity);
        dest.writeValue(movieDetails);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}