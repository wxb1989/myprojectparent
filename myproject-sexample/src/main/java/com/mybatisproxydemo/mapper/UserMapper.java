package com.mybatisproxydemo.mapper;

import com.mybatisproxydemo.annotation.Insert;
import com.mybatisproxydemo.annotation.Update;

/**
 * @author wxb
 * @version V1.0
 * @Package com.mybatisproxydemo.mapper
 * @date 2020/5/8 15:49
 */
public interface UserMapper {
    @Insert
    int insertUser(String slq);

    @Update
    int updateUser(String slq);

}
