package com.xolidon.winter;

import com.xolidon.winter.domain.user.dto.UserUpdate;
import com.xolidon.winter.domain.user.entity.User;
import com.xolidon.winter.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import javax.transaction.Transactional;

@Transactional
@SpringBootTest
class WinterApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void addUser() {
        UserUpdate userUpdate = new UserUpdate();
        userUpdate.setUserName("이지은");
        //userUpdate.setEmail("xolid@test.com");
        userUpdate.setPassword("abcdef");

        User user = userService.save(userUpdate);

        Assert.notNull(user.getUserId(), "");
    }

}
