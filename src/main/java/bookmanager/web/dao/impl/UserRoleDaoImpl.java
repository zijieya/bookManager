package bookmanager.web.dao.impl;

import bookmanager.web.dao.UserRoleDao;
import bookmanager.web.model.Borrow;
import bookmanager.web.model.User;
import bookmanager.web.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {
    @Autowired
    JdbcOperations jdbcOperations;

    @Override
    public void insertUserRole(int userId, int userType) {
        try {
            String sql = "INSERT INTO userrole(userid,user_type) VALUES(?,?)";
            Object[] params = {userId, userType};
            jdbcOperations.update(sql, params);
        } catch (EmptyResultDataAccessException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateUserRole(UserRole userRole) {
        try {
            String sql = "UPDATE userrole SET user_type=? WHERE userid=?";
            Object[] params = {userRole.getUserType(), userRole.getUserId()};
            jdbcOperations.update(sql, params);
        } catch (EmptyResultDataAccessException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获得某用户的权限
     * @param userId
     * @return
     */
    @Override
    public UserRole getUserRole(int userId) {
        try {
            String sql = "SELECT * FROM userrole WHERE userid=?";
            Object[] params = {userId};
            return jdbcOperations.queryForObject(sql, params, new RowMapper<UserRole>() {
                @Override
                public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserRole userRole = new UserRole();
                    userRole.setUserRoleId(rs.getInt("userroleid"));
                    userRole.setUserId(rs.getInt("userid"));
                    userRole.setUserType(rs.getInt("user_type"));
                    return userRole;
                }
            });
        } catch (EmptyResultDataAccessException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 列出所有用户权限
     * @return
     */
    @Override
    public List<UserRole> listAllUserRole() {
        try {
            String sql = "SELECT * FROM userrole";
            return jdbcOperations.query(sql, new RowMapper<UserRole>() {
                @Override
                public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserRole userRole = new UserRole();
                    userRole.setUserRoleId(rs.getInt("userroleid"));
                    userRole.setUserId(rs.getInt("userid"));
                    userRole.setUserType(rs.getInt("userId"));
                    return userRole;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }
    /**
     * 列出某一类型的用户
     * @param type
     * @return
     */
    @Override
    public List<UserRole> listUserRoleByType(int type) {
        try {
            String sql = "SELECT * FROM userrole WHERE user_type=?";
            Object[] params={type};
            return jdbcOperations.query(sql, params,new RowMapper<UserRole>() {
                @Override
                public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserRole userRole = new UserRole();
                    userRole.setUserRoleId(rs.getInt("userroleid"));
                    userRole.setUserId(rs.getInt("userid"));
                    userRole.setUserType(rs.getInt("userId"));
                    return userRole;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 列出一页某一类型的用户
     * @param type
     * @param startIndex
     * @param pageSize
     * @return
     */
    @Override
    public List<UserRole> listUserRoleByTypeAndPage(int type, int startIndex, int pageSize) {
        try {
            String sql = "SELECT * FROM userrole WHERE user_type=? LIMIT ?,?";
            Object[] params={type,startIndex,pageSize};
            return jdbcOperations.query(sql, params,new RowMapper<UserRole>() {
                @Override
                public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserRole userRole = new UserRole();
                    userRole.setUserRoleId(rs.getInt("userroleid"));
                    userRole.setUserId(rs.getInt("userid"));
                    userRole.setUserType(rs.getInt("userId"));
                    return userRole;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

}