INSERT INTO roles (name)
VALUES ('ROLE_ADMIN'),('ROLE_EMPLOYEE'),('ROLE_CUSTOMER'),('ROLE_USER')
    on conflict (name) do nothing;