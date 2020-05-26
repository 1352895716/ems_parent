package com.ems.pojo;

import java.io.Serializable;
import java.util.Date;

public class StaffRap implements Serializable{
    private Integer id;

    private Integer staffId;

    private Integer rapId;

    private Date careateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getRapId() {
        return rapId;
    }

    public void setRapId(Integer rapId) {
        this.rapId = rapId;
    }

    public Date getCareateTime() {
        return careateTime;
    }

    public void setCareateTime(Date careateTime) {
        this.careateTime = careateTime;
    }
}