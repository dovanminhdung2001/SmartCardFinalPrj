package model;

import model.TypeViolation;

public class LevelViolation {
    Integer id;
    Integer kindVehicle;
    Integer penalty;
    Integer status;
    TypeViolation typeViolation;

    public LevelViolation() {
    }

    public LevelViolation(Integer id, Integer kindVehicle, Integer penalty, Integer status, TypeViolation typeViolation) {
        this.id = id;
        this.kindVehicle = kindVehicle;
        this.penalty = penalty;
        this.status = status;
        this.typeViolation = typeViolation;
    }

    public LevelViolation(Integer id, Integer kindVehicle, Integer penalty, Integer status, Integer typeId, String reson, Integer statusType) {
        this.id = id;
        this.kindVehicle = kindVehicle;
        this.penalty = penalty;
        this.status = status;
        this.typeViolation = new TypeViolation(typeId, reson, statusType);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKindVehicle() {
        return kindVehicle;
    }

    public void setKindVehicle(Integer kindVehicle) {
        this.kindVehicle = kindVehicle;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public TypeViolation getTypeViolation() {
        return typeViolation;
    }

    public void setTypeViolation(TypeViolation typeViolation) {
        this.typeViolation = typeViolation;
    }
}
