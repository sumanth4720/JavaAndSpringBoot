package com.Restraunt.Restraunt.Controllers;

import com.Restraunt.Restraunt.Models.MenuItems;
import com.Restraunt.Restraunt.Models.Staff;
import com.Restraunt.Restraunt.Services.MenuItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class MenuItemsController {
    @Autowired
    MenuItemsService menuItemsService;


    @RequestMapping(path="/getMenuItemsData",method= RequestMethod.GET)
    public List<MenuItems> getMenuItemsData(){
        return menuItemsService.getMenuItems();
    }

    @RequestMapping(path="/getMenuItemDataById/{menuItemId}",method= RequestMethod.GET)
    public MenuItems getMenuItemById(@PathVariable(name="menuItemId") String menuItemId){
        return menuItemsService.getMenuItemById(menuItemId);
    }

    @RequestMapping(path="/addMenuItem",method= RequestMethod.POST)
    public String addMenuItem(@RequestBody MenuItems menuItem){
        return menuItemsService.addMenuItem(menuItem);
    }

    @RequestMapping(path="/updateMenuItemData",method= RequestMethod.PUT)
    public MenuItems updateMenuItem(@RequestBody MenuItems menuItem){

        return menuItemsService.updateMenuItem(menuItem);
    }

    @RequestMapping(path="/deleteMenuItem",method= RequestMethod.DELETE)
    public String deleteMenuItem(@PathVariable("menuItemId") String menuItemId){
        return menuItemsService.deleteMenuItem(menuItemId);
    }

    @RequestMapping(path="/addMenuItemToBill/{menuItemId}/{quantity}",method = RequestMethod.GET)
    public String addMenuItemToBill(@PathVariable(name="menuItemId") String menuItemId,@PathVariable(name="quantity") Integer quantity){
        return menuItemsService.addToBill(menuItemId,quantity);
    }
    @RequestMapping(path="/generateBill",method = RequestMethod.GET)
    public String generateBill(){
        return menuItemsService.generateBill();
    }

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping(path="/updateMenuItemDataByManager/{staffId}",method = RequestMethod.PUT)
    public String updateMenuItemByManager(@PathVariable(name="staffId") String staffId,@RequestBody MenuItems m){
        String url="http://localhost:8080/getStaffDataById/"+staffId;
       Staff staff=restTemplate.getForObject(url,Staff.class);
       if(staff.getStaffDesignation().equals("Manager")){
           menuItemsService.updateMenuItem(m);
           return "Menu Item has been updated.";
       }
       else{
           return "your designation should be manager to update menu items.";
       }
    }
}
