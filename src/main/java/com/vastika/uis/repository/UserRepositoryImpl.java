package com.vastika.uis.repository;

import com.vastika.uis.model.User;
import com.vastika.uis.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUser(User user) {
        Session session = HibernateUtil.getSession(sessionFactory);
        session.save(user);
    }

    @Override
    public void updateUser(User user) {
        Session session = HibernateUtil.getSession(sessionFactory);
        session.update(user);

    }

    @Override
    public List<User> getAllUser() {
        Session session = HibernateUtil.getSession(sessionFactory);
        Criteria criteria = session.createCriteria(User.class);
        return criteria.list();
    }

    @Override
    public User getUserById(int id) {
        Session session = HibernateUtil.getSession(sessionFactory);
        return (User) session.get(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        User user = getUserById(id);
        if (user != null) {
            Session session = HibernateUtil.getSession(sessionFactory);
            session.delete(user);
        }
    }

	@Override
	public User getUserByUsername(String username) {
		        Session session = HibernateUtil.getSession(sessionFactory);
		        Criteria criteria = session.createCriteria(User.class);
		        criteria.add(Restrictions.eq("userName", username));
		        return (User)criteria.uniqueResult();
	}

}

