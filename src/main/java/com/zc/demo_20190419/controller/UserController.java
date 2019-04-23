package com.zc.demo_20190419.controller;

import com.zc.demo_20190419.domain.entity.SysUser;
import com.zc.demo_20190419.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public Map<String, Object> getUserList(@RequestParam(defaultValue = "1") int pageIndex, @RequestParam(defaultValue = "1") int pageSize, String searchKey) {
        return userService.userList(pageIndex, pageSize, searchKey);
    }

    //删除用户
    @GetMapping("/del")
    @ResponseBody
    public String removeUser(@RequestParam("id") String id) {
        boolean result = userService.delUser(id);
        if (StringUtils.isEmpty(id)){
            return "failed";
        }
        return result ? "success" : "failed";
    }

    //修改用户
    @PostMapping("/update")
    @ResponseBody
    public String updateUser(@RequestBody SysUser user) {
        boolean result = userService.saveUser(user);

        return result ? "success" : "failed";
    }

    //检查登录名是否重复
    @GetMapping("/checkLoginName")
    @ResponseBody
    public String checkLoginName( String loginName, String id){

         if (!StringUtils.isEmpty(loginName)){
            return userService.checkLoginName(loginName,id)?"failed":"success";
         }else{

         }
         return "failed";
    }

    //查询单个用户数据
    @GetMapping("/userInfo")
    @ResponseBody
    public Map<String,Object> userInfo(@RequestParam String id){
        String msg="success";
        Map<String,Object> data=new HashMap<>();
        if (StringUtils.isEmpty(id)){
            msg="failed";
        }else{
            SysUser user=userService.findOne(id);
            if (user==null){
                msg="failed";
            }else{
                data.put("user",user);
            }
        }


        data.put("msg",msg);
        return data;

    }
}
