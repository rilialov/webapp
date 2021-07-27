package com.test.webapp.sessions;

import com.test.webapp.data.DBController;
import com.test.webapp.data.FormBuilder;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class UsersSessions {
    private static final Map<UserAccount, FormBuilder> formBuilderMap= new HashMap<>();
    private static final Map<UserAccount, DBController> dbControllerMap= new HashMap<>();

    public static FormBuilder getFormBuilder(UserAccount userAccount) {
        return formBuilderMap.get(userAccount);
    }

    public static DBController getDbController(UserAccount userAccount) {
        return dbControllerMap.get(userAccount);
    }

    public static void setFormBuilder(UserAccount userAccount, FormBuilder fb) {
        formBuilderMap.put(userAccount, fb);
    }

    public static void setDbControllerMap(UserAccount userAccount, DBController db) {
        dbControllerMap.put(userAccount, db);
    }

    public static void setUser(HttpSession session, UserAccount User) {
        session.setAttribute("autUser", User);
    }

    public static UserAccount getUser(HttpSession session) {
        return (UserAccount) session.getAttribute("autUser");
    }
}

