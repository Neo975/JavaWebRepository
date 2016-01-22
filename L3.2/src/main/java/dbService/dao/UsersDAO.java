package dbService.dao;

import accounts.UserProfile;
import dbService.dataSets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * Created by user on 21.01.2016.
 */
public class UsersDAO {
    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }
/*
    public UsersDataSet get(long id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }
*/
    public UsersDataSet get(String name) {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        return ((UsersDataSet) criteria.add(Restrictions.eq("name", name)).uniqueResult());
    }

/*
    public long getUserId(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        return ((UsersDataSet) criteria.add(Restrictions.eq("name", name)).uniqueResult()).getId();
    }
*/

    public long insertUser(UserProfile userProfile) throws HibernateException {
        return (Long) session.save(new UsersDataSet(userProfile));
    }
}
