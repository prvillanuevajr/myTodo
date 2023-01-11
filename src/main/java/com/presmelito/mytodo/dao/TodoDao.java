package com.presmelito.mytodo.dao;

import com.presmelito.mytodo.model.Todo;
import com.presmelito.mytodo.model.User;
import com.presmelito.mytodo.utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {
    public boolean persist(Todo todo) {
        try (
                Connection connection = JDBCUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO todos (title,description,targetDate,userId,completed) values (?,?,?,?,?)")
        ) {
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getDescription());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(todo.getTargetDate()));
            preparedStatement.setLong(4, todo.getUser().getId());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(todo.getCompletedAt()));

            return preparedStatement.executeQuery().next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Todo> findAll(User user) {
        if (user != null) {
            try (
                    Connection connection = JDBCUtil.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM todos inner join users on todos.userId = users.id where userId = ?")
            ) {
                List<Todo> todos = new ArrayList<>();
                preparedStatement.setLong(1, user.getId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    todos.add(new Todo(
                            resultSet.getLong("id"),
                            resultSet.getString("title"),
                            user,
                            resultSet.getString("description"),
                            resultSet.getTimestamp("targetDate").toLocalDateTime(),
                            resultSet.getTimestamp("completedAt").toLocalDateTime()
                    ));
                }
                return todos;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
