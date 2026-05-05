package com.test.gestioncol.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI gestionColegioOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Sistema de Gestión de Asignaturas")
                        .version("1.0.0")
                        .description("""
                                Documentación oficial de la API REST del sistema de gestión de asignaturas para un colegio.

                                Esta API permite consultar, crear, actualizar y eliminar asignaturas según el rol del usuario autenticado.

                                Roles principales:
                                - RECTOR: puede administrar completamente las asignaturas.
                                - DOCENTE: puede consultar asignaturas y actualizar horarios.
                                - ESTUDIANTE: puede consultar asignaturas en modo lectura.

                                Información del proyecto:
                                - Autora: Valeria Vargas Artundua
                                - Código: 20242229393
                                - Email: u20242229393@usco.edu.co
                                - Institución: Universidad Surcolombiana
                                - Fecha: Martes 5 de mayo
                                """));
    }
}