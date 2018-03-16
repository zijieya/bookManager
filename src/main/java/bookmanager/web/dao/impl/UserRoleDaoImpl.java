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
@Repository
public class UserRoleDaoImpl implements UserRoleDao {
    @Autowired
    JdbcOperations jdbcOperations;
    @Override
    public void insertUserRole(int userId, int userType) {
        try{
            String sql="insert into userrole(userid,user_type) values(?,?)";
            Object[] params={userId,userType};
            jdbcOperations.update(sql,params);
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateUserRole(UserRole userRole) {
        try{
            String sql="update userrole set user_type=? where userid=?";
            Object[] params={userRole.getUserType(),userRole.getUserId()};
            jdbcOperations.update(sql,params);
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public UserRole getUserRole(int userId) {
        try{
            String sql="select * from userrole where userid=?";
            Object[] params={userId};
            return jdbcOperations.queryForObject(sql, params, new RowMapper<UserRole>() {
                @Override
                public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserRole userRole=new UserRole();
                    userRole.setUserRoleId(rs.getInt("userroleid"));
                    userRole.setUserId(rs.getInt("userid"));
                    userRole.setUserType(rs.getInt("user_type"));
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
