package com.study.helloworld.apiController;

import com.study.helloworld.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/get")
public class GetController {

    @GetMapping("/{name}")
    public String getByPathVariable(@PathVariable String name){
        return name;
    }

    @GetMapping("/query-param")
    public String getByRequestParam(@RequestParam String name,
                                    @RequestParam String email,
                                    @RequestParam int id){
        return name + " " + email + " " + id;
    }

    @GetMapping("/query-param-map")
    public String getByRequestParamUsingMap(@RequestParam Map<String,String> queryParamMap){
        queryParamMap.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
        return "";
    }

    @GetMapping("/query-param-dto")
    public String getByRequestParamUsingDto(UserRequest userRequest){
        System.out.println(userRequest.toString());
        return userRequest.toString();
    }

}
