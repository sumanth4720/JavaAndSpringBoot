package com.Restraunt.Restraunt.Controllers;

import com.Restraunt.Restraunt.Models.Staff;
import com.Restraunt.Restraunt.Services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaffController {
    @Autowired
    StaffService staffService;
    @RequestMapping(path="/getStaffData",method= RequestMethod.GET)
    public List<Staff> getStaffData(){
        return staffService.getStaffData();
    }
    @RequestMapping(path="/getStaffDataById/{staffId}",method=RequestMethod.GET)
    public Staff getStaffDataById(@PathVariable(name="staffId") String staffId){
        return staffService.getStaffDataById(staffId);
    }
    @RequestMapping(path="/addStaffData",method=RequestMethod.POST)
    public String addStaffData(@RequestBody Staff s){
        return staffService.addStaffData(s);
    }
    @RequestMapping(path="/updateStaffData",method=RequestMethod.PUT)
    public Staff updateStaffData(@RequestBody Staff s){

        return staffService.updateStaffData(s);
    }

    @RequestMapping(path="/deleteStaffDataById/{staffId}",method=RequestMethod.DELETE)
    public String deleteStaffData(@PathVariable(name="staffId") String staffId){
        return staffService.deleteStaffData(staffId);

    }
}
