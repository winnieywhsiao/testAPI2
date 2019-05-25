package com.example.myapplication;


public class USER {
    private int user_id;
    private String user_email;
    private String user_password;
    private String user_phone;
    private String user_diary;
    private String user_comment;
    private String user_collect;
    private String Friends;

    public USER(String email, String user_password) {
        user_email = email;
        this.user_password = user_password;
    }

    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return user_email;
    }

    public void setEmail(String email) {
        this.user_email = email;
    }

    public String getPassword() {
        return user_password;
    }

    public void setPassword(String password) {
        this.user_password = password;
    }

    public String getPhone() {
        return user_phone;
    }

    public void setPhone(String phone) {
        this.user_phone = phone;
    }

    public String getDiary() {
        return user_diary;
    }

    public void setDiary(String diary) {
        this.user_diary = diary;
    }

    public String getComment() {
        return user_comment;
    }

    public void setComment(String comment) {
        this.user_comment = comment;
    }

    public String getCollect() {
        return user_collect;
    }

    public void setCollect(String collect) {
        this.user_collect = collect;
    }

    public String getFriend() {
        return Friends;
    }

    public void setFriend(String Friends) {
        this.Friends = Friends;
    }

}
