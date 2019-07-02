package org.angrybeard.spiritboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.angrybeard.spiritboot.dto.BaseResponse;
import org.angrybeard.spiritboot.dto.UserDto;
import org.angrybeard.spiritboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by angry_beary on 2019/7/2.
 */
@Slf4j
@RestController
public class AdminController {

    @Autowired
    private IUserService userService;

    @GetMapping("/queryuser/{name}")
    public BaseResponse<UserDto> queryUserInfo(@PathVariable(value = "name") String name) {
        BaseResponse baseResponse;
        try {
            baseResponse = BaseResponse.success(userService.queryUserInfo(name));
        } catch (Exception e) {
            baseResponse = BaseResponse.badRequst();
        }
        return baseResponse;
    }

    @RequestMapping("/insertuser")
    public BaseResponse<UserDto> insertUser(@ModelAttribute UserDto userDto) {
        return BaseResponse.success(userService.insertUserInfo(userDto));
    }

    @PutMapping("/updateuser")
    public BaseResponse<UserDto> updateUser(Integer id) {
        log.info("id={}", id);
        return BaseResponse.badRequst();
    }

    @DeleteMapping("/deluser")
    public BaseResponse<UserDto> delUser(String name) {
        log.info("name={}", name);
        return BaseResponse.badRequst();
    }
}
