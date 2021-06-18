package com.e.dagger.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Photos {
    Integer albumId;
    Integer id;
    String title;
    String url;
    String thumbnailUrl;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photos photos = (Photos) o;
        return Objects.equals(albumId, photos.albumId) &&
                Objects.equals(id, photos.id) &&
                Objects.equals(title, photos.title) &&
                Objects.equals(url, photos.url) &&
                Objects.equals(thumbnailUrl, photos.thumbnailUrl);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(albumId, id, title, url, thumbnailUrl);
    }
}
