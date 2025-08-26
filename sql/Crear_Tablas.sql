 
--CREATE DATABASE IdentityUsers;

-- Conectarse a la base de datos
--\c IdentityUsers;

-- Tabla Usuarios
CREATE TABLE Usuarios (
    UserId SERIAL PRIMARY KEY,
    UserName VARCHAR(255) NOT NULL,
    State BOOLEAN,
    AUD_USU VARCHAR(25),
    AUD_TIM TIMESTAMP
);

-- Tabla Roles
CREATE TABLE Roles (
    RoleId SERIAL PRIMARY KEY,
    RoleName VARCHAR(125) NOT NULL,
    aud_usu VARCHAR(25),
    aud_tim timestamp
);

-- Tabla UsersInRoles
CREATE TABLE UsersInRoles (
    UserId INTEGER NOT NULL,
    RoleId INTEGER NOT NULL,
    aud_usu VARCHAR(25),
    aud_tim timestamp,
    PRIMARY KEY (UserId, RoleId),
    FOREIGN KEY (UserId) REFERENCES Usuarios(UserId) ON DELETE CASCADE,
    FOREIGN KEY (RoleId) REFERENCES Roles(RoleId) ON DELETE CASCADE
);