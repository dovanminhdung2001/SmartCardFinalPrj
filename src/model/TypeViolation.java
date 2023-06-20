package model;

public class TypeViolation {
    Integer id;
    String reson;
    Integer status;

    public TypeViolation(Integer id, String reson, Integer status) {
        this.id = id;
        this.reson = reson;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReson() {
        return reson;
    }

    public void setReson(String reson) {
        this.reson = reson;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
