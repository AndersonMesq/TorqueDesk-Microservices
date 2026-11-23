-- ============================================
-- TENANTS
-- ============================================
create table tenants (
                         id uuid not null,
                         name varchar(255) not null,
                         slug varchar(255) not null,
                         status varchar(20) not null,

                         created_at timestamp(6) not null,
                         updated_at timestamp(6) not null,

                         constraint pk_tenants primary key (id),
                         constraint uk_tenants_slug unique (slug),
                         constraint ck_tenants_status
                             check (status in ('ACTIVE', 'INACTIVE'))
);

-- ============================================
-- USERS
-- ============================================
create table users (
                       id uuid not null,
                       full_name varchar(150) not null,
                       user_name varchar(255),
                       email varchar(255),
                       password varchar(255) not null,
                       system_role varchar(20) not null,
                       enabled boolean not null,

                       created_at timestamp(6) not null,
                       updated_at timestamp(6) not null,

                       constraint pk_users primary key (id),
                       constraint uk_users_username unique (user_name),
                       constraint uk_users_email unique (email),
                       constraint ck_users_system_role
                           check (system_role in ('USER', 'SUPER_ADMIN'))
);

-- ============================================
-- USER TENANTS
-- ============================================
create table user_tenants (
                              id uuid not null,
                              user_id uuid not null,
                              tenant_id uuid not null,
                              role varchar(20) not null,
                              enabled boolean not null,

                              created_at timestamp(6) not null,
                              updated_at timestamp(6) not null,

                              constraint pk_user_tenants primary key (id),

                              constraint uk_user_tenants_user_tenant
                                  unique (user_id, tenant_id),

                              constraint fk_user_tenants_user
                                  foreign key (user_id)
                                      references users (id),

                              constraint fk_user_tenants_tenant
                                  foreign key (tenant_id)
                                      references tenants (id),

                              constraint ck_user_tenants_role
                                  check (role in ('OWNER', 'ATTENDANT', 'MECHANIC'))
);

-- ============================================
-- INDEXES
-- ============================================
create index idx_user_tenants_tenant_id
    on user_tenants (tenant_id);