package com.prueba.prueba;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

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
}
