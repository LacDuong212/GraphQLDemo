package ld01.graphqldemo.service;

import ld01.graphqldemo.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();
}
