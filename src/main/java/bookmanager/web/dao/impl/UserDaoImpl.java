package bookmanager.web.dao.impl;

import bookmanager.web.dao.UserDao;
import bookmanager.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl  implements UserDao {
    private JdbcOperations jdbcOperations;
    //构造器注入
    @Autowired
    public UserDaoImpl(JdbcOperations jdbcOperations){
        this.jdbcOperations=jdbcOperations;
    }

    public void insertUser(User user) {
       // Object[] params={user.getUsername(),user.getEmail(),user.getPassword()};

         String sql="INSERT INTO user (username, email, password) VALUES (?,?,?)";
         Object[] params={user.getUsername(),user.getEmail(),user.getPassword()};
         jdbcOperations.update(sql,params);

    }


    public User getUser(User user) {
        try{
            String sql="select * from user where email=? and password=? ";
            Object[] params={user.getEmail(),user.getPassword()};
            return jdbcOperations.queryForObject(sql, params, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user=new User();
                    user.setUserId(rs.getInt("userid"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setAvatarUri(rs.getString("avatar_uri"));
                    user.setIsValidate(rs.getInt("is_validate"));
                    return user;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }

    }

    @Override
    public void updateUser(User user) {
        try {
            String sql = "UPDATE user SET username=?,email=?,password=?,avatar_uri=?,is_validate=? WHERE userid=?";
            Object[] params = {user.getUsername(), user.getEmail(), user.getPassword(), user.getAvatarUri(), user.getIsValidate(), user.getUserId()};
            jdbcOperations.update(sql, params);
        } catch (EmptyResultDataAccessException ex) {
            ex.printStackTrace();

        }
    }

    @Override
    public User getUserByLogin(String email, String password) {
        try{
            String sql="select * from user where email=? and password=? ";
            Object[] params={email,password};
            return jdbcOperations.queryForObject(sql, params, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user=new User();
                    user.setUserId(rs.getInt("userid"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setAvatarUri(rs.getString("avatar_uri"));
                    user.setIsValidate(rs.getInt("is_validate"));
                    return user;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserByUserId(int userId) {
        try{
            String sql="select * from user where userid=? ";
            Object[] params={userId};
            return jdbcOperations.queryForObject(sql, params, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user=new User();
                    user.setUserId(rs.getInt("userid"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setAvatarUri(rs.getString("avatar_uri"));
                    user.setIsValidate(rs.getInt("is_validate"));
                    return user;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserByUserName(String userName) {
        try{
            String sql="select * from user where username=? ";
            Object[] params={userName};
            return jdbcOperations.queryForObject(sql, params, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user=new User();
                    user.setUserId(rs.getInt("userid"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setAvatarUri(rs.getString("avatar_uri"));
                    user.setIsValidate(rs.getInt("is_validate"));
                    return user;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserByEmail(String email) {
        try{
            String sql="select * from user where email=?";
            Object[] params={email};
            return jdbcOperations.queryForObject(sql, params, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user=new User();
                    user.setUserId(rs.getInt("userid"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setAvatarUri(rs.getString("avatar_uri"));
                    user.setIsValidate(rs.getInt("is_validate"));
                    return user;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> listAllUser() {
        try{
            String sql="select * from user";
           // Object[] params={user.getEmail(),user.getPassword()};
            return jdbcOperations.query(sql, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user=new User();
                    user.setUserId(rs.getInt("userid"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setAvatarUri(rs.getString("avatar_uri"));
                    user.setIsValidate(rs.getInt("is_validate"));
                    return user;
                }
            });
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteUser(int userId) {
        try{
            String sql="delete from user where userid=?";
            jdbcOperations.update(sql,userId);
        }
        catch (EmptyResultDataAccessException ex){
            ex.printStackTrace();
        }
    }

}
