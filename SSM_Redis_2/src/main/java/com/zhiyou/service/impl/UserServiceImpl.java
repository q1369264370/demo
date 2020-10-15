package com.zhiyou.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zhiyou.dao.UserDao;
import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userdao;
	@Autowired
	RedisTemplate<String, String> redis;
	
	public void add(User user) {
		userdao.add( user);
	}
	public void update(User user) {
		userdao.update( user);	
	}
	// ���������Ҫ�������ķ���,�Լ�ָ����Ҫ����Ļ���		allEntries�������Ƿ���������е�����Ԫ��
	@CacheEvict(value="userSelect",allEntries=true)
	public void delete(int id) {
		userdao.delete(id);
	}

	// ָ���������������Ҫʹ�û���,ʹ�û�������ֽ�userSelect,�����keyΪ �����page��ֵ
	@Cacheable(value="userSelect",key="#page")
	public List<User> select(int page) {
		PageHelper.startPage(page,5);
		return  userdao.select();
	}
	
	
	@Cacheable(value="userSelect",key="T(String).valueOf(#id).concat('heihei')")
	public User selectById(int id) {
		return userdao.selectById(id);
	}

}
