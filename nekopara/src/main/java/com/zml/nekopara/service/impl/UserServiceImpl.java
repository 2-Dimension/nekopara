package com.zml.nekopara.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user5u.myweb.domain.User;
import com.user5u.myweb.mapper.UserMapper;
import com.user5u.myweb.service.IUserService;
import com.user5u.myweb.util.QueryObject;

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
