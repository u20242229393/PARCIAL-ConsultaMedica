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
    <title>${asignatura.id == null ? 'Nueva' : 'Editar'} Asignatura</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card shadow">
                <div class="card-header bg-success text-white">
                    <h4 class="mb-0">📝 ${asignatura.id == null ? 'Nueva' : 'Editar'} Asignatura</h4>
                </div>
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/asignatura" method="post">
                        <input type="hidden" name="id" value="${asignatura.id}" />


                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre de la Asignatura <span class="text-danger">*</span></label>
                            <input type="text"
                                   class="form-control"
                                   id="nombre"
                                   name="nombre"
                                   value="${asignatura.nombre}"
                                   maxlength="30"
                                   required />
                            <small class="text-muted">Máximo 30 caracteres</small>
                        </div>


                        <div class="mb-3">
                            <label for="descripcion" class="form-label">Descripción</label>
                            <textarea class="form-control"
                                      id="descripcion"
                                      name="descripcion"
                                      rows="3"
                                      maxlength="100">${asignatura.descripcion}</textarea>
                            <small class="text-muted">Máximo 100 caracteres</small>
                        </div>


                        <div class="mb-3">
                            <label for="salon" class="form-label">Salón <span class="text-danger">*</span></label>
                            <input type="number"
                                   class="form-control"
                                   id="salon"
                                   name="salon"
                                   value="${asignatura.salon}"
                                   required />
                        </div>


                        <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="horaInicio" class="form-label">Hora de Inicio <span class="text-danger">*</span></label>
                                <input type="time"
                                       class="form-control"
                                       id="horaInicio"
                                       name="horaInicio"
                                       value="${asignatura.horaInicio}"
                                       required />
                            </div>

                            <div class="col-md-6 mb-3">
                                <label for="horaFin" class="form-label">Hora de Finalización <span class="text-danger">*</span></label>
                                <input type="time"
                                       class="form-control"
                                       id="horaFin"
                                       name="horaFin"
                                       value="${asignatura.horaFin}"
                                       required />
                            </div>
                        </div>


                        <div class="mb-3">
                            <label for="docente" class="form-label">Docente Encargado <span class="text-danger">*</span></label>
                            <select class="form-select" id="docente" name="docente.id" required>
                                <option value="">-- Seleccione un docente --</option>
                                <c:forEach items="${docentes}" var="doc">
                                    <option value="${doc.id}"
                                        ${asignatura.docente != null && asignatura.docente.id == doc.id ? 'selected' : ''}>
                                            ${doc.nombreDocente}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>


                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-success">
                                💾 Guardar Asignatura
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
