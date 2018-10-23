package com.work.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.ssm.mapper.UserDao;
import com.work.ssm.pojo.User;
@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserDao userDao;//获取UserDao对象
	
	@Override
	public User getOneUser(User user) {
		return userDao.getOneUser(user);
	}

	@Override
	public List<User> showList(int index) {
		return userDao.showList(index);
	}

	@Override
	public int pageCount() {
		return userDao.pageCount();
	}

	@Override
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public User getOneUserById(int id) {
		return userDao.getOneUserById(id);
	}

	@Override
	public List<User> getUserByNameOrTel(User user) {
		return userDao.getUserByNameOrTel(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

}
