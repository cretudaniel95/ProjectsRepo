package com.onlineshop.business.category;

import com.onlineshop.business.category.domain.Category;
import com.onlineshop.business.category.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServiceImpl {
   @Autowired
   CategoryRepository categoryRepository;

   public void addCategory(Category category){
       categoryRepository.save(category);
   }


   public List<Category> getAllCategories(){
       return categoryRepository.findAll();
   }

   public void removeCategoryById(UUID id){
       categoryRepository.deleteById(id);
   }

   public Optional<Category> getCategoryById(UUID id){
       return categoryRepository.findById(id);
   }

}
