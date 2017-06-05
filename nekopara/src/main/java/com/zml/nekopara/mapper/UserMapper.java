package com.zml.nekopara.mapper;

import com.zml.nekopara.model.User;
import com.zml.nekopara.util.QueryObject;

import java.util.List;


public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
    
    User login(User user);

	User get(Long id);

	List<User> list(QueryObject qo);
}