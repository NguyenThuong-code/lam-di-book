package com.example.boschtryhard.dto;

import java.util.List;

public class PageBookDTO extends PageRequestDTO{
private List<String> categoriesFilter;
private  String authorNameFilter;
private String publisherNameFilter;

    public List<String> getCategoriesFilter() {
        return categoriesFilter;
    }

    public void setCategoriesFilter(List<String> categoriesFilter) {
        this.categoriesFilter = categoriesFilter;
    }

    public String getAuthorNameFilter() {
        return authorNameFilter;
    }

    public void setAuthorNameFilter(String authorNameFilter) {
        this.authorNameFilter = authorNameFilter;
    }

    public String getPublisherNameFilter() {
        return publisherNameFilter;
    }

    public void setPublisherNameFilter(String publisherNameFilter) {
        this.publisherNameFilter = publisherNameFilter;
    }
}
