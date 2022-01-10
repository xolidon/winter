package com.xolidon.winter.domain.user.web;

import com.xolidon.winter.domain.user.dto.UserUpdate;
import com.xolidon.winter.domain.user.entity.User;
import com.xolidon.winter.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> list() {
        return new ResponseEntity<>(userService.getUserList(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> detail(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(userService.getUser(userId).orElse(null), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid UserUpdate userUpdate) {
        userService.save(userUpdate);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity delete(@RequestBody User user) {
        userService.delete(user);

        return new ResponseEntity(HttpStatus.OK);
    }
}
