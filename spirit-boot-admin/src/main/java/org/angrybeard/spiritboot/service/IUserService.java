package org.angrybeard.spiritboot.service;

import org.angrybeard.spiritboot.dto.UserDto;

/**
 * Created by angry_beary on 2019/7/2.
 */
public interface IUserService {

    UserDto queryUserInfo(String name);

    UserDto insertUserInfo(UserDto userDto);
}
