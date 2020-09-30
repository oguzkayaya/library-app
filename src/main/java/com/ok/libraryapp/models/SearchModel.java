package com.ok.libraryapp.models;

public class SearchModel {
    private String title;
    private String series;
    private String isbn;

    public SearchModel() {
    }

    public SearchModel(String title, String series, String isbn) {
        this.title = title;
        this.series = series;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
