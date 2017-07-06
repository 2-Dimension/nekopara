package com.zml.nekopara.service;

import com.zml.nekopara.model.User;
import com.zml.nekopara.util.QueryObject;

import java.util.List;

/**
 * 用户
 * @author maylor
 *
 */
public interface IUserService {

	void regist(User user);
	User login(User user);
	void delete(Long id);
	User get(Long id);
	List<User> list(QueryObject qo);
	void update(User user);
}
