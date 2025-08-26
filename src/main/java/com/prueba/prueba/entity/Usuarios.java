package com.prueba.prueba.entity;

//import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor 
@NoArgsConstructor
@Builder
@Table(name = "usuarios")   
public class Usuarios {
      
    @Id
      @SequenceGenerator(
        name="usuarios_userid_seq",
        sequenceName="usuarios_userid_seq",
        allocationSize=1
    )
    @GeneratedValue(
        generator = "usuarios_userid_seq",
        strategy = GenerationType.SEQUENCE
    )
    private Integer userid;
    private String username;
    private boolean state;

    
    @Embedded
    private CamposAuditoria camposAuditoria;

    //private String aud_usu;
    //private ZonedDateTime aud_tim;  
    
    // Many-to-many via join entity UsersInRoles
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<UsersInRoles> usersInRoles = new HashSet<>();
    
    // Helpers to manage the link entity and keep both sides in sync
    public void addRole(Roles role, String auditor) {
        // Create link; with @MapsId it's fine to leave id empty; JPA will populate from associations
        UsersInRoles link = new UsersInRoles();
        link.setId(new UsersInRolesId());
        link.setUser(this);
        link.setRole(role);
        //link.setAudUsu(auditor);
        //link.setAudTim(ZonedDateTime.now());

        this.usersInRoles.add(link);
        role.getUsersInRoles().add(link);
    }

    public void removeRole(Roles role) {
        // Remove the link from both sides
        UsersInRoles toRemove = this.usersInRoles.stream()
            .filter(uir -> uir.getRole() != null && uir.getRole().equals(role))
            .findFirst()
            .orElse(null);
        if (toRemove != null) {
            this.usersInRoles.remove(toRemove);
            role.getUsersInRoles().remove(toRemove);
            // Break references for GC safety
            toRemove.setUser(null);
            toRemove.setRole(null);
        }
    }

    // Convenience view of roles
    public Set<Roles> getRoles() {
        return this.usersInRoles.stream()
            .map(UsersInRoles::getRole)
            .collect(Collectors.toCollection(HashSet::new));
    }
}
