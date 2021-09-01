package com.example.back.api.controller.redis;

import com.example.back.api.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/redis")
public class RedisController {

    private final RedisTemplate<String, String> redisTemplate;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/set")
    public String setRedisData(@RequestBody User user) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        try {
            operations.set(user.getId(), passwordEncoder.encode(user.getPassword()));
            //operations.set(user.getId(), user.getPassword());
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }

        return "succ";
    }

    @GetMapping("/get/{key}")
    public String setRedisData(@PathVariable String key) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String password = "";

        try {
            password = operations.get(key);
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }

        return password;
    }

}
