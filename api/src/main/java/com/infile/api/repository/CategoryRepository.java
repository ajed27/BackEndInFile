package com.infile.api.repository;

import com.infile.api.model.CategoryNew;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryNew, Long> {

    List<CategoryNew> findCategoryNewByState(Boolean state);

    CategoryNew findByIdCategory(Long idCategory);
}
