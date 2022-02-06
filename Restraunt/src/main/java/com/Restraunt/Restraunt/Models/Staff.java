package com.Restraunt.Restraunt.Models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Staff {

    @Id
    String staffId;
    String staffName;
    String staffDesignation;

    public Staff(){

    }

    public Staff(String staffName, String staffId, String staffDesignation) {
        this.staffName = staffName;
        this.staffId = staffId;
        this.staffDesignation = staffDesignation;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffDesignation() {
        return staffDesignation;
    }

    public void setStaffDesignation(String staffDesignation) {
        this.staffDesignation = staffDesignation;
    }
}
