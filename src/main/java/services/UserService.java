package com.russellroy.a1;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<String, AppUser> users = new HashMap<>();

    public UserService() {
        users.put("RASERUI", new AppUser("RASERUI", "pass123"));
    }

    public AppUser findByUsername(String username) {
        return users.get(username);
    }
}
