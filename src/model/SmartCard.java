package model;

import java.util.Date;

public class SmartCard {
    Integer id;
    Double cccd;
    String avatarUrl;
    String publicKey;
    String name;
    Date dob;
    Integer balance;
    Date createdDate;
    Date updatedDate;
    Integer status;

    public SmartCard() {
    }

    public SmartCard(Integer id, Double cccd, String avatarUrl, String publicKey, String name, Date dob, Integer balance, Date createdDate, Date updatedDate, Integer status) {
        this.id = id;
        this.cccd = cccd;
        this.avatarUrl = avatarUrl;
        this.publicKey = publicKey;
        this.name = name;
        this.dob = dob;
        this.balance = balance;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCccd() {
        return cccd;
    }

    public void setCccd(Double cccd) {
        this.cccd = cccd;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
