package com.Restraunt.Restraunt.Services;

import com.Restraunt.Restraunt.Models.MenuItems;
import com.Restraunt.Restraunt.Repositories.MenuItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuItemsService {
    @Autowired
    MenuItemsRepository menuItemsRepo;

    List<MenuItems> bill=new ArrayList<>();
    List<Integer> quantityList=new ArrayList<>();
    List<Integer> pricesOfItemsList=new ArrayList<>();

    public List<MenuItems> getMenuItems(){
        return menuItemsRepo.findAll();
    }

    public MenuItems getMenuItemById(String dishId){
        return menuItemsRepo.findById(dishId).orElse(null);
    }

    public String addMenuItem(MenuItems m){
        menuItemsRepo.save(m);
        return "MenuItemName:"+m.getDishName()+"MenuItemId:"+m.getDishId()+"MenuItemDescription:"+m.getDishDescription()+"MenuItemPrice:"+m.getDishPrice()+"is added to Menu Items.";
    }

    public MenuItems updateMenuItem(MenuItems m){
        MenuItems existingMenuItem=menuItemsRepo.findById(m.getDishId()).orElse(null);
        menuItemsRepo.delete(existingMenuItem);
        menuItemsRepo.save(m);
        return m;

    }
    public String deleteMenuItem(String menuItemId){
        MenuItems m=menuItemsRepo.findById(menuItemId).orElse(null);
        menuItemsRepo.deleteById(menuItemId);
        return "MenuItemName:"+m.getDishName()+"MenuItemId:"+m.getDishId()+"MenuItemDescription:"+m.getDishDescription()+"MenuItemPrice:"+m.getDishPrice()+"is deleted from Menu Items.";

    }

    public String addToBill(String menuItemId,Integer quantity){
        MenuItems menuItem=menuItemsRepo.getById(menuItemId);
        bill.add(menuItem);
        quantityList.add(quantity);
        pricesOfItemsList.add(menuItem.getDishPrice()*quantity);
        return "MenuItem:"+menuItem.getDishName()+" Quantity:"+quantity+"added to the bill.";
    }

    public String generateBill(){
        Integer total=0;
        for(Integer i:pricesOfItemsList){
            total+=i;
        }
        String billString="";
        for(int i=0;i<bill.size();i++){
            billString+= bill.get(i).getDishName() +"  "+ quantityList.get(i) +"  "+ pricesOfItemsList.get(i)+"\n";
        }
        bill.removeAll(bill);
        quantityList.removeAll(quantityList);
        pricesOfItemsList.removeAll(pricesOfItemsList);
        return billString+"\nTotal: "+total;
    }

}
