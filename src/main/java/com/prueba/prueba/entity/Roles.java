/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prueba.prueba.entity;

import java.util.List;

import jakarta.persistence.CascadeType;

//import java.time.ZonedDateTime;
//import java.util.HashSet;
//import java.util.Set;
//import java.util.stream.Collectors;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author andre
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "usuarios")
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
    
    
    @Embedded
    private CamposAuditoria camposAuditoria;
    
     @ManyToMany(
         cascade = CascadeType.ALL,
         fetch = FetchType.EAGER
    )
    @JoinTable(
        name="usersinroles",
        joinColumns = @JoinColumn(
            name="roleid",
            referencedColumnName ="roleid"
        ),
        inverseJoinColumns = @JoinColumn(
            name="userid",
            referencedColumnName ="userid"
        )
    )
    private List<Usuarios> usuarios;
    
    //private String aud_usu;
    //private ZonedDateTime aud_tim;  

    // Many-to-many via join entity UsersInRoles
    //@OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    //@Builder.Default
    //private Set<UsersInRoles> usersInRoles = new HashSet<>();

    // Helpers to manage the link entity and keep both sides in sync
    //
    public void addUser(Usuarios user, String auditor) {
        UsersInRoles link = new UsersInRoles();
        link.setId(new UsersInRolesId());
        link.setUser(user);
        link.setRole(this);
        //link.setAudUsu(auditor);
        //link.setAudTim(java.time.ZonedDateTime.now());

        //this.usersInRoles.add(link);
        //user.getUsersInRoles().add(link);
    }

    public void removeUser(Usuarios user) {
        //UsersInRoles toRemove = this.usersInRoles.stream()
        //    .filter(uir -> uir.getUser() != null && uir.getUser().equals(user))
        //    .findFirst()
        //    .orElse(null);
        //if (toRemove != null) {
        //    this.usersInRoles.remove(toRemove);
            //user.getUsersInRoles().remove(toRemove);
        //    toRemove.setUser(null);
        //    toRemove.setRole(null);
        //}
    }

    // Convenience view of users
    //public Set<Usuarios> getUsers() {
    //    return this.usersInRoles.stream()
    //        .map(UsersInRoles::getUser)
    //        .collect(Collectors.toCollection(HashSet::new));
    //}
}
