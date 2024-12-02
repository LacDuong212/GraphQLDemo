package ld01.graphqldemo.resolve;

import graphql.kickstart.tools.GraphQLQueryResolver;
import ld01.graphqldemo.entity.Category;
import ld01.graphqldemo.entity.User;
import ld01.graphqldemo.service.impl.CategoryService;
import ld01.graphqldemo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    // Lấy tất cả Users
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Lấy tất cả Categories
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Lấy tất cả Categories của một User
    public List<Category> getCategoriesByUserId(Long userId) {
        return userService.getCategoriesByUserId(userId);
    }
}
