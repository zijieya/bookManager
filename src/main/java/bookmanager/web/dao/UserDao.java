package bookmanager.web.dao;

import bookmanager.web.model.User;

import java.util.List;

public interface UserDao {
    void insertUser(User user);//增加用户
    User getUser(User user); //查找用户
    void updateUser(User user);// 更新用户信息
    User getUserByLogin(String email,String password);//在登录中获取user对象
    User getUserByUserId(int userId);//通过UserId查询用户
    User getUserByUserName(String userName);//通过用户名查询用户
    User getUserByEmail(String email);//通过邮箱查询用户
    List<User> listAllUser();//列出所有用户
    void deleteUser(int  userId);//通过用户Id删除用户
}
