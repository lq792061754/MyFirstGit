package com.lq.login.service;

import com.lq.login.dao.UserDao;
import com.lq.login.exception.ParamException;
import com.lq.login.exception.ServiceException;
import com.lq.login.po.User;

public class UserService {

    public User login(String userName, String password) throws ParamException, ServiceException {
        ParamException paramException = new ParamException();
        if ("".equals(userName) || userName == null) {
            paramException.addErrorFileds("errorUser", "userName is required");
        }
        if ("".equals(password) || password == null) {
            paramException.addErrorFileds("errorPassword", "password is required");
        }
        if (paramException.isErrorFileds()) {
            throw paramException;
        }
        UserDao userdao = new UserDao();
        User user = userdao.getUserByName(userName);
        if (user == null) {
            throw new ServiceException(1000, "用户不存在");
        }
        if (!password.equals(user.getPassword())) {
            throw new ServiceException(1001, "密码错误");
        }
        return user;
    }

}
