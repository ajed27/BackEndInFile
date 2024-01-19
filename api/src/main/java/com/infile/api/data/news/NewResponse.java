package com.infile.api.data.news;

import com.infile.api.model.New;

public record NewResponse(Long idNew, String news, String description, String image) {
    public NewResponse(New news){
        this(news.getIdNew(), news.getNews(), news.getDescription(), news.getImage());
    }
}
