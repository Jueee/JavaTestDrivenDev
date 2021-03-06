package com.java.testdriven.chapter08.alexandria;

public class UserRepository {

    private final Users users;

    public UserRepository() {
        users = new Users();
        users.add(new User("John Doe"));
    }

    public Users findById(String userId) {
        return users.filterBy(userId);
    }
}
