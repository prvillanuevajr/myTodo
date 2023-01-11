package com.presmelito.mytodo.dao;

import com.presmelito.mytodo.model.Login;
import com.presmelito.mytodo.model.User;
import com.presmelito.mytodo.utils.JDBCUtil;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    public boolean validate(Login login) {
        try (
                Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from users where userName = ? and password = ?");
        ) {
            preparedStatement.setString(1, login.getUserName());
            preparedStatement.setString(2, DigestUtils.sha256Hex(login.getPassword()));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("userName"),
                        resultSet.getString("password")
                );
                login.setUser(user);
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
