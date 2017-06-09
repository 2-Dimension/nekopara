package com.zml.nekopara.service.impl;

import java.util.List;

import com.zml.nekopara.mapper.UserMapper;
import com.zml.nekopara.model.User;
import com.zml.nekopara.service.IUserService;
import com.zml.nekopara.util.QueryObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public void regist(User user) {
		userMapper.insert(user);
	}

	@Override
	public User login(User user) {
		return userMapper.login(user);
	}

	@Override
	public void delete(Long id) {
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User get(Long id) {
		return userMapper.get(id);
	}

	@Override
	public List<User> list(QueryObject qo) {
		return userMapper.list(qo);
	}

	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKey(user);
	}

}
