package bookmanager.web.service;

import bookmanager.web.model.UserRole;

import java.util.List;

public interface UserRoleService {
    UserRole getUserRole(int userId);//获得用户权限信息
    List<UserRole> listUserRoleByType(int type);//获得某一类型的用户
    List<UserRole> listUserRoleByTypeAndPage(int type,int pageNumber, int pageSize);
    void updateUserRole(UserRole userRole);//更新用户权限信息
}
