package com.Restraunt.Restraunt.Services;

import com.Restraunt.Restraunt.Models.Staff;
import com.Restraunt.Restraunt.Repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    StaffRepository staffRepo;
    public List<Staff> getStaffData(){
        return staffRepo.findAll();
    }
    public Staff getStaffDataById(String staffId){

        return staffRepo.findById(staffId).orElse(null);
    }

    public String addStaffData(Staff s){
        staffRepo.save(s);
        return "staff data with \nstaffName:"+s.getStaffName()+"\nstaffId:"+s.getStaffId()+"\nstaffDesignation:"+s.getStaffDesignation()+" is added to staff data";
    }

    public Staff updateStaffData(Staff s){
        Staff existingStaff=staffRepo.findById(s.getStaffId()).orElse(null);
        staffRepo.delete(existingStaff);
        staffRepo.save(s);
        return s;

    }

    public String deleteStaffData(String staffId){
        Staff s=staffRepo.findById(staffId).orElse(null);
        staffRepo.deleteById(staffId);
        return "staff data with \nstaffName:"+s.getStaffName()+"\nstaffId:"+s.getStaffId()+"\nstaffDesignation:"+s.getStaffDesignation()+" is deleted from staff data";

    }
}
