package com.test.webapp.util;

import com.test.webapp.entity.User;

import javax.servlet.http.HttpSession;

public class UsersSessions {

    public static void setUser(HttpSession session, User User) {
        session.setAttribute("autUser", User);
    }

    public static User getUser(HttpSession session) {
        return (User) session.getAttribute("autUser");
    }
}

