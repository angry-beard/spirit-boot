package org.angrybeard.spiritboot.service.impl;

import org.angrybeard.spiritboot.dto.UserDto;
import org.angrybeard.spiritboot.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by angry_beary on 2019/7/2.
 */
@Service
public class UserService implements IUserService {

    @Override
    public UserDto queryUserInfo(String name) {
        return UserDto.builder()
                .name("疯子")
                .phone("34335466566")
                .sex("男")
                .creditCard("666666688888888")
                .birthDay(new Date())
                .build();
    }

    @Override
    public UserDto insertUserInfo(UserDto userDto) {
        int i = 1 / 0;
        return UserDto.builder()
                .name("疯子")
                .age(23)
                .phone("333")
                .sex("男")
                .creditCard("666666688888888")
                .birthDay(new Date())
                .build();
    }
}
