package com.Restraunt.Restraunt.Mockito;

import com.Restraunt.Restraunt.Models.MenuItems;
import com.Restraunt.Restraunt.Models.Staff;
import com.Restraunt.Restraunt.Repositories.MenuItemsRepository;
import com.Restraunt.Restraunt.Repositories.StaffRepository;
import com.Restraunt.Restraunt.Services.MenuItemsService;
import com.Restraunt.Restraunt.Services.StaffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockitoApplicationTests {

    @Autowired
    StaffService staffService;
    @MockBean
    StaffRepository repository;

    @Autowired
    MenuItemsService menuItemsService;
    @MockBean
    MenuItemsRepository menuItemsRepository;

    @Test
    public void getUserByIdTest(){
        Staff s=new Staff("james","s1","waiter");
        when(repository.findById("s1")).thenReturn(java.util.Optional.of(s));
                assertEquals(s,staffService.getStaffDataById("s1"));
    }

    @Test
    public void getMenuItemByIdTest(){
        MenuItems m=new MenuItems("NV1","chicken tikka",200,"Red colour chicken");
        when(menuItemsRepository.findById("NV1")).thenReturn(java.util.Optional.of(m));
        assertEquals(m,menuItemsService.getMenuItemById("NV1"));

    }
    @Test
    public void UpdateMenuItemsTest(){
        MenuItems m=new MenuItems("NV1","chicken tikka",200,"Red colour chicken");
        when(menuItemsRepository.save(m)).thenReturn(m);
        assertEquals(m,menuItemsService.updateMenuItem(m));
    }
    @Test
    public void updateStaffDataTest(){
        Staff s=new Staff("james","s1","waiter");
        when(repository.save(s)).thenReturn(s);
        assertEquals(s,staffService.updateStaffData(s));
    }





}
