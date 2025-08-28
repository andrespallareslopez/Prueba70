package com.prueba.prueba;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.prueba.entity.CamposAuditoria;
import com.prueba.prueba.entity.Roles;
import com.prueba.prueba.repository.RolesRepository;

@SpringBootTest
class RolesTests {
    
    @Autowired
    private RolesRepository rolesRepository;

    @Test
    void contextLoads() {

        CamposAuditoria camposAuditoria = CamposAuditoria.builder()
                            .aud_usu("andres")
                            .aud_tim(ZonedDateTime.now())
                            .build();  

        Roles roles = Roles.builder()
            .rolename("Admin")
            .camposAuditoria(camposAuditoria)
            .build();

          rolesRepository.save(roles);
          
          roles = Roles.builder()
              .rolename("User")
              .camposAuditoria(camposAuditoria)
              .build();

          rolesRepository.save(roles);
          
    }

    @Test
    public void getRoles(){
        
       List<Roles> roles = rolesRepository.findAll();
          
       System.out.println(roles.size());
       
       Optional<Roles> role = rolesRepository.findById(1);
       
       System.out.println(role.toString());
       
       
    }
}
