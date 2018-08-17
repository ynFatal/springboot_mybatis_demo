package com.fatal.controller;

import com.fatal.entity.User;
import com.fatal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * User 控制器
 * @author: Fatal
 * @date: 2018/8/17 0017 16:45
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public int add(User user) {
        int record = userService.insert(user);
        return record;
    }

    @GetMapping("/")
    @ResponseBody
    public Object list(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        // 校验参数...
        return userService.list(pageNum, pageSize);
    }

}
