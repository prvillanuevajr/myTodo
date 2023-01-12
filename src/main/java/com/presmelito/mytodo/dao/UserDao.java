package com.presmelito.mytodo.dao;

import com.presmelito.mytodo.model.User;
import com.presmelito.mytodo.utils.HibConfiguration;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;

public class UserDao {

    public int persist(User user) {
        try (Session session = HibConfiguration.getSessionFactory().openSession()) {
            user.setPassword(DigestUtils.sha256Hex(user.getPassword()));
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
            session.close();
            return 1;
        }
    }

    public boolean doesUserExist(String userName) {
        try (Session session = HibConfiguration.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> root = criteriaQuery.from(User.class);
            criteriaQuery = criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("userName"), userName));
            boolean exist = !session.createQuery(criteriaQuery).getResultList().isEmpty();
            session.close();
            return exist;
        }
    }
}
