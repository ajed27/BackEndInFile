package com.infile.api.data.category;

import com.infile.api.model.CategoryNew;

public record CategoryResponse(Long idCategory, String category) {
    public CategoryResponse(CategoryNew categoryNew){
        this(categoryNew.getIdCategory(), categoryNew.getCategory());
    }
}
