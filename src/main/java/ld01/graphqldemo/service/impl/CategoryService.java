package ld01.graphqldemo.service.impl;

import ld01.graphqldemo.entity.Category;
import ld01.graphqldemo.repository.CategoryRepository;
import ld01.graphqldemo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
