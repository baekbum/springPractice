package com.example.back.api.controller.login;

import com.example.back.api.dto.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @PostMapping("/")
    public String Login(@RequestBody User user, HttpServletResponse response, HttpSession session) {
        System.out.println(user.toString());

        try {
            if (user.getId().equals("bum") && user.getPassword().equals("1234")) {
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
