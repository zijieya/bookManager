package bookmanager.web.service.impl;

import bookmanager.web.dao.UserRoleDao;
import bookmanager.web.model.UserRole;
import bookmanager.web.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleDao userRoleDao;
    @Override
    public UserRole getUserRole(int userId) {
        return  userRoleDao.getUserRole(userId);
    }
}
