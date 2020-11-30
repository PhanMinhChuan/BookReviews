package Ibook.Review.demo.service.impl;

import Ibook.Review.demo.entity.Categories;
import Ibook.Review.demo.repository.CategoriesRepository;
import Ibook.Review.demo.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImlp implements CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    public Categories getCatById(long id){
        return categoriesRepository.findById(id).get();
        //return null;
    }

    public Page<Categories> getAllCategories(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return categoriesRepository.findAll(pageable);
    }


    public void addCategories(Categories categories){
        //if(!categoriesRepository.existsByName(categories.getName())) {
        categories.setId(categoriesRepository.findAll().get(categoriesRepository.findAll().size() - 1).getId() + 1);
        categoriesRepository.save(categories);
        //}
    }

    public boolean deleteCategories(long id){
        if(categoriesRepository.existsById(id)){
            categoriesRepository.deleteById(id);
            return true;
        }
        else return false;
    }

    public boolean updateCategories(long id, Categories categories){
        if(categoriesRepository.existsById(categories.getId())){
            Categories cat = categoriesRepository.findById(id).get();

            cat.setName(categories.getName());
            categoriesRepository.save(cat);
            //categoriesRepository.insert(categories);
            return true;
        }
        else return false;
    }

    @Override
    public Integer getSize() {
        return categoriesRepository.findAll().size();
    }
}