package com.zml.nekopara.mapper;

import com.zml.nekopara.model.User;
import com.zml.nekopara.util.QueryObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
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