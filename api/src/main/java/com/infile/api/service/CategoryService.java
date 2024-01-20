package com.infile.api.service;

import com.infile.api.data.category.CategoryResponse;
import com.infile.api.model.CategoryNew;
import com.infile.api.repository.CategoryRepository;
import com.infile.api.structure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public Map<String, Object> getAll(){

        List<CategoryNew> categoryNews = this.categoryRepository.findCategoryNewByState(true);
        if (categoryNews.isEmpty()){
            return Response.getResponse(5000, "", "");
        }
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (CategoryNew categoryNew : categoryNews){
            CategoryResponse categoryResponse = new CategoryResponse(categoryNew);
            categoryResponses.add(categoryResponse);
        }
        return Response.getResponse(1000, categoryResponses, "");
    }

}
