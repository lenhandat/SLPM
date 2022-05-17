package com.fpt.capstone.backend.api.BackEnd.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "role",
        uniqueConstraints = @UniqueConstraint(columnNames = "role"))
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "role")
    private String role;
    
    @ManyToMany(fetch = FetchType.LAZY, 
            cascade = CascadeType.ALL,
            mappedBy= "roles",
            targetEntity = DAOUser.class)
    private Set<DAOUser> users = new HashSet<DAOUser>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<DAOUser> getUsers() {
		return users;
	}

	public void setUsers(Set<DAOUser> users) {
		this.users = users;
	} 
}