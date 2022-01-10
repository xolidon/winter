package com.xolidon.winter.domain.user.service;

import com.xolidon.winter.domain.user.dto.UserUpdate;
import com.xolidon.winter.domain.user.entity.User;
import com.xolidon.winter.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long userId) {
        return userRepository.findById(userId);
    }

    public User save(UserUpdate userUpdate) {
        return userRepository.save(userUpdate.toEntity());
    }

    public void delete(User user) {
        userRepository.delete(user);
    }
}
