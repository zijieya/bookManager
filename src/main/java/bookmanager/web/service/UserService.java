package bookmanager.web.service;

import bookmanager.web.model.User;

import java.util.List;

public interface UserService {
        User getLoginUser(User user);//获取登录的用户
        int getCode(String email); //发送验证码
        User getUserByEmail(String email);//通过邮箱获取用户信息
        void updateUser(User user);//更新用户信息
        void insertUser(User user);//新增用户
        List<User> listUserByPage( int pageNumber, int pageSize);//列出一页用户
        int getUserNumber();//得到用户的数量
        void deleteUser(int userId);//删除用户
}
