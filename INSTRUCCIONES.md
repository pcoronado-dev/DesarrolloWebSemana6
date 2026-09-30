# Instrucciones de Ejecución - Laboratorio Spring Security

## Requisitos Previos

1. **Java 17** o superior instalado
2. **MySQL** instalado y en ejecución
3. **Maven** instalado
4. **Postman** (opcional, para pruebas)

## Pasos para Ejecutar

### 1. Crear la Base de Datos

Abre MySQL y ejecuta el script `database.sql`:

```sql
CREATE DATABASE IF NOT EXISTS securitydb;
USE securitydb;
```

### 2. Configurar application.properties

Edita el archivo `src/main/resources/application.properties` si es necesario:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/securitydb
spring.datasource.username=root
spring.datasource.password=
```

### 3. Compilar y Ejecutar el Proyecto

Desde la terminal, navega a la carpeta del proyecto y ejecuta:

```bash
mvn clean install
mvn spring-boot:run
```

### 4. Probar los Endpoints

Una vez que la aplicación esté en ejecución, puedes probar los siguientes endpoints:

| Endpoint | Método | Autenticación | Usuario |
|----------|--------|---------------|---------|
| `/api/free/hello` | GET | No requiere | Ninguno |
| `/client/home` | GET | Requiere | user |
| `/management/dashboard` | GET | Requiere | admin |
| `/manager/reportes` | GET | Requiere | manager |

### 5. Credenciales de Usuarios

| Usuario | Contraseña | Rol |
|---------|------------|-----|
| user | user2026 | ROLE_USER |
| admin | admin2026 | ROLE_ADMIN |
| manager | manager2026 | ROLE_MANAGER |

### 6. Ejemplo de Prueba con cURL

```bash
# Endpoint público (sin autenticación)
curl http://localhost:8080/api/free/hello

# Endpoint de usuario
curl -u user:user2026 http://localhost:8080/client/home

# Endpoint de administrador
curl -u admin:admin2026 http://localhost:8080/management/dashboard

# Endpoint de manager
curl -u manager:manager2026 http://localhost:8080/manager/reportes
```

## Estructura del Proyecto

```
SpringSecurityLab/
├── src/main/java/com/tecsup/
│   ├── model/
│   │   ├── Role.java
│   │   └── User.java
│   ├── repository/
│   │   ├── RoleRepository.java
│   │   └── UserRepository.java
│   ├── service/
│   │   └── UserDetailsServiceImpl.java
│   ├── config/
│   │   └── SecurityConfig.java
│   ├── controller/
│   │   ├── AdminController.java
│   │   ├── PublicController.java
│   │   ├── UserController.java
│   │   └── ManagerController.java
│   ├── util/
│   │   └── DataLoader.java
│   └── TecsupApplication.java
├── src/main/resources/
│   └── application.properties
├── database.sql
├── pom.xml
└── OBSERVACIONES_Y_CONCLUSIONES.md
```
