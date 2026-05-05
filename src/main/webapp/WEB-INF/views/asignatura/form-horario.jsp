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
    <title>Actualizar Horario</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0">🕒 Actualizar Horario</h4>
                </div>
                <div class="card-body">

                    <div class="alert alert-info">
                        <h5 class="alert-heading">📚 ${asignatura.nombre}</h5>
                        <hr>
                        <p class="mb-1"><strong>Salón:</strong> ${asignatura.salon}</p>
                        <p class="mb-1"><strong>Docente:</strong> ${asignatura.docente.nombreDocente}</p>
                        <p class="mb-0"><strong>Horario actual:</strong> ${asignatura.horaInicio} - ${asignatura.horaFin}</p>
                    </div>


                    <form action="${pageContext.request.contextPath}/asignatura/actualizar-horario" method="post">
                        <input type="hidden" name="id" value="${asignatura.id}" />

                        <div class="mb-3">
                            <label for="horaInicio" class="form-label">Nueva Hora de Inicio <span class="text-danger">*</span></label>
                            <input type="time"
                                   class="form-control"
                                   id="horaInicio"
                                   name="horaInicio"
                                   value="${asignatura.horaInicio}"
                                   required />
                        </div>

                        <div class="mb-3">
                            <label for="horaFin" class="form-label">Nueva Hora de Finalización <span class="text-danger">*</span></label>
                            <input type="time"
                                   class="form-control"
                                   id="horaFin"
                                   name="horaFin"
                                   value="${asignatura.horaFin}"
                                   required />
                        </div>

                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-primary">
                                💾 Actualizar Horario
                            </button>
                            <a href="${pageContext.request.contextPath}/asignatura" class="btn btn-outline-secondary">
                                ❌ Cancelar
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
