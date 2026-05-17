# Evaluación Técnica Castores
Solución a la evaluación técnica de Castores


## Requisitos técnicos
1. **IDE utilizado**: Visual Studio Code (para Angular) y Spring Tools Suite 4 (para backend).
2. **Versión del lenguaje**: Java 17.
3. **DBMS utilizado**: MySQL Workbench 8.0.46.
4. **Versión de Angular**: 21.2.10.
5. **Versión de Node**: 22.15.0.


## Pasos para ejecutar la aplicación localmente

### 1 Configurar base de datos
**1.1 Crear el esquema en MySQL Workbench**
```bash
CREATE SCHEMA escenario_db_castores;
USE escenario_db_castores;
```
**1.2 Ejecutar los scripts de tablas**
 - SCRIPTS/script_utilizado.sql


### 2. Correr backend (Spring Boot)
Carpeta: BACKEND/escenario-castores

**2.1 Inicializar aplicación de Spring Boot**
Opción A - Usando Spring Tools Suite (STS)
- Abrir el proyecto en STS
- Hacer clic derecho en el proyecto → Run As → Spring Boot App

Opción B - Usando terminal
```bash
cd backend
mvn spring-boot:run
```

Puerto en funcionamiento
Configuración predeterminada de Spring Boot:  [http://localhost:8080/](http://localhost:8080/)


### 3. Correr frontend (Angular)
Carpeta: FRONTEND/escenario-castores

**3.1 Instalar dependencias (solo la primera vez)**
```bash
npm install
```
**3.2 Inicializar aplicación de Angular**
```bash
ng serve -o
```
Puerto en funcionamiento
Configuración predeterminada de Angular: [http://localhost:4200/](http://localhost:4200/)

