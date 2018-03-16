package bookmanager.web.service;

import bookmanager.web.model.UserRole;

public interface UserRoleService {
    UserRole getUserRole(int userId);//获得用户权限信息
}
