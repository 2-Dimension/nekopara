package com.zml.nekopara.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zml.nekopara.mapper.UserMapper;
import com.zml.nekopara.model.User;
import com.zml.nekopara.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserMapper userMapper;
	@Override
	public void save(User user) {
		userMapper.insert(user);
	}}
