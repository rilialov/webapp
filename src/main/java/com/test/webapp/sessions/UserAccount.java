package com.test.webapp.sessions;

public class UserAccount {
    private final String login;
    private final String password;
    private int form_id;
    private final boolean isManager;

    public UserAccount(String login, String password, boolean isManager) {
        this.login = login;
        this.password = password;
        this.isManager = isManager;
    }

    public String getPassword() {
        return password;
    }

    public boolean isManager() {
        return isManager;
    }

    public int getForm_id() {
        return form_id;
    }

    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }
}
