package com.presmelito.mytodo.dao;

import com.presmelito.mytodo.model.Login;
import com.presmelito.mytodo.model.User;
import com.presmelito.mytodo.utils.HibConfiguration;
import com.presmelito.mytodo.utils.JDBCUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    public boolean validate(Login login) {
        try(Session session = HibConfiguration.getSessionFactory().openSession()){
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> root = criteriaQuery.from(User.class);
            criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("userName"),login.getUserName()))
                    .where(criteriaBuilder.equal(root.get("password"),DigestUtils.sha256Hex(login.getPassword())));
            User user = session.createQuery(criteriaQuery).getSingleResult();
            login.setUser(user);
            session.close();
            return user != null;
        }
    }
}
