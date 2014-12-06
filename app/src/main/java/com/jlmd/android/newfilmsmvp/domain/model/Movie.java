package com.jlmd.android.newfilmsmvp.domain.model;

import java.util.Date;

/**
 * @author jlmd
 */
public class Movie {
    private String title;
    private String posterImgUrl;
    private String backdropImgUrl;
    private Date releaseDate;
    private boolean adult;
    private Double voteAverage;
    private float voteCount;
    private double popularity;

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
}