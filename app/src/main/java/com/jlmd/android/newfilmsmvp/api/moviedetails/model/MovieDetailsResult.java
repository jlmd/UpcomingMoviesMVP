package com.jlmd.android.newfilmsmvp.api.moviedetails.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class MovieDetailsResult {

  @Expose private Boolean adult;
  @SerializedName("backdrop_path") @Expose private String backdropPath;
  @SerializedName("belongs_to_collection") @Expose private BelongsToCollection belongsToCollection;
  @Expose private Integer budget;
  @Expose private List<Genre> genres = new ArrayList<Genre>();
  @Expose private String homepage;
  @Expose private Integer id;
  @SerializedName("imdb_id") @Expose private String imdbId;
  @SerializedName("original_title") @Expose private String originalTitle;
  @Expose private Double popularity;
  @SerializedName("poster_path") @Expose private String posterPath;
  @SerializedName("production_companies") @Expose private List<ProductionCompany>
      productionCompanies = new ArrayList<ProductionCompany>();
  @SerializedName("production_countries") @Expose private List<ProductionCountry>
      productionCountries = new ArrayList<ProductionCountry>();
  @SerializedName("release_date") @Expose private String releaseDate;
  @Expose private Integer revenue;
  @Expose private Integer runtime;
  @SerializedName("spoken_languages") @Expose private List<SpokenLanguage> spokenLanguages =
      new ArrayList<SpokenLanguage>();
  @Expose private String status;
  @Expose private String tagline;
  @Expose private String title;
  @SerializedName("vote_average") @Expose private Double voteAverage;
  @SerializedName("vote_count") @Expose private Integer voteCount;

  /**
   * @return The adult
   */
  public Boolean getAdult() {
    return adult;
  }

  /**
   * @param adult The adult
   */
  public void setAdult(Boolean adult) {
    this.adult = adult;
  }

  /**
   * @return The backdropPath
   */
  public String getBackdropPath() {
    return backdropPath;
  }

  /**
   * @param backdropPath The backdrop_path
   */
  public void setBackdropPath(String backdropPath) {
    this.backdropPath = backdropPath;
  }

  /**
   * @return The belongsToCollection
   */
  public BelongsToCollection getBelongsToCollection() {
    return belongsToCollection;
  }

  /**
   * @param belongsToCollection The belongs_to_collection
   */
  public void setBelongsToCollection(BelongsToCollection belongsToCollection) {
    this.belongsToCollection = belongsToCollection;
  }

  /**
   * @return The budget
   */
  public Integer getBudget() {
    return budget;
  }

  /**
   * @param budget The budget
   */
  public void setBudget(Integer budget) {
    this.budget = budget;
  }

  /**
   * @return The genres
   */
  public List<Genre> getGenres() {
    return genres;
  }

  /**
   * @param genres The genres
   */
  public void setGenres(List<Genre> genres) {
    this.genres = genres;
  }

  /**
   * @return The homepage
   */
  public String getHomepage() {
    return homepage;
  }

  /**
   * @param homepage The homepage
   */
  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }

  /**
   * @return The id
   */
  public Integer getId() {
    return id;
  }

  /**
   * @param id The id
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * @return The imdbId
   */
  public String getImdbId() {
    return imdbId;
  }

  /**
   * @param imdbId The imdb_id
   */
  public void setImdbId(String imdbId) {
    this.imdbId = imdbId;
  }

  /**
   * @return The originalTitle
   */
  public String getOriginalTitle() {
    return originalTitle;
  }

  /**
   * @param originalTitle The original_title
   */
  public void setOriginalTitle(String originalTitle) {
    this.originalTitle = originalTitle;
  }

  /**
   * @return The popularity
   */
  public Double getPopularity() {
    return popularity;
  }

  /**
   * @param popularity The popularity
   */
  public void setPopularity(Double popularity) {
    this.popularity = popularity;
  }

  /**
   * @return The posterPath
   */
  public String getPosterPath() {
    return posterPath;
  }

  /**
   * @param posterPath The poster_path
   */
  public void setPosterPath(String posterPath) {
    this.posterPath = posterPath;
  }

  /**
   * @return The productionCompanies
   */
  public List<ProductionCompany> getProductionCompanies() {
    return productionCompanies;
  }

  /**
   * @param productionCompanies The production_companies
   */
  public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
    this.productionCompanies = productionCompanies;
  }

  /**
   * @return The productionCountries
   */
  public List<ProductionCountry> getProductionCountries() {
    return productionCountries;
  }

  /**
   * @param productionCountries The production_countries
   */
  public void setProductionCountries(List<ProductionCountry> productionCountries) {
    this.productionCountries = productionCountries;
  }

  /**
   * @return The releaseDate
   */
  public String getReleaseDate() {
    return releaseDate;
  }

  /**
   * @param releaseDate The release_date
   */
  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  /**
   * @return The revenue
   */
  public Integer getRevenue() {
    return revenue;
  }

  /**
   * @param revenue The revenue
   */
  public void setRevenue(Integer revenue) {
    this.revenue = revenue;
  }

  /**
   * @return The runtime
   */
  public Integer getRuntime() {
    return runtime;
  }

  /**
   * @param runtime The runtime
   */
  public void setRuntime(Integer runtime) {
    this.runtime = runtime;
  }

  /**
   * @return The spokenLanguages
   */
  public List<SpokenLanguage> getSpokenLanguages() {
    return spokenLanguages;
  }

  /**
   * @param spokenLanguages The spoken_languages
   */
  public void setSpokenLanguages(List<SpokenLanguage> spokenLanguages) {
    this.spokenLanguages = spokenLanguages;
  }

  /**
   * @return The status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status The status
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * @return The tagline
   */
  public String getTagline() {
    return tagline;
  }

  /**
   * @param tagline The tagline
   */
  public void setTagline(String tagline) {
    this.tagline = tagline;
  }

  /**
   * @return The title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title The title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return The voteAverage
   */
  public Double getVoteAverage() {
    return voteAverage;
  }

  /**
   * @param voteAverage The vote_average
   */
  public void setVoteAverage(Double voteAverage) {
    this.voteAverage = voteAverage;
  }

  /**
   * @return The voteCount
   */
  public Integer getVoteCount() {
    return voteCount;
  }

  /**
   * @param voteCount The vote_count
   */
  public void setVoteCount(Integer voteCount) {
    this.voteCount = voteCount;
  }
}
