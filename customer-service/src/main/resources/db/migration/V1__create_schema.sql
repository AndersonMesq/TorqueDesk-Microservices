-- ============================================
-- CUSTOMERS
-- ============================================
create table customers (
                           id uuid not null,
                           tenant_id uuid not null,
                           name varchar(150) not null,
                           email varchar(255) not null,
                           phone varchar(255) not null,

                           created_at timestamp(6) not null,
                           updated_at timestamp(6) not null,

                           constraint pk_customers primary key (id),

                           constraint uk_customers_email
                               unique (email),

                           constraint uk_customers_phone
                               unique (phone),

                           constraint fk_customers_tenant
                               foreign key (tenant_id)
                                   references tenants (id)
);

-- ============================================
-- VEHICLES
-- ============================================
create table vehicles (
                          id uuid not null,
                          customer_id uuid not null,
                          brand varchar(100) not null,
                          model varchar(100) not null,
                          plate varchar(100) not null,
                          model_year integer not null,

                          created_at timestamp(6) not null,
                          updated_at timestamp(6) not null,

                          constraint pk_vehicles primary key (id),

                          constraint fk_vehicles_customer
                              foreign key (customer_id)
                                  references customers (id)
);
-- ============================================
-- INDEXES
-- ============================================
create index idx_service_orders_vehicle_id
    on service_orders (vehicle_id);

create index idx_service_orders_mechanic_id
    on service_orders (mechanic_id);

create index idx_service_order_assignment_service_order_id
    on service_order_assignment (service_order_id);

create index idx_service_order_assignment_employee_id
    on service_order_assignment (employee_id);

create index idx_vehicles_customer_id
    on vehicles (customer_id);