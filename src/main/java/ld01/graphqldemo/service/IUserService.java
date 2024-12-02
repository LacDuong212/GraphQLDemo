package ld01.graphqldemo.service;

import ld01.graphqldemo.entity.Category;
import ld01.graphqldemo.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    List<Category> getCategoriesByUserId(Long userId);
    <S extends User> S save(S user);
    public void deleteUser(Long id);
}
