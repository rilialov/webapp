package com.test.webapp.sessions;

public class UserAccount {
    private long id;
    private final String login;
    private byte[] salt;
    private byte[] hash;
    private long form_id;
    private String form;
    private final String role;

    public UserAccount(String login, String role) {
        this.login = login;
        this.role = role;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setForm_id(long form_id) {
        this.form_id = form_id;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public long getForm_id() {
        return form_id;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    public boolean isManager() {
        return role.equals("MANAGER");
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
