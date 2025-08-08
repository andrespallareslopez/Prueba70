/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.prueba.repository;

import com.prueba.prueba.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author andre
 */

public interface RolesRepository extends JpaRepository<Roles,Integer> {
    
}
