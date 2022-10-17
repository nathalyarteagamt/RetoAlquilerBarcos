package com.Reto3.AlquilerBarcos.Controladores;

import java.util.Collections;
import java.util.Map;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
public class UsuarioControlador {
    
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        System.out.println("principal.getAttribute(\"name\")" + principal.getAttribute("name"));
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }
    
}
