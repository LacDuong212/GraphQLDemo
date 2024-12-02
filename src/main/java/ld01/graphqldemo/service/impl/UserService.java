package ld01.graphqldemo.service.impl;

import jakarta.persistence.EntityNotFoundException;
import ld01.graphqldemo.entity.Category;
import ld01.graphqldemo.entity.User;
import ld01.graphqldemo.repository.CategoryRepository;
import ld01.graphqldemo.repository.UserRepository;
import ld01.graphqldemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Category> getCategoriesByUserId(Long userId) {
        return categoryRepository.findCategoriesByUserId(userId);
    }

    @Override
    public <S extends User> S save(S user) {
        if (user.getId() == null) {
            return userRepository.save(user);
        } else {
            Optional<User> customerOptional = userRepository.findById(user.getId());
            if (customerOptional.isPresent()) {
                return userRepository.save(user);
            } else {
                throw new EntityNotFoundException("User with ID " + user.getId() + " does not exist.");
            }
        }
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("User with ID " + id + " does not exist.");
        }
    }
}
