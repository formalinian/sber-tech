package com.sber.test;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService {
    private static final Map<Integer, User> USER_MAP = new HashMap<>();
    private static final AtomicInteger USER_ID = new AtomicInteger();

    public void create(User user) {
        final int userId = USER_ID.incrementAndGet();
        user.setId(userId);
        USER_MAP.put(userId, user);
    }

    public Map<Integer, User> getUserMap() {
        return USER_MAP;
    }

    public List<User> readAll() {
        return new ArrayList<>(USER_MAP.values());
    }

    public User readUser(int id) {
        if (USER_MAP.containsKey(id)){
            return USER_MAP.get(id);
        }
        return null;
    }

    public boolean update(User user, int id) {
        if (USER_MAP.containsKey(id)) {
            user.setId(id);
            USER_MAP.put(id, user);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        return USER_MAP.remove(id) != null;
    }
}
