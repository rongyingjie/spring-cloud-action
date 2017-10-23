package cn.gxufe.spring.cloud.provider.controller;

import cn.gxufe.spring.cloud.provider.entity.User;
import cn.gxufe.spring.cloud.provider.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("id/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") String id){
        return null;
    }


    @RequestMapping("list")
    @ResponseBody
    public PageInfo<User> getUserAll(
            @RequestParam(name = "page",defaultValue = "0") Integer page,
            @RequestParam(name = "paseSize",defaultValue = "5")Integer paseSize){
        return userService.findAll( page,paseSize );
    }


}
