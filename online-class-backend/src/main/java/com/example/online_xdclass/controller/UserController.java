package com.example.online_xdclass.controller;

import com.example.online_xdclass.model.entity.User;
import com.example.online_xdclass.model.request.LoginRequest;
import com.example.online_xdclass.service.UserService;
import com.example.online_xdclass.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pri/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册接口
     * @param userInfo
     * @return
     */
    @PostMapping("register")
    public JsonData register(@RequestBody Map<String,String> userInfo ){

        int rows = userService.save(userInfo);

        return rows == 1 ? JsonData.buildSuccess(): JsonData.buildError("注册失败，请重试");

    }


    /**
     * 登录接口
     * @param loginRequest
     * @return
     */
    @PostMapping("login")
    public JsonData login(@RequestBody LoginRequest loginRequest){

        String token = userService.findByPhoneAndPwd(loginRequest.getPhone(), loginRequest.getPwd());

        return token == null ?JsonData.buildError("登录失败，账号密码错误"): JsonData.buildSuccess(token);

    }

    /**
     * 根据用户id查询用户信息
     * @param request
     * @return
     */
    @GetMapping("find_by_token")
    public JsonData findUserInfoByToken(HttpServletRequest request){

        Integer userId = (Integer) request.getAttribute("user_id");

        if(userId == null){
            return JsonData.buildError("查询失败");
        }

        User user =  userService.findByUserId(userId);

        return JsonData.buildSuccess(user);

    }




}
