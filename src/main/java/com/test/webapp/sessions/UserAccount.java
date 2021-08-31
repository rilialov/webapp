package com.test.webapp.sessions;

public class UserAccount {
    private int id;
    private final String login;
    private byte[] salt;
    private byte[] hash;
    private int form_id;
    private String form;
    private final boolean manager;

    public UserAccount(String login, boolean manager) {
        this.login = login;
        this.manager = manager;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getForm_id() {
        return form_id;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    public boolean isManager() {
        return manager;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }

    public byte[] getHash() {
        return hash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }
}
