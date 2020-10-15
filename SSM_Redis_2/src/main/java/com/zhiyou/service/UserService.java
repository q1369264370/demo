package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.User;

public interface UserService {

	void add(User user);
	void update(User user);
	void delete(int id);
	List<User> select(int page);
	User selectById(int id);
}
