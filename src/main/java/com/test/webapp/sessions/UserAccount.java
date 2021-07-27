package com.test.webapp.sessions;

public class UserAccount {
    private String login;
    private String password;
    private int form_id;
    private boolean isManager;


    public UserAccount(String login, String password, boolean isManager) {
        this.login = login;
        this.password = password;
        this.isManager = isManager;
    }

    public String getLogin() {
        return login;
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
