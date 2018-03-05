package bookmanager.web.service.impl;

import bookmanager.web.dao.UserDao;
import bookmanager.web.model.User;
import bookmanager.web.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoServiceImpl implements UserDaoService {
    private UserDao userDao;
    //注入userDao
    @Autowired
    public UserDaoServiceImpl(UserDao userDao){
        this.userDao=userDao;
    }
    @Override
    public User getLoginUser(User user) {
        //当user不为null时则表明此用户存在
        if(userDao.getUser(user)!=null){
            return user;
        }
        else
            return null;
    }
}
