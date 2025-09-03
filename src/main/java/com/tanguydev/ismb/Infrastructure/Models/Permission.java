package com.tanguydev.ismb.Infrastructure.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "permissions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Permission extends  AbstractModel{
    @Column(unique = true)
    private String name;
}
