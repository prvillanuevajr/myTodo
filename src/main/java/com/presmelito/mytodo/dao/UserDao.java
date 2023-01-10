package com.presmelito.mytodo.dao;

import com.presmelito.mytodo.model.User;
import com.presmelito.mytodo.utils.JDBCUtil;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    public int registerUser(User user) {
        try (
                Connection connection = JDBCUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO users (firstName,lastName,username,password) values (?,?,?,?)");
        ) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getUserName());
            statement.setString(4, DigestUtils.sha256Hex(user.getPassword()));
            return statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
