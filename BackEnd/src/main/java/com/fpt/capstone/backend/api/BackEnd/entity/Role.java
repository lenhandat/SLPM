package com.fpt.capstone.backend.api.BackEnd.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
public class Role {
	@Id
	@Column(name = "id")

	private int id;

	@Column(name = "role_name")
	private String roleName;

	@OneToMany(mappedBy = "role")
	private Set<Users> users;

	public Role(int id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	public Role() {
	}
}