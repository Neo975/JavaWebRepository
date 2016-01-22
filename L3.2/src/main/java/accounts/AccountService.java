package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 09.01.2016.
 */
public class AccountService {
    private final DBService dbService;

    public AccountService(DBService dbService) {
        this.dbService = dbService;
    }

    public void addNewUser(UserProfile userProfile) {
        try {
            dbService.addUser(userProfile);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public UserProfile getUserByLogin(String login) {
        UsersDataSet dataSet = null;
        UserProfile userProfile = null;
        try {
            dataSet = dbService.getUser(login);
            userProfile = new UserProfile(dataSet.getName(), dataSet.getPassword(), dataSet.getName() + "@some_domain.org");
        } catch (DBException e) {
            e.printStackTrace();
        }
        return userProfile;
    }

    public UserProfile getUserBySessionId(String sessionId) {
//        return sessionIdToProfile.get(sessionId);
        return null;
    }

    public void addSession(String sessionId, UserProfile userProfile) {
//        sessionIdToProfile.put(sessionId, userProfile);
    }

    public void deleteSession(String sessionId) {
//        sessionIdToProfile.remove(sessionId);
    }

}
