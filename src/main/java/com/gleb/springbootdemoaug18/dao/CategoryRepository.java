package com.gleb.springbootdemoaug18.dao;

import com.gleb.springbootdemoaug18.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByCategoryNameAndProductsList_price(String name, double price);

    @Query(value = "from  Category c where c.categoryName =:name")
    Optional<Category> getAllBySomeCriteria(@Param("name") String name);
}
