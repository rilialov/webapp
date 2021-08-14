package com.test.webapp.sessions;

public class UserAccount {
    private int id;
    private final String login;
    private char[] password;
    private int form_id;
    private final boolean manager;

    public UserAccount(String login, boolean manager) {
        this.login = login;
        this.manager = manager;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public void setForm_id(int form_id) {
        this.form_id = form_id;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public char[] getPassword() {
        return password;
    }

    public int getForm_id() {
        return form_id;
    }

    public boolean isManager() {
        return manager;
    }
}
