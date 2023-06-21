package model;

import java.util.Date;

public class Licence {
    String type;
    Date disabledTo;

    public Licence(String type, Date disabledTo) {
        this.type = type;
        this.disabledTo = disabledTo;
    }

    public Licence() {
    }

    public Licence(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDisabledTo() {
        return disabledTo;
    }

    public void setDisabledTo(Date disabledTo) {
        this.disabledTo = disabledTo;
    }
}
