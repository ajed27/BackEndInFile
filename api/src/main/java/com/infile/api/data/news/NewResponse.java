package com.infile.api.data.news;

import com.infile.api.model.New;

public record NewResponse(Long idNew, String description, String image) {
    public NewResponse(New news){
        this(news.getIdNew(), news.getDescription(), news.getImage());
    }
}
