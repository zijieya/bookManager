package bookmanager.web.service.impl;

import bookmanager.web.dao.UserRoleDao;
import bookmanager.web.model.Page;
import bookmanager.web.model.UserRole;
import bookmanager.web.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleDao userRoleDao;

    /**
     *
     * @param userId
     * @return
     */
    @Override
    public UserRole getUserRole(int userId) {
        return  userRoleDao.getUserRole(userId);
    }

    /**
     * 列出某类型的用户
     * @param type
     * @return
     */
    @Override
    public List<UserRole> listUserRoleByType(int type) {
        return userRoleDao.listUserRoleByType(type);
    }

    /**
     * 列出某页某角色的用户信息
     * @param type
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public List<UserRole> listUserRoleByTypeAndPage(int type, int pageNumber, int pageSize) {
        int totalRecord=userRoleDao.listUserRoleByType(type).size();//总数
        Page page=new Page(pageNumber,pageSize,totalRecord);
        int startIndex=page.getStartIndex();
        return userRoleDao.listUserRoleByTypeAndPage(type,startIndex,pageSize);
    }

    /**
     * 更新用户信息
     * @param userRole
     */
    @Override
    public void updateUserRole(UserRole userRole) {
        userRoleDao.updateUserRole(userRole);
    }
}
