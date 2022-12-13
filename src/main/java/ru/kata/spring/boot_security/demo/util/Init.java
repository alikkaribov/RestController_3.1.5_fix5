package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class

Init {

    private UserServiceImpl userService;
    private RoleServiceImpl roleService;

    @Autowired
    public Init(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");

        roleService.add(role1);
        roleService.add(role2);

        List<Role> roleAdmin = new ArrayList<>();
        List<Role> roleUser = new ArrayList<>();
        List<Role> allRoles = new ArrayList<>();

        allRoles.add(role1);
        allRoles.add(role2);
        roleAdmin.add(role1);
        roleUser.add(role2);

        User user1 = new User("admin", "adminovich", "32", "admin@gmail.com", "admin", roleAdmin);
        User user2 = new User("user", "userovich", "12", "user@gmail.com", "user", roleUser);
        User user3 = new User("admin", "adminovich1", "43", "admin@gmail.com", "admin1", roleAdmin);
        User user4 = new User("user1", "userovich1", "34", "user1@gmail.com", "user1", roleUser);
        User user5 = new User("test", "test", "25", "test", "test", allRoles);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        userService.add(user5);
    }
}
