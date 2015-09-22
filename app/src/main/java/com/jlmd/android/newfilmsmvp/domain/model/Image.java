package com.jlmd.android.newfilmsmvp.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author jlmd
 */
public class Image implements Parcelable {

  @SuppressWarnings("unused") public static final Parcelable.Creator<Image> CREATOR =
      new Parcelable.Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
          return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
          return new Image[size];
        }
      };
  private String lowResolutionImgUrl;
  private String mediumResolutionImgUrl;
  private String highResolutionImgUrl;

  public Image() {
    // Empty constructor
  }

  protected Image(Parcel in) {
    lowResolutionImgUrl = in.readString();
    mediumResolutionImgUrl = in.readString();
    highResolutionImgUrl = in.readString();
  }

  public String getLowResolutionImgUrl() {
    return lowResolutionImgUrl;
  }

  public void setLowResolutionImgUrl(String lowResolutionImgUrl) {
    this.lowResolutionImgUrl = lowResolutionImgUrl;
  }

  public String getMediumResolutionImgUrl() {
    return mediumResolutionImgUrl;
  }

  public void setMediumResolutionImgUrl(String mediumResolutionImgUrl) {
    this.mediumResolutionImgUrl = mediumResolutionImgUrl;
  }

  public String getHighResolutionImgUrl() {
    return highResolutionImgUrl;
  }

  public void setHighResolutionImgUrl(String highResolutionImgUrl) {
    this.highResolutionImgUrl = highResolutionImgUrl;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(lowResolutionImgUrl);
    dest.writeString(mediumResolutionImgUrl);
    dest.writeString(highResolutionImgUrl);
  }
}
