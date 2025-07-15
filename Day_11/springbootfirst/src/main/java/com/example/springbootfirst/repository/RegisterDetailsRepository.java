package com.example.springbootfirst.repository;

import com.example.springbootfirst.models.RegisterDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;


public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails,Integer> {

    RegisterDetails findByEmail(String email);


    RegisterDetails findByUserName(String userName);
    @Query("SELECT r.roleName FROM RegisterDetails u JOIN u.roles r WHERE u.userName = :userName")
    Set<String> getRoleNamesByUserName(String userName);
    @Modifying
    @Transactional
    @Query(value="DELETE FROM user_roles WHERE user_id1 = :id", nativeQuery=true)
    void deleteByRoleById(int id);
}
