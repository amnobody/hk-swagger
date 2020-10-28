package com.howard.hkswagger.controller;

import com.howard.hkswagger.config.ResponseResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/10/21
 * @description
 */
@RestController
@RequestMapping(value = "user")
@ResponseResult
public class UserController {

    @GetMapping(value = "/{id}")
    public String detail(@PathVariable(value = "id") String id) {
        return "dtl" + id;
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable(value = "id") String id) {
        int i = 1 / 0;
        return "del" + id;
    }
}
