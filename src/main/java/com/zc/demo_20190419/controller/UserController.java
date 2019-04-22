package com.zc.demo_20190419.controller;

import com.zc.demo_20190419.domain.entity.SysUser;
import com.zc.demo_20190419.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index() {
        return "user/temp";
    }
    @GetMapping("/test")
    public String test() {
        return "user/test";
    }

    @GetMapping("/userList")
    @ResponseBody
    public Map<String, Object> getUserList(@RequestParam(defaultValue = "1")int pageIndex,@RequestParam(defaultValue = "1") int pageSize, String searchKey) {
        return userService.userList(pageIndex, pageSize, searchKey);
    }

    //删除用户
    @GetMapping("/del")
    @ResponseBody
    public String removeUser(@RequestParam(defaultValue = "-1") String id) {
        boolean result = userService.delUser(id);

        return result?"success":"failed";
    }

    //修改用户
    @PostMapping("/update")
    @ResponseBody
    public String updateUser(@RequestBody SysUser user,boolean userSex){

        user.setSex(userSex?1:0);
        userService.saveUser(user);
        return "";
    }

}
