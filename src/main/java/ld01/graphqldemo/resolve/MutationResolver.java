package ld01.graphqldemo.resolve;

import graphql.kickstart.tools.GraphQLMutationResolver;
import ld01.graphqldemo.entity.User;
import ld01.graphqldemo.service.impl.UserService;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {
    @Autowired
    private UserService userService;

    public User saveUser(User user) {
        return userService.save(user);
    }

    public String deleteUser(Long id) {
        userService.deleteUser(id);
        return "User with ID " + id + " has been deleted.";
    }
}
