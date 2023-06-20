package model;

import java.util.Date;

public class Violation {
    Integer id;
    Double cccd;
    Date createdDate ;
    Date paymentDate ;
    LevelViolation levelViolation;

    public Violation() {
    }

    public Violation(Integer id, Double cccd, Date createdDate, Date paymentDate, LevelViolation levelViolation) {
        this.id = id;
        this.cccd = cccd;
        this.createdDate = createdDate;
        this.paymentDate = paymentDate;
        this.levelViolation = levelViolation;
    }

    public Violation(Integer id, Double cccd, Date createdDate, Date paymentDate, Integer levelId, Integer kindVehicle, Integer penalty, Integer status, Integer typeId, String reson, Integer statusType) {
        this.id = id;
        this.cccd = cccd;
        this.createdDate = createdDate;
        this.paymentDate = paymentDate;
        this.levelViolation = new LevelViolation(levelId, kindVehicle, penalty, status, typeId, reson, statusType);
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LevelViolation getLevelViolation() {
        return levelViolation;
    }

    public void setLevelViolation(LevelViolation levelViolation) {
        this.levelViolation = levelViolation;
    }
}
