package com.test.webapp.sessions;

import com.test.webapp.data.DBController;
import com.test.webapp.data.FormBuilder;

import java.util.HashMap;
import java.util.Map;

public class UsersSessions {
    private static Map<String, FormBuilder> formBuilderMap= new HashMap<>();
    private static Map<String, DBController> dbControllerMap= new HashMap<>();

    public static FormBuilder getFormBuilder(String login) {
        return formBuilderMap.get(login);
    }

    public static DBController getDbController(String login) {
        return dbControllerMap.get(login);
    }

    public static void setFormBuilder(String login, FormBuilder fb) {
        formBuilderMap.put(login, fb);
    }

    public static void setDbControllerMap(String login, DBController db) {
        dbControllerMap.put(login, db);
    }
}
