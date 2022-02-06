package com.Restraunt.Restraunt.Repositories;

import com.Restraunt.Restraunt.Models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,String> {

}
