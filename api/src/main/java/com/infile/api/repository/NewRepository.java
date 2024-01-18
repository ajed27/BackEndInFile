package com.infile.api.repository;

import com.infile.api.model.CategoryNew;
import com.infile.api.model.New;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewRepository extends JpaRepository<New, Long> {

    List<New> findNewsByCategoryAndState(CategoryNew category, Boolean state);

    List<New> findNewsByState(Boolean state);

    New findNewByIdNew(Long idNew);

}
