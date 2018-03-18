package bookmanager.web.dao;

import bookmanager.web.model.UserRole;

import java.util.List;

public interface UserRoleDao {
    void insertUserRole(int userId,int userType);//插入用户权限
    void updateUserRole(UserRole userRole);//更新用户权限
    UserRole getUserRole(int userId);//得到用户权限信息
    List<UserRole> listAllUserRole();//列出所有用户角色
    List<UserRole> listUserRoleByType(int type);//列出某一类型的用户
    List<UserRole> listUserRoleByTypeAndPage(int type, int startIndex, int pageSize);//列出某用户一页的信息
 }
