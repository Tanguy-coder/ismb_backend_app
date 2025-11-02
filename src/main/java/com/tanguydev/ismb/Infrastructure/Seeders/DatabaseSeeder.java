package com.tanguydev.ismb.Infrastructure.Seeders;

import com.tanguydev.ismb.Infrastructure.Models.ERole;
import com.tanguydev.ismb.Infrastructure.Models.Permission;
import com.tanguydev.ismb.Infrastructure.Models.Role;
import com.tanguydev.ismb.Infrastructure.Models.User;
import com.tanguydev.ismb.Infrastructure.Repositories.PermissionJpaRepository;
import com.tanguydev.ismb.Infrastructure.Repositories.RoleJpaRepository;
import com.tanguydev.ismb.Infrastructure.Repositories.UserRepositoryJpaInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;
import java.util.HashSet;

@Configuration
public class DatabaseSeeder {
    @Bean
    CommandLineRunner seed(UserRepositoryJpaInterface users,
                           RoleJpaRepository rolesRepo,
                           PermissionJpaRepository permsRepo,
                           PasswordEncoder encoder) {
        return args -> {
            // Permissions (idempotent)
            Permission pRead = permsRepo.findByName("USER_READ").orElseGet(() -> {
                Permission p = new Permission();
                p.setName("USER_READ");
                return permsRepo.save(p);
            });
            Permission pAdmin = permsRepo.findByName("ADMIN_MANAGE").orElseGet(() -> {
                Permission p = new Permission();
                p.setName("ADMIN_MANAGE");
                return permsRepo.save(p);
            });

            // Création de tous les rôles définis dans ERole
            for (ERole roleEnum : ERole.values()) {
                Role role = rolesRepo.findByName(roleEnum).orElseGet(() -> {
                    Role r = new Role();
                    r.setName(roleEnum);
                    // Attribution des permissions en fonction du rôle
                    Set<Permission> permissions = new HashSet<>();
                    
                    // Tous les rôles ont au moins la permission USER_READ
                    permissions.add(pRead);
                    
                    // Seul l'Admin a toutes les permissions
                    if (roleEnum == ERole.Admin) {
                        permissions.add(pAdmin);
                    }
                    
                    r.setPermissions(permissions);
                    return rolesRepo.save(r);
                });
                
                // Mise à jour des permissions si le rôle existe déjà
                if (roleEnum == ERole.Admin && !role.getPermissions().containsAll(Set.of(pRead, pAdmin))) {
                    role.setPermissions(Set.of(pRead, pAdmin));
                    rolesRepo.save(role);
                } else if (!role.getPermissions().contains(pRead)) {
                    role.getPermissions().add(pRead);
                    rolesRepo.save(role);
                }
            }

            // Création des utilisateurs par défaut
            if (users.findByUsername("admin").isEmpty()) {
                var admin = new User();
                admin.setNom("Tanguy");
                admin.setPrenom("Admin");
                admin.setContact("78Z78Z");
                admin.setUsername("admin");
                admin.setEmail("admin@example.com");
                admin.setPassword(encoder.encode("1234"));
                admin.setActive(true);
                admin.setRoles(Set.of(rolesRepo.findByName(ERole.Admin).get()));
                users.save(admin);
            }

            if (users.findByUsername("user").isEmpty()) {
                var user = new User();
                user.setNom("Tanguy");
                user.setPrenom("Admin");
                user.setContact("78Z78Z");
                user.setUsername("user");
                user.setEmail("user@example.com");
                user.setPassword(encoder.encode("1234"));
                user.setActive(true);
                user.setRoles(Set.of(rolesRepo.findByName(ERole.User).get()));
                users.save(user);
            }
        };
    }
}