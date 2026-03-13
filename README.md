# BuscaTuVehiculo - Backend API
Esta es la API REST que gestiona el motor de búsqueda y el inventario de vehículos para el proyecto BuscaTuVehiculo. Fue construida con un enfoque en escalabilidad, seguridad y buenas prácticas de desarrollo backend.

---

## Tecnologías Utilizadas
 * Java 17 & Spring Boot 3 para el núcleo del proyecto y gestión de la aplicación.
 * Spring Security + JWT en la implementación de seguridad con tokens para autenticación y manejo de roles (ADMIN/USER).
 * Spring Data JPA & PostgreSQL para la persistencia de datos y gestión de relaciones entre entidades.
 * Flyway para llevar un control de versiones y migraciones automáticas de la base de datos.
 * Maven en la gestión de dependencias y construcción del proyecto.

---

## Caracteristicas
 * Arquitectura por Capas: Separación clara de responsabilidades entre Controladores, Servicios y Repositorios.
 * Manejo de Roles: Endpoints protegidos donde solo usuarios con rol ADMIN pueden realizar operaciones de escritura (POST, PUT, DELETE) en el inventario.
 * Validación de Datos: Uso de @Valid y DTOs para asegurar que la información recibida desde el frontend sea correcta antes de procesarla.
 * CORS Configurado: Configuración específica para permitir la comunicación segura con el frontend alojado en Vercel.

---

## Estado del proyecto
Finalizado
