package com.infile.api.data.news;

import com.infile.api.model.New;

public record NewResponse(Long idNew, String news, String description, String image, Long idCategory) {
    public NewResponse(New news){
        this(news.getIdNew(), news.getNews(), news.getDescription(), news.getImage(), news.getCategory().getIdCategory());
    }
}
