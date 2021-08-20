package com.example.back.api.controller.login;

import com.example.back.api.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/login")
public class LoginController {

    private final PasswordEncoder passwordEncoder;

    @PostMapping("/")
    public String Login(@RequestBody User user, HttpServletResponse response, HttpSession session) {
        System.out.println(user.toString());

        try {
            String originPassword = "qwe123";
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            if (user.getId().equals("bum") && passwordEncoder.matches(originPassword, encodedPassword)) {
                System.out.println("origin : " + originPassword);
                System.out.println("encoded : " + encodedPassword);
                session.setAttribute("IsLogin", user);
//                Cookie cookie = new Cookie("SESSIONID", "IsLogin");
//                response.addCookie(cookie);
                return "Login";
            } else {
                throw new IllegalStateException("The information is incorrect.");
            }
        } catch (IllegalStateException e) {
            return e.getMessage();
        }
    };

    @GetMapping("/info")
    public void GetInfo(HttpSession session) {
        User user = (User) session.getAttribute("IsLogin");
        System.out.println(user.getId());
    };
}
