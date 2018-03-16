package bookmanager.web.dao;

import bookmanager.web.model.UserRole;

public interface UserRoleDao {
    void insertUserRole(int userId,int userType);//插入用户权限
    void updateUserRole(UserRole userRole);//更新用户权限
    UserRole getUserRole(int userId);//得到用户权限信息
}
