package com.prueba.prueba.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class UsersInRolesId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "userid")
    private Integer userId;

    @Column(name = "roleid")
    private Integer roleId;

    @Column(name = "aud_usu")
    private String aud_usu;

    @Column(name = "aud_tim")       
    private ZonedDateTime aud_tim;  
}
