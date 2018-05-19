package com.java.testdriven.chapter08.alexandria;

import static java.util.stream.Collectors.toList;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Users {
    private final ConcurrentLinkedQueue<User> users;
    private AtomicInteger counter = new AtomicInteger(1);

    public Users() {
        users = new ConcurrentLinkedQueue<>();
    }

    private Users(Stream<User> userStream) {
        this.users = new ConcurrentLinkedQueue<>(userStream.collect(toList()));
    }


    public boolean isEmpty() {
        return users.isEmpty();
    }

    public void add(User user) {
        user.setId(counter.get());
        users.add(user);
    }

    public Users filterBy(String userId) {
        return new Users(users.stream().filter(x -> x.getId() == Integer.valueOf(userId)));
    }
}
