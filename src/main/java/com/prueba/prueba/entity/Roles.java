/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.prueba.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author andre
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="roles")
public class Roles {
    
    @Id
    @SequenceGenerator(
        name="roles_roleid_seq",
        sequenceName="roles_roleid_seq",
        allocationSize=1
    )
    @GeneratedValue(
        generator = "roles_roleid_seq",
        strategy = GenerationType.SEQUENCE
    )
    private int roleid;
    private String rolename;
}
