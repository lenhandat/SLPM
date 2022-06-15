package com.fpt.capstone.backend.api.BackEnd.repository;


import com.fpt.capstone.backend.api.BackEnd.entity.Settings;
import com.fpt.capstone.backend.api.BackEnd.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByEmail(String email);

    boolean existsUserByEmail(String email);
    @Query("SELECT u FROM Users u WHERE u.email = :email")
    public Users getUserByEmail(@Param("email") String email);

  //  Page<Users> findByRoles(Settings settings, PageRequest of);

   // List<Users> findAllByRolesContains(Settings settings, Pageable pageable);

  //  List<Users> findAllByRolesContains(Settings settings);

   // List<Users> findByFullNameContainsAndRoles(String name, Settings settings, Pageable pageable);

  //  List<Users> findByFullNameContainsAndRoles(String name, Settings settings);

   // Page<Users> findByFullNameContains(String name, Pageable pageable);

   // @Query(value = "select u from Users u where lower(u.fullName) like %:name% and u.status = 'ACTIVE' ")
    //List<Users> findByFullNameContains(@Param(value = "name") String name);



//    @Query(value = "select u from Users u " +
//            "where u.star > 0 order by u.star desc")
//    List<Users> findRankingStar();

   // List<Users> findAllByIdIn(List<Long> ids);



   // List<Users> findAllByIdNotIn(List<Long> ids);
}