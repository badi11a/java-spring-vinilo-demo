# Java Spring Boot: Vinilo Demo (MVC + DTO)

Este proyecto es una base educativa para el aprendizaje de **Spring Boot**, enfocada en la implementación de una arquitectura de capas, el uso de **Thymeleaf** y el patrón **DTO**.

## 🚀 Arquitectura del Proyecto

El proyecto sigue un patrón de **capas** para asegurar la escalabilidad y facilitar el mantenimiento futuro:

1. **Modelo (Entity):** Representación de la tabla `vinilos` en MariaDB mediante JPA.
2. **Repositorio:** Interfaz que extiende de `JpaRepository` para operaciones CRUD automáticas.
3. **Servicio:** Capa de lógica de negocio donde se realiza el mapeo de Entidades a DTOs.
4. **Controlador:** Maneja las peticiones HTTP y devuelve las vistas de Thymeleaf.

Además de las capas, el proyecto usa un **DTO (Data Transfer Object)**: no es una capa en sí, sino un objeto simple que viaja *entre* capas (del Servicio al Controlador y a la vista) para exponer solo los datos necesarios, sin acoplar la vista a la Entidad JPA.

## 🛠️ Tecnologías Utilizadas

* **Java 25**
* **Spring Boot 4.x**
* **Spring Web MVC** (Controladores y ruteo HTTP)
* **Spring Data JPA**
* **Thymeleaf** (Motor de plantillas)
* **MariaDB** (Base de datos)
* **Maven** (Gestión de dependencias)

## 📋 Requisitos Previos

1. Contar con una instancia de **MariaDB** corriendo localmente.
2. Configurar las credenciales en `src/main/resources/application.properties`.
3. La propiedad `spring.jpa.hibernate.ddl-auto=update` está activa para generar la tabla automáticamente al inicio.

> ⚠️ **Nota educativa:** `spring.datasource.username` y `spring.datasource.password` se dejan vacíos a propósito en el repositorio — cada quien debe completarlos localmente con sus propias credenciales de MariaDB. En una aplicación real ni siquiera conviene dejar esas claves en un archivo versionado: se externalizan con variables de entorno o un `application-local.properties` ignorado por Git.
>
> El test `ViniloAppTests` (`contextLoads`) levanta el contexto completo de Spring, por lo que **necesita la instancia de MariaDB corriendo** para pasar; no es un test aislado con base de datos en memoria.

## ▶️ Ejecución

```bash
./mvnw spring-boot:run
```

Con la app corriendo (puerto por defecto `8080`), el único endpoint disponible es:

* `GET http://localhost:8080/vinilos` — Renderiza la vista Thymeleaf con el catálogo de vinilos (tabla obtenida vía `ViniloController` → `ViniloService` → `ViniloRepository`).

## 🛣️ Próximos Pasos

* Implementación de **Spring Security** para control de acceso basado en roles.
* Creación de formularios de registro con encriptación de contraseñas (**BCrypt**).
* Gestión de sesiones y perfiles de usuario.
