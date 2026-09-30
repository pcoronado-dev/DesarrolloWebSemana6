# OBSERVACIONES Y CONCLUSIONES - Laboratorio Spring Security

## OBSERVACIONES

1. **Configuración de la base de datos**: Se creó la base de datos `securitydb` en MySQL y se configuró el archivo `application.properties` con las credenciales correspondientes. Es importante asegurarse de que el servicio MySQL esté activo antes de ejecutar la aplicación.

2. **Dependencias necesarias**: Se utilizaron las dependencias de Spring Boot Starter Security, Spring Boot Starter Data JPA y MySQL Connector. La versión de Spring Boot 3.2.0 requiere Java 17 o superior.

3. **Cifrado de contraseñas**: Se implementó el uso de `BCryptPasswordEncoder` para cifrar las contraseñas de los usuarios antes de almacenarlas en la base de datos, lo que proporciona una capa adicional de seguridad.

4. **Configuración de rutas**: Se modificaron las rutas originales según las actividades: `/admin/panel` → `/management/dashboard`, `/user/dashboard` → `/client/home` y `/public/hello` → `/api/free`. También se agregó la ruta `/manager/reportes` para el nuevo rol.

5. **Pruebas con Postman**: Se realizaron pruebas con Postman utilizando autenticación HTTP Basic. Se verificó que cada usuario solo puede acceder a los endpoints permitidos según su rol, y que el endpoint público `/api/free/hello` es accesible sin autenticación.

## CONCLUSIONES

1. **Spring Security es una herramienta robusta**: La implementación de seguridad básica con Spring Security demostró ser efectiva y fácil de configurar. El uso de anotaciones como `@EnableWebSecurity` y la configuración de `SecurityFilterChain` permiten definir reglas de acceso de manera clara y concisa.

2. **La importancia del cifrado de contraseñas**: El uso de `BCryptPasswordEncoder` es fundamental para proteger las contraseñas de los usuarios. Nunca se deben almacenar contraseñas en texto plano, ya que esto representa un riesgo de seguridad significativo.

3. **El control de acceso basado en roles (RBAC) es esencial**: La implementación de roles (ROLE_USER, ROLE_ADMIN, ROLE_MANAGER) permitió demostrar cómo se puede restringir el acceso a diferentes partes de la aplicación según el nivel de privilegios del usuario.

4. **La organización del proyecto es importante**: La estructura de paquetes (model, repository, service, config, controller, util) facilita el mantenimiento y la escalabilidad del proyecto. Cada componente tiene una responsabilidad clara y bien definida.

5. **Se resolvieron las dudas mediante la práctica**: Durante el desarrollo del laboratorio, se presentaron dudas sobre la configuración de las rutas y la asignación de roles. Estas se resolvieron consultando la documentación oficial de Spring Security y realizando pruebas con Postman, lo que permitió comprender mejor el funcionamiento del framework.
