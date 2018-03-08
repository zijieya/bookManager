package bookmanager.web.service;

import bookmanager.web.model.User;

public interface UserService {
        User getLoginUser(User user);//获取登录的用户
        void getCode(String email); //发送验证码
}
