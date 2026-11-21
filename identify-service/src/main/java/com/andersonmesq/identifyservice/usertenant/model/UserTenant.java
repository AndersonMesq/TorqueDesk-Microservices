package com.andersonmesq.identifyservice.usertenant.model;

import com.andersonmesq.identifyservice.shared.entity.BaseEntity;
import com.andersonmesq.identifyservice.tenant.model.Tenant;
import com.andersonmesq.identifyservice.user.model.User;
import com.andersonmesq.identifyservice.usertenant.role.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "user_tenants", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "tenant_id"})})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTenant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tenant_id", nullable = false)
    private Tenant tenant;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private Boolean enabled = true;
}