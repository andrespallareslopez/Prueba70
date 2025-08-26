package com.prueba.prueba;




import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.prueba.entity.Roles;  
import com.prueba.prueba.entity.Usuarios;
import com.prueba.prueba.entity.UsersInRoles;
import com.prueba.prueba.entity.UsersInRolesId;
import com.prueba.prueba.repository.RolesRepository;
import com.prueba.prueba.repository.UsersInRolesRepository;
import com.prueba.prueba.repository.UsuariosRepository;

@SpringBootTest
class UsersInRolesRepositoryTests {

    @Autowired
    private UsersInRolesRepository usersInRolesRepository;

    @Autowired
    private UsuariosRepository usuariosRepository; 

    @Autowired
    private RolesRepository rolesRepository;

    @Test
    void contextLoads() {


      
      UsersInRolesId userInRoleId = new UsersInRolesId(1,1,"andres", ZonedDateTime.now());
        
        Roles rol = rolesRepository.findById(1).get();
        Roles rol2 = rolesRepository.findByRolename("Admin").get();
        
        Usuarios usuario = usuariosRepository.findById(1).get();
        
        UsersInRoles userInRole = UsersInRoles.builder()
        .id(userInRoleId)
           .role(rol)
           .user(usuario)
           //.audTim(ZonedDateTime.now())
           //.audUsu("andres")
           .build();
        System.out.println("********dump userInRole********************");
        System.out.println(userInRole.toString());
        //System.out.println(userInRole.getAudUsu().toString());
        System.out.println(rol2.getRolename().toString());
        System.out.println(rol.getRoleid() );
        System.out.println(rol.getRolename().toString());
        System.out.println(usuario.getUsername().toString());
        
        usersInRolesRepository.save(userInRole);   


        //System.out.println(userInRole.getRole().toString());
        //System.out.println(userInRole.getUser().toString());

       //usersInRolesRepository.save(userInRole);

    }
}
