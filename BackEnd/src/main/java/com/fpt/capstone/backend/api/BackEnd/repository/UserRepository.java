package com.fpt.capstone.backend.api.BackEnd.repository;


import com.fpt.capstone.backend.api.BackEnd.entity.Subjects;
import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);

    @Query("SELECT u FROM Users u WHERE u.username LIKE %?1%"
            + " OR u.fullName LIKE %?2% OR u.tel LIKE %?3%"
            + " OR u.email LIKE %?4%")
    public Page<Users> search(String username, String fullName, String tel, String email, Pageable pageable);
}