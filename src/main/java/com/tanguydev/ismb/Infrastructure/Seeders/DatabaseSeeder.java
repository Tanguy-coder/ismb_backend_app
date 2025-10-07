package com.tanguydev.ismb.Infrastructure.Seeders;

import com.tanguydev.ismb.Infrastructure.Models.ERole;
import com.tanguydev.ismb.Infrastructure.Models.Permission;
import com.tanguydev.ismb.Infrastructure.Models.Role;
import com.tanguydev.ismb.Infrastructure.Models.User;
import com.tanguydev.ismb.Infrastructure.Repositories.PermissionRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Repositories.RoleRepositoryInterface;
import com.tanguydev.ismb.Infrastructure.Repositories.UserRepositoryJpaInterface;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.Set;

@Configuration
public class DatabaseSeeder {
    @Bean
    CommandLineRunner seed(UserRepositoryJpaInterface users,
                           RoleRepositoryInterface rolesRepo,
                           PermissionRepositoryInterface permsRepo,
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

            // Roles (idempotent)
            Role adminRole = rolesRepo.findByName(ERole.Admin).orElseGet(() -> {
                Role r = new Role();
                r.setName(ERole.Admin);
                r.setPermissions(Set.of(pRead, pAdmin));
                return rolesRepo.save(r);
            });
            // Ensure permissions are updated if role already existed but without full set
            if (!adminRole.getPermissions().containsAll(Set.of(pRead, pAdmin))) {
                adminRole.setPermissions(Set.of(pRead, pAdmin));
                rolesRepo.save(adminRole);
            }

            Role userRole = rolesRepo.findByName(ERole.User).orElseGet(() -> {
                Role r = new Role();
                r.setName(ERole.User);
                r.setPermissions(Set.of(pRead));
                return rolesRepo.save(r);
            });
            if (!userRole.getPermissions().contains(pRead)) {
                userRole.getPermissions().add(pRead);
                rolesRepo.save(userRole);
            }

            // Users (idempotent)
            if (users.findByUsername("admin").isEmpty()) {
                var admin = new User();
                admin.setNom("Tanguy");
                admin.setPrenom("Admin");
                admin.setContact("78Z78Z");
                admin.setUsername("admin");
                admin.setEmail("admin@example.com");
                admin.setPassword(encoder.encode("1234"));
                admin.setActive(true);
                admin.setRoles(Set.of(adminRole));
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
                user.setRoles(Set.of(userRole));
                users.save(user);
            }
        };
    }
}
