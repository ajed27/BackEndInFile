package com.infile.api.service;

import com.infile.api.data.news.NewResponse;
import com.infile.api.model.New;
import com.infile.api.repository.NewRepository;
import com.infile.api.structure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class NewService {

    @Autowired
    NewRepository newRepository;

    public Map<String, Object> getAll(){
        List<New> newList = this.newRepository.findNewsByState(true);
        if (newList.isEmpty()){
            return Response.getResponse(5000, "", "");
        }
        List<NewResponse> newResponses = new ArrayList<>();
        for (New news : newList){
            NewResponse newResponse = new NewResponse(news);
            newResponses.add(newResponse);
        }
        return Response.getResponse(1000, newResponses, "");
    }

    public Map<String, Object> getThree(){
        List<New> newList = this.newRepository.findNewsByState(true);
        if (newList.isEmpty()){
            return Response.getResponse(5000, "", "");
        }
        List<NewResponse> newResponses = new ArrayList<>();
        int i = 1;
        for (New news : newList){
            NewResponse newResponse = new NewResponse(news);
            newResponses.add(newResponse);
            i++;
            if(i == 4){
                break;
            }
        }
        return Response.getResponse(1000, newResponses, "");
    }

    public Map<String, Object> get(Long idNew){
        New news = this.newRepository.findNewByIdNew(idNew);
        if (news == null){
            return Response.getResponse(5000, "", "");
        }
        return Response.getResponse(1000, new NewResponse(news), "");
    }

}
