package com.work.ssm.mapper;

import java.util.List;
import com.work.ssm.pojo.User;

public interface UserDao {
   public User getOneUser(User user);//获取一个User对象
   public User getOneUserById(int id);//根据id获取一个User对象
   public List<User> showList(int index);//获取当前页面显示的员工信息
   public int pageCount();//获取员工总数
   public void insertUser(User user);//插入员工
   public void deleteUser(int id);//删除员工
   public void updateUser(User user);//修改员工信息
   public List<User> getUserByNameOrTel(User user);//模糊查询
   public List<User> getAllUser();
}
