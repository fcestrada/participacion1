# API REST - Gestión de Estudiantes  - Ejercicio 1

## Integrantes
- **Carlos Andres Rodriguez**
- **Francisco Miztli López Salinas**
- **José Fernando Castañeda Estrada**
- **Juan Fernando Gonzalez Castro**

## Descripción del Proyecto
Este proyecto implementa una API REST para gestionar información de estudiantes. La API está construida utilizando Spring Boot y proporciona endpoints para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre la entidad Estudiante.

## Modelo de Datos
La entidad principal del modelo es `Estudiante` con los siguientes atributos:

```java
public class Estudiante {
    private Integer matricula;
    private String nombre;
    private String apellido;
    private String correo;
}
```

Nota: La matrícula es un ID y es autoincrementable.

## API Endpoints
Todos los endpoints están bajo la URL base: `http://localhost:8080/api/estudiantes`

### 1. Obtener Todos los Estudiantes
- **Método:** GET
- **URL:** `/`
- **Descripción:** Retorna una lista de todos los estudiantes registrados.

### 2. Obtener un Estudiante
- **Método:** GET
- **URL:** `/{id}`
- **Parámetros:** `id` (PathVariable) - Matrícula del estudiante
- **Descripción:** Retorna los datos de un estudiante específico según su matrícula.

### 3. Crear un Estudiante
- **Método:** POST
- **URL:** `/`
- **Body:** Objeto Estudiante (RequestBody)
- **Descripción:** Crea un nuevo registro de estudiante.

### 4. Actualizar un Estudiante
- **Método:** PUT
- **URL:** `/{id}`
- **Parámetros:** `id` (PathVariable) - Matrícula del estudiante
- **Body:** Objeto Estudiante (RequestBody)
- **Descripción:** Actualiza todos los datos de un estudiante existente.

### 5. Actualizar Parcialmente un Estudiante
- **Método:** PATCH
- **URL:** `/{id}`
- **Parámetros:** `id` (PathVariable) - Matrícula del estudiante
- **Body:** Objeto Estudiante con campos a actualizar (RequestBody)
- **Descripción:** Actualiza parcialmente los datos de un estudiante existente validando unicamnete los que no vengan nullos.

### 6. Borrar un Estudiante
- **Método:** DELETE
- **URL:** `/{id}`
- **Parámetros:** `id` (PathVariable) - Matrícula del estudiante
- **Descripción:** Elimina el registro de un estudiante según su matrícula.

### 7. Créditos
- **Método:** GET
- **URL:** `/creditos`
- **Descripción:** Retorna un HTML listando los integrantes del equipo.

### 8. JSON Ejemplo
Un ejemplo de JSON a enviar a los endpoints que requieren RequestBody
```json
{
  "matricula": 6,
  "nombre": "William",
  "apellido": "Wallace",
  "correo": "willian.wallace@diplomado-java.unam.mx"
}
```

## Controlador
El controlador principal es `EstudianteRestController` y está mapeado a `/api/estudiantes`:

```java
@RequestMapping("/api/estudiantes")
public class EstudianteRestController {
    // Implementación de los métodos para cada endpoint
}
```

## Ejecución del Proyecto
Para ejecutar el proyecto, asegúrate de tener instalado Java y Maven. Luego, sigue estos pasos:

1. Clona el repositorio
2. Navega al directorio del proyecto
3. Ejecuta `mvn spring-boot:run`
4. La API estará disponible en `http://localhost:8080/api/estudiantes`

---

Para más detalles sobre la implementación y uso de cada endpoint, por favor revisa el código fuente en el controlador `EstudianteRestController`.
