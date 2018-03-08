package bookmanager.web.service.impl;

import bookmanager.web.dao.UserDao;
import bookmanager.web.model.User;
import bookmanager.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    JavaMailSender javaMailSender; //注入邮箱配置
    private UserDao userDao;
    //注入userDao
    @Autowired
    public UserServiceImpl(UserDao userDao){//注入用户数据库操作
        this.userDao=userDao;
    }
    /**
     * @description 获取登录用户信息
     * @param user
     * @return user
     */
    @Override
    public User getLoginUser(User user) {
        //当user不为null时则表明此用户存在
        User user1=userDao.getUser(user);
        if(user1!=null){
            return user1;
        }
        else
            return null;
    }

    /**
     * @description 发送验证码
     * @param email
     * @return int
     */
    @Override
    public int getCode(String email) {
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        Random random=new Random();
        int number=random.nextInt(100000)+1;
        String message="您的验证码为"+number;
        //发信内容
        simpleMailMessage.setFrom("test@jieblog.cn");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("验证码");
        simpleMailMessage.setText(message);
        javaMailSender.send(simpleMailMessage);
        return number;
    }

    /**
     *
     * @param email
     * @return User
     */
    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    /**
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }
}
