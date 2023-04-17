package ru.vafonov.dotsphotospring.api.controllers;

import jakarta.transaction.Transactional;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import ru.vafonov.dotsphotospring.orm.dto.UserDto;
import ru.vafonov.dotsphotospring.orm.entities.User;
import ru.vafonov.dotsphotospring.orm.mappers.UserMapper;
import ru.vafonov.dotsphotospring.services.UserService;
import ru.vafonov.dotsphotospring.utils.JwtTokenUtils;

import java.security.Principal;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @PostMapping(path = "/register")
    public ResponseEntity<User> registerUser(JwtAuthenticationToken token) {
        return ResponseEntity.ok(userService.registerUser(JwtTokenUtils.getUserNameFromToken(token)));
    }

    @GetMapping(path = "/check")
    @Transactional
    public ResponseEntity<String> check(JwtAuthenticationToken token) {
        String userNickname = JwtTokenUtils.getUserNameFromToken(token);
        User user = userService.findByNickname(userNickname);
        user = user == null ? userService.registerUser(userNickname) : user;
        return ResponseEntity.ok("");
    }
}
