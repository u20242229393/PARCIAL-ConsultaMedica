# Sistema Web para la Gestión de Asignaturas en un Colegio

Este proyecto corresponde a una aplicación web desarrollada con **Spring Boot**, orientada a la administración de asignaturas dentro de una institución educativa.  
El sistema incorpora autenticación, control de permisos por rol y operaciones diferenciadas según el tipo de usuario.

---

## 🧾 Información general del proyecto

La aplicación permite gestionar asignaturas académicas mediante tres perfiles principales:

| Rol | Permisos principales |
|-----|----------------------|
| **RECTOR** | Administración completa de asignaturas |
| **DOCENTE** | Consulta de asignaturas asignadas y actualización de horarios |
| **ESTUDIANTE** | Consulta de asignaturas en modo lectura |

El objetivo principal es facilitar el manejo de la información académica, aplicando restricciones de acceso según las responsabilidades de cada usuario.

---

## 🚀 Funcionalidades principales

### Perfil Rector

- Crear nuevas asignaturas.
- Consultar el listado completo de asignaturas.
- Editar información de asignaturas existentes.
- Eliminar asignaturas.
- Actualizar horarios académicos.

### Perfil Docente

- Visualizar únicamente las asignaturas que tiene a cargo.
- Modificar los horarios relacionados con sus asignaturas.

### Perfil Estudiante

- Consultar las asignaturas disponibles.
- Acceder a la información en modo solo lectura.

---

## 🛠️ Tecnologías utilizadas

El sistema fue construido usando las siguientes herramientas y tecnologías:

- Java 17 o superior
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- PostgreSQL
- JSP y JSTL
- Maven
- Swagger / OpenAPI
- Lombok
- Bootstrap

---

## 📌 Requisitos previos

Antes de ejecutar el proyecto, se recomienda contar con:

- JDK 17 o una versión superior.
- Maven 3.6 o superior.
- PostgreSQL 12 o superior.
- Un IDE compatible con Java, por ejemplo IntelliJ IDEA.

---

## ⚙️ Configuración y ejecución del proyecto

### 1. Clonar el repositorio


```git clone https://github.com/TU_USUARIO/TU_REPOSITORIO.git cd TU_REPOSITORIO```

### 2. Crear la base de datos

Desde PostgreSQL, crear la base de datos llamada `col`:


```psql -U postgres CREATE DATABASE col; \q``` 

### 3. Configurar la conexión a la base de datos

Editar el archivo:

```
src/main/resources/application.properties
```
Agregar o ajustar las credenciales correspondientes: 

```
properties spring.datasource.url=jdbc:postgresql://localhost:5432/col spring.datasource.username=TU_USUARIO spring.datasource.password=TU_CONTRASEÑA
```

### 4. Ejecutar scripts SQL, si es necesario

En caso de crear manualmente las tablas y datos iniciales, se pueden ejecutar los siguientes comandos:

```
psql -U postgres -d col -f database/schema.sql psql -U postgres -d col -f database/data.sql
```

### 5. Compilar y ejecutar la aplicación

```
bash mvn clean install mvn spring-boot:run
```
Una vez iniciado el proyecto, la aplicación estará disponible en:

```
http://localhost:8080
```
---

## 👥 Usuarios de prueba

Para validar el funcionamiento del sistema, se pueden utilizar las siguientes credenciales:

| Rol | Email | Contraseña |
|-----|-------|------------|
| Rector | rector1@colegio.com | 1234 |
| Docente | docente1@colegio.com | 1234 |
| Estudiante | estudiante1@colegio.com | 1234 |

---

## 📚 Documentación de la API

La documentación de los servicios REST se encuentra disponible mediante Swagger UI en la siguiente ruta:

```
text http://localhost:8080/swagger-ui.html 
```
### Endpoints principales

| Método | Ruta | Descripción |
|--------|------|-------------|
| `GET` | `/api/asignaturas` | Lista todas las asignaturas |
| `GET` | `/api/asignaturas/{id}` | Consulta una asignatura por su identificador |
| `POST` | `/api/asignaturas` | Crea una nueva asignatura, permitido solo para RECTOR |
| `PUT` | `/api/asignaturas/{id}` | Actualiza una asignatura, permitido solo para RECTOR |
| `DELETE` | `/api/asignaturas/{id}` | Elimina una asignatura, permitido solo para RECTOR |

---

## 📁 Organización del proyecto
```
src/
├── main/
│   ├── java/com/test/gestioncol/
│   │   ├── controller/      # Controladores (JSP y REST)
│   │   ├── model/           # Entidades JPA
│   │   ├── repository/      # Repositorios Spring Data
│   │   ├── service/         # Lógica de negocio
│   │   └── security/        # Configuración de seguridad
│   ├── resources/
│   │   ├── application.properties
│   │   └── import.sql       # Datos iniciales
│   └── webapp/WEB-INF/views/
│       ├── login.jsp
│       ├── acceso-denegado.jsp
│       └── asignatura/
│           ├── lista.jsp
│           ├── form.jsp
│           ├── form-horario.jsp
│           └── detalle.jsp
└── database/
├── schema.sql           # Script de creación de tablas
└── data.sql             # Script de datos iniciales
```

## 🔐 Seguridad del sistema

La seguridad de la aplicación se implementa mediante **Spring Security**, incluyendo:

- Inicio de sesión mediante formulario.
- Encriptación de contraseñas con BCrypt.
- Restricción de acceso según roles de usuario.
- Control de permisos para operaciones sensibles como creación, edición y eliminación.

---

## 👩‍💻 Autora

**Valeria Vargas Artundua**

- Código: 20242229393
- Email: u20242229393@usco.edu.co
- Universidad Surcolombiana

---

## 📅 Fecha de entrega

Martes 5 de mayo - Parcial 2 Programación Web
