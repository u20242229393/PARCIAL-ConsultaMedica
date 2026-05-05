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
    <title>Detalle de Asignatura</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow">
                <div class="card-header bg-info text-white">
                    <h4 class="mb-0">📖 Detalle de Asignatura</h4>
                </div>
                <div class="card-body">
                    <table class="table table-bordered">
                        <tbody>
                        <tr>
                            <th width="30%" class="table-light">ID:</th>
                            <td>${asignatura.id}</td>
                        </tr>
                        <tr>
                            <th class="table-light">Nombre:</th>
                            <td><strong>${asignatura.nombre}</strong></td>
                        </tr>
                        <tr>
                            <th class="table-light">Descripción:</th>
                            <td>${asignatura.descripcion}</td>
                        </tr>
                        <tr>
                            <th class="table-light">Salón:</th>
                            <td>${asignatura.salon}</td>
                        </tr>
                        <tr>
                            <th class="table-light">Horario:</th>
                            <td>${asignatura.horaInicio} - ${asignatura.horaFin}</td>
                        </tr>
                        <tr>
                            <th class="table-light">Docente:</th>
                            <td>${asignatura.docente.nombreDocente}</td>
                        </tr>
                        <c:if test="${not empty asignatura.docente.especialidad}">
                            <tr>
                                <th class="table-light">Especialidad:</th>
                                <td>${asignatura.docente.especialidad}</td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>

                    <!-- Botones de acción -->
                    <div class="d-flex gap-2 flex-wrap">
                        <a href="${pageContext.request.contextPath}/asignatura" class="btn btn-secondary">
                            ← Volver
                        </a>

                        <c:if test="${rol == 'RECTOR'}">
                            <a href="${pageContext.request.contextPath}/asignatura/editar/${asignatura.id}"
                               class="btn btn-warning">
                                ✏️ Editar
                            </a>
                        </c:if>

                        <c:if test="${rol == 'RECTOR' || rol == 'DOCENTE'}">
                            <a href="${pageContext.request.contextPath}/asignatura/actualizar-horario/${asignatura.id}"
                               class="btn btn-primary">
                                🕒 Actualizar Horario
                            </a>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap 5 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
