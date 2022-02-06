package com.Restraunt.Restraunt.Repositories;

import com.Restraunt.Restraunt.Models.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemsRepository extends JpaRepository<MenuItems,String> {

}
