package com.example.online_class;

import com.example.online_class.mapper.UserMapper;
import com.example.online_class.model.entity.User;
import com.example.online_class.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class OnlineClassApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testDBConnect() {
        User user = userMapper.findByUserId(18);
        log.info("user: {}", user);
    }

    @Test
    public void testGeneJwt() {
        User user = new User();
        user.setId(66);
        user.setName("二当家小D");
        user.setHeadImg("png");

        String token = JWTUtils.geneJsonWebToken(user);

        System.out.println(token);

        Claims claims = JWTUtils.checkJWT(token);

        System.out.println(claims.get("name"));


    }


}
