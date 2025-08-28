package com.prueba.prueba;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import com.prueba.prueba.entity.CamposAuditoria;
import com.prueba.prueba.entity.Usuarios;
import com.prueba.prueba.repository.UsuariosRepository;

@SpringBootTest
class UsuariosTests {
    
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Test
    void contextLoads() {

           CamposAuditoria camposAuditoria = CamposAuditoria.builder()
                            .aud_usu("andres")
                            .aud_tim(ZonedDateTime.now())
                            .build();  

        Usuarios usuario = Usuarios.builder()
            .username("testuser")
            .state(false)
            .camposAuditoria(camposAuditoria)
            .build();

        usuariosRepository.save(usuario);
    }
    @Test
    void getUsuarios(){
        System.out.println("**************************");
        System.out.println("prueba de usuarios");
        System.out.println("**************************");

        List<Usuarios> usuarios = usuariosRepository.findAll();
        
        System.out.println(usuarios.size());
        //System.out.println();
        Optional<Usuarios> usuario=usuariosRepository.findById(1);
        
        System.out.println(usuario);
        System.out.println(usuario.get().getRoles());


    }
}
