package cn.gxufe.spring.cloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/data")
    @ResponseBody
    public String data(@RequestParam("page") Integer page,
                       @RequestParam("paseSize") Integer paseSize){
        return restTemplate.getForObject("http://provider-server/user/list?page="+page+"&paseSize="+paseSize,String.class);
    }

}
