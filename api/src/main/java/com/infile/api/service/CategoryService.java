package com.infile.api.service;

import com.infile.api.data.category.CategoryResponse;
import com.infile.api.model.CategoryNew;
import com.infile.api.repository.CategoryRepository;
import com.infile.api.structure.response.ResponseCode;
import com.infile.api.structure.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public ResponseMessage getAll(){

        List<CategoryNew> categoryNews = this.categoryRepository.findCategoryNewByState(true);
        if (categoryNews.isEmpty()){
            return new ResponseMessage(ResponseCode.DATA_NOT_FOUND,  "");
        }
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (CategoryNew categoryNew : categoryNews){
            CategoryResponse categoryResponse = new CategoryResponse(categoryNew);
            categoryResponses.add(categoryResponse);
        }
        return new ResponseMessage(ResponseCode.SUCCESS, categoryResponses);
    }

}
