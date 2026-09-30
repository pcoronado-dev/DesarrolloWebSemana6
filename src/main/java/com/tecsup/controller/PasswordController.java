package com.tecsup.controller;

import com.tecsup.model.User;
import com.tecsup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PasswordController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Endpoint para cambiar la contraseña del usuario autenticado
     * POST /api/change-password
     * Body: { "currentPassword": "actual", "newPassword": "nueva" }
     */
    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(
            Authentication authentication,
            @RequestBody Map<String, String> request) {

        String username = authentication.getName();
        String currentPassword = request.get("currentPassword");
        String newPassword = request.get("newPassword");

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Verificar contraseña actual
        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            return ResponseEntity.badRequest().body("Contraseña actual incorrecta");
        }

        // Cambiar contraseña
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);

        return ResponseEntity.ok("Contraseña actualizada correctamente");
    }

    /**
     * Endpoint para que un admin cambie la contraseña de cualquier usuario
     * POST /api/admin/change-password/{username}
     * Body: { "newPassword": "nueva" }
     */
    @PostMapping("/admin/change-password/{username}")
    public ResponseEntity<?> adminChangePassword(
            @PathVariable String username,
            @RequestBody Map<String, String> request) {

        String newPassword = request.get("newPassword");

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);

        return ResponseEntity.ok("Contraseña de " + username + " actualizada correctamente");
    }
}
