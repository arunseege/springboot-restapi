package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class UserDaoService {

    private static int usersCount=0;
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(++usersCount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount,"Eve", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount,"Jim", LocalDate.now().minusYears(30)));

    }

    public List<User> findAll(){
        return users;
    }

    public User find(int id) {
       return users.stream().filter((user)-> user.getId()==id).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void delete(int id) {
        Predicate<? super User> predicate = user -> user.getId()==id;
    users.removeIf(predicate);
    }
}
