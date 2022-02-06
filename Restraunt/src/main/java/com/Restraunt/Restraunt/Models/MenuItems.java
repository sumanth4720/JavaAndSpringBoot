package com.Restraunt.Restraunt.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;

@Table
@Entity
public class MenuItems {

    @Id
    String dishId;
    String dishName;
    Integer dishPrice;
    String dishDescription;

    public MenuItems(){

    }


    public MenuItems(String dishId, String dishName, Integer dishPrice, String dishDescription) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishDescription = dishDescription;
    }

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Integer getDishPrice() {
        return dishPrice;
    }

    public void setDishPrice(Integer dishPrice) {
        this.dishPrice = dishPrice;
    }

    public String getDishDescription() {
        return dishDescription;
    }

    public void setDishDescription(String dishDescription) {
        this.dishDescription = dishDescription;
    }
}
