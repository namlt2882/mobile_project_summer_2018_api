/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fptu.summer.dao;

import fptu.summer.model.Role;
import fptu.summer.model.User;
import fptu.summer.model.UserSetting;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ADMIN
 */
public class UserDAO extends DAO {

    public UserDAO() {
        super();
    }

    public User insert(User user) {
        try {
            begin();
            getSession().save(user);
            commit();
            return user;
        } catch (Exception e) {
            rollback();
            throw e;
        } finally {
            close();
        }
    }

    public User update(User user) {
        try {
            begin();
            getSession().update(user);
            commit();
            return user;
        } catch (Exception e) {
            rollback();
            throw e;
        } finally {
            close();
        }
    }

    public User checkLogin(User user) {
        try {
            DetachedCriteria dc = DetachedCriteria.forClass(User.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .add(Restrictions.eq("username", user.getUsername()))
                    .add(Restrictions.eq("password", user.getPassword()));
            List<User> l = dc.getExecutableCriteria(getSession()).list();
            if (l != null && l.size() != 0) {
                return l.get(0);
            } else {
                return null;
            }
        } finally {
            close();
        }
    }

    public User findByUsername(String username) {
        try {
            List<User> l = getSession()
                    .createCriteria(User.class)
                    //                    .createAlias("u.roles", "roles", JoinType.INNER_JOIN)
                    .add(Restrictions.eq("username", username)).list();
            if (l != null && !l.isEmpty()) {
                User user = l.get(0);
                user.getRoles().size();
                return user;
            } else {
                return null;
            }
        } finally {
            close();
        }
    }

    public User findById(Integer id) {
        try {
            return (User) getSession().get(User.class, id);
        } finally {
            close();
        }
    }

    public void addRoles(int userId, int roleId) {
        try {
            begin();
            User user = (User) getSession().get(User.class, userId);
            Role role = (Role) getSession().get(Role.class, roleId);
            user.getRoles().add(role);
            getSession().save(user);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        } finally {
            close();
        }
    }

    public UserSetting findSettingByUsername(String username) {
        try {
            List l = getSession()
                    .createCriteria(User.class)
                    .add(Restrictions.eq("username", username)).list();
            if (l != null && l.size() != 0) {
                User user = (User) l.get(0);
                return user.getUserSetting();
            } else {
                return null;
            }
        } finally {
            close();
        }
    }

    public void updateSetting(UserSetting us) {
        try {
            begin();
            getSession().update(us);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        } finally {
            close();
        }
    }
}
