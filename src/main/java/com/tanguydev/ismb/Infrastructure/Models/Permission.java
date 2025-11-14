package com.tanguydev.ismb.Infrastructure.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permissions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Permission extends  AbstractModel{
    @Column(unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();
}
