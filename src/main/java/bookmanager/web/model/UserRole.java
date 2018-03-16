package bookmanager.web.model;

public class UserRole {
    private int userRoleId;//用户角色编号
    private int userId;//用户编号
    private int userType;//用户类型 0普通用户 1 管理员 2 黑名单用户

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
