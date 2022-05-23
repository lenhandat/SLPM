package com.fpt.capstone.backend.api.BackEnd.repository;


import com.fpt.capstone.backend.api.BackEnd.entity.Role;
import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

    Users findByUsername(String username);

    @Modifying
    @Transactional
    @Query("update Users u set u.fullName = ?1, u.birthday = ?2, u.tel = ?3, u.email=?4,u.avatarLink=?5" +
            ",u.statusId=?6,u.modified=?7,u.modifiedBy = ?8 where u.id = ?9")
    void updateUser(String fullName, java.sql.Timestamp birthDay , String tell, String email, String avatarLink,
                    int status,java.sql.Timestamp modifileDay,int ModifileById, int id );

}