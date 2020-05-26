package com.ems.pojo;

import java.io.Serializable;
import java.util.Date;

public class Salary implements Serializable{
    private Integer id;

    private Integer staffId;

    private Float basic;

    private Float eat;

    private Float house;

    private Float duty;

    private Float scot;

    private Float additionalBenefits;

    private Date createTime;

    private Float total;

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

    public Float getBasic() {
        return basic;
    }

    public void setBasic(Float basic) {
        this.basic = basic;
    }

    public Float getEat() {
        return eat;
    }

    public void setEat(Float eat) {
        this.eat = eat;
    }

    public Float getHouse() {
        return house;
    }

    public void setHouse(Float house) {
        this.house = house;
    }

    public Float getDuty() {
        return duty;
    }

    public void setDuty(Float duty) {
        this.duty = duty;
    }

    public Float getScot() {
        return scot;
    }

    public void setScot(Float scot) {
        this.scot = scot;
    }

    public Float getAdditionalBenefits() {
        return additionalBenefits;
    }

    public void setAdditionalBenefits(Float additionalBenefits) {
        this.additionalBenefits = additionalBenefits;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}