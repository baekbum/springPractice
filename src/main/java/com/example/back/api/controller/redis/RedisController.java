package com.example.back.api.controller.redis;

import com.example.back.api.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/redis")
public class RedisController {

    private final RedisTemplate<String, String> redisTemplate;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/set")
    public String setRedisData(@RequestBody User user) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        byte[] serializedUser;
        String serializedUserStr = "";

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(user);
            serializedUser = baos.toByteArray();
            serializedUserStr = Base64.getEncoder().encodeToString(serializedUser);
            operations.set(user.getId(), serializedUserStr);
            //operations.set(user.getId(), user.getPassword());
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }

        return "succ";
    }

    @GetMapping("/get/{key}")
    public String setRedisData(@PathVariable String key) {
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        User user;
        try {
            String serializedUserStr = operations.get(key);
            byte[] serializedUser = Base64.getDecoder().decode(serializedUserStr);
            ByteArrayInputStream bais = new ByteArrayInputStream(serializedUser);
            ObjectInputStream ois = new ObjectInputStream(bais);

            Object obj = ois.readObject();
            user = (User) obj;
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }

        return user.toString();
    }

}
