/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.prueba.repository;

import com.prueba.prueba.entity.Roles;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andre
 */
@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {
	Optional<Roles> findByRolename(String rolename);
}
