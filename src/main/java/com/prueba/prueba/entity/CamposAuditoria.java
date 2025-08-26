package com.prueba.prueba.entity;

import java.time.ZonedDateTime;

import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
    @jakarta.persistence.AttributeOverride(name = "aud_usu", column = @jakarta.persistence.Column(name = "aud_usu")),
    @jakarta.persistence.AttributeOverride(name = "aud_tim", column = @jakarta.persistence.Column(name = "aud_tim"))
    })
public class CamposAuditoria {
     
    private String aud_usu;
    private ZonedDateTime aud_tim;  

}





