package com.infile.api.service;

import com.infile.api.data.news.NewResponse;
import com.infile.api.model.CategoryNew;
import com.infile.api.model.New;
import com.infile.api.repository.CategoryRepository;
import com.infile.api.repository.NewRepository;
import com.infile.api.structure.response.ResponseCode;
import com.infile.api.structure.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewService {

    @Autowired
    NewRepository newRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public ResponseMessage getAll(){
        List<New> newList = this.newRepository.findNewsByState(true);
        if (newList.isEmpty()){
            return new ResponseMessage(ResponseCode.DATA_NOT_FOUND,  "news");
        }
        List<NewResponse> newResponses = new ArrayList<>();
        for (New news : newList){
            NewResponse newResponse = new NewResponse(news);
            newResponses.add(newResponse);
        }
        return new ResponseMessage(ResponseCode.SUCCESS, newResponses);
    }

    public ResponseMessage getAllByCategory(Boolean isPageable, Long idCategory){
        CategoryNew categoryNew = this.categoryRepository.findByIdCategory(idCategory);
        if (categoryNew == null){
            return new ResponseMessage(ResponseCode.DATA_NOT_FOUND,  "category");
        }
        List<New> newList;
        if (isPageable){
            Pageable pageable = PageRequest.of(0, 3);
            newList = this.newRepository.findNewsByCategoryAndState(categoryNew, true, pageable);
        }else {
            newList = this.newRepository.findNewsByCategoryAndState(categoryNew, true);
        }
        if (newList == null){
            return new ResponseMessage(ResponseCode.ERROR,  "news");
        }
        List<NewResponse> newResponses = new ArrayList<>();
        for (New news : newList){
            NewResponse newResponse = new NewResponse(news);
            newResponses.add(newResponse);
        }
        return new ResponseMessage(ResponseCode.SUCCESS, newResponses);
    }

    public ResponseMessage get(Long idNew){
        New news = this.newRepository.findNewByIdNew(idNew);
        if (news == null){
            return new ResponseMessage(ResponseCode.DATA_NOT_FOUND, "");
        }
        return new ResponseMessage(ResponseCode.SUCCESS, new NewResponse(news));
    }

}
