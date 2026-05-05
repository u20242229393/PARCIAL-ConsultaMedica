<%--
  Created by IntelliJ IDEA.
  User: CAMILO1
  Date: 4/11/2025
  Time: 7:11 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Asignaturas</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">

    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>📚 Lista de Asignaturas</h2>
        <div>
            <span class="badge bg-primary me-2">${rol}</span>
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-danger btn-sm">
                Cerrar Sesión
            </a>
        </div>
    </div>


    <c:if test="${rol == 'RECTOR'}">
        <a href="${pageContext.request.contextPath}/asignatura/nueva" class="btn btn-success mb-3">
            ➕ Nueva Asignatura
        </a>
    </c:if>


    <c:if test="${empty asignaturas}">
        <div class="alert alert-info">
            📭 No hay asignaturas registradas.
        </div>
    </c:if>


    <c:if test="${not empty asignaturas}">
        <div class="table-responsive">
            <table class="table table-hover table-bordered">
                <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Salón</th>
                    <th>Horario</th>
                    <th>Docente</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${asignaturas}" var="asignatura">
                    <tr>
                        <td>${asignatura.id}</td>
                        <td><strong>${asignatura.nombre}</strong></td>
                        <td>${asignatura.descripcion}</td>
                        <td>${asignatura.salon}</td>
                        <td>${asignatura.horaInicio} - ${asignatura.horaFin}</td>
                        <td>${asignatura.docente.nombreDocente}</td>
                        <td>
                            <!-- Ver (TODOS) -->
                            <a href="${pageContext.request.contextPath}/asignatura/ver/${asignatura.id}"
                               class="btn btn-info btn-sm">Ver</a>

                            <!-- Editar/Eliminar (SOLO RECTOR) -->
                            <c:if test="${rol == 'RECTOR'}">
                                <a href="${pageContext.request.contextPath}/asignatura/editar/${asignatura.id}"
                                   class="btn btn-warning btn-sm">Editar</a>
                                <a href="${pageContext.request.contextPath}/asignatura/eliminar/${asignatura.id}"
                                   class="btn btn-danger btn-sm"
                                   onclick="return confirm('¿Eliminar ${asignatura.nombre}?')">Eliminar</a>
                            </c:if>

                            <!-- Actualizar horario (RECTOR y DOCENTE) -->
                            <c:if test="${rol == 'RECTOR' || rol == 'DOCENTE'}">
                                <a href="${pageContext.request.contextPath}/asignatura/actualizar-horario/${asignatura.id}"
                                   class="btn btn-secondary btn-sm">Horario</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
