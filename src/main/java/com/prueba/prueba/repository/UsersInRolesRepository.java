package com.prueba.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.prueba.entity.UsersInRoles;
import com.prueba.prueba.entity.UsersInRolesId;
import com.prueba.prueba.entity.Usuarios;
import com.prueba.prueba.entity.Roles;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsersInRolesRepository extends JpaRepository<UsersInRoles, UsersInRolesId> {
	List<UsersInRoles> findByUserUserid(Integer userId);
	List<UsersInRoles> findByRoleRoleid(Integer roleId);
	List<UsersInRoles> findByUser(Usuarios user);
	List<UsersInRoles> findByRole(Roles role);
	Optional<UsersInRoles> findByUserUseridAndRoleRoleid(Integer userId, Integer roleId);
}
