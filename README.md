# Nova Farma - Sistema de Gestion

## Segunda Entrega

Proyecto de gestion de inventario para farmacia, evolucionando desde la landing page estatica (ATF1) hacia una aplicacion web dinamica con Spring Boot y Thymeleaf.

---

## Tecnologias

- **Java 21**
- **Spring Boot 3.3.0**
- **Spring Web** (MVC)
- **Thymeleaf** (motor de plantillas)
- **Bootstrap 5.3.3** (CDN)
- **Bootstrap Icons** (CDN)

---

## Arquitectura (Type-Based)

```
Controller (@Controller)
    |
Service (@Service)
    |
Repository (lista en memoria con @Component)
```

---

## Estructura de Carpetas

```
Marcos_de_Desarrollo_Web_Proyecto-master/
|-- pom.xml
|-- README.md
|-- .gitignore                      (Archivos ignorados por Git)
|-- src/
|   |-- main/
|   |   |-- java/com/novafarma/app/
|   |   |   |-- NovaFarmaApplication.java
|   |   |   |-- controller/
|   |   |   |   |-- WebController.java
|   |   |   |-- service/
|   |   |   |   |-- ProductoService.java
|   |   |   |   |-- IncidenciaService.java
|   |   |   |-- repository/
|   |   |   |   |-- ProductoRepository.java
|   |   |   |   |-- IncidenciaRepository.java
|   |   |   |-- model/entity/
|   |   |   |   |-- Producto.java
|   |   |   |   |-- Incidencia.java
|   |   |-- resources/
|   |   |   |-- application.properties
|   |   |   |-- templates/
|   |   |   |   |-- fragments/
|   |   |   |   |   |-- layout.html
|   |   |   |   |-- inicio.html
|   |   |   |   |-- inventario.html
|   |   |   |   |-- alertas.html
|   |   |   |   |-- registro.html
|   |   |   |-- static/
|   |   |   |   |-- css/
|   |   |   |   |   |-- temas.css
|   |   |   |   |-- img/
|   |   |   |   |   |-- adminitarcionfarmacia.jpg
|   |   |   |   |   |-- novafarmalogo.png
|-- capturas/                       (Evidencias ATF1)
|-- DocumentacionDelProyecto/       (PDFs de clase)
```

---

## Como Ejecutar

### Requisitos
- **Java 21** instalado (obligatorio, el proyecto no funciona con Java 8 u 11)
- **Maven 3.9+** (solo si compilas desde el codigo fuente)

#### Verificar tu version de Java
```bash
java -version
```
Debe decir `java version "21.0.X"` o similar.

#### Configurar JAVA_HOME en Windows (PowerShell)
Si tienes Java 21 instalado pero `java -version` muestra otra version:
```powershell
$env:JAVA_HOME="C:\Program Files\Java\jdk-21"
$env:Path="$env:JAVA_HOME\bin;" + $env:Path
java -version
```

---

### Opcion A: Desde codigo fuente (GitHub / Companeros)

```bash
# 1. Navegar a la carpeta del proyecto
cd Marcos_de_Desarrollo_Web_Proyecto-master/Marcos_de_Desarrollo_Web_Proyecto-master

# 2. Compilar y generar el JAR
mvn clean package

# 3. Ejecutar la aplicacion
java -jar target/novafarma-spring-1.0.0.jar

# 4. Abrir navegador en:
http://localhost:8080
```

### Opcion B: Desde ZIP con JAR incluido (Docente)

```bash
# 1. Descomprimir el ZIP
# 2. Navegar a la carpeta del proyecto
cd Marcos_de_Desarrollo_Web_Proyecto-master/Marcos_de_Desarrollo_Web_Proyecto-master

# 3. Ejecutar directamente el JAR
java -jar target/novafarma-spring-1.0.0.jar

# 4. Abrir navegador en:
http://localhost:8080
```

---

### Nota sobre el JAR
- En GitHub: el JAR no esta incluido (target/ esta en .gitignore). Debes compilar con `mvn clean package`.
- En el ZIP de entrega: el JAR ya esta incluido en la carpeta `target/`. Solo ejecutas `java -jar`.

---

## Paginas

| Ruta | Descripcion |
|------|-------------|
| `/` | Inicio - Dashboard con KPIs dinamicos |
| `/inventario` | Tabla completa de productos |
| `/alertas` | Productos con stock bajo o vencimiento proximo |
| `/registro` | Formularios de ingreso de mercaderia e incidencias |

---

## Checklist de Rubrica

- [x] Configuracion de Spring Boot (Spring Initializr + pom.xml)
- [x] Dependencias Spring Web y Thymeleaf
- [x] Servidor levanta sin errores
- [x] Arquitectura de Controladores (@Controller)
- [x] Multiples rutas con @GetMapping
- [x] Redireccion a vistas Thymeleaf
- [x] Objeto Model para transferir datos
- [x] Expresiones ${...} con th:text
- [x] Iteracion de listas con th:each
- [x] Logica condicional con th:if
- [x] Fragmentos de plantilla (th:fragment, th:replace)
- [x] Layout modular (head, navbar, footer)
- [x] Bootstrap responsive integrado
- [x] Formularios funcionales (POST)
- [x] Modal de confirmacion Bootstrap

---

## Notas

- Los datos se cargan al iniciar la aplicacion desde listas en memoria predefinidas.
- Los formularios realizan POST al servidor y los datos se mantienen mientras la app este corriendo.
- Las alertas se calculan dinamicamente segun el stock y la fecha de vencimiento de cada producto.

---

## Autor

Proyecto academico - Marcos de Desarrollo Web

---

## Historial de Entregas

| Entrega | Descripcion |
|---------|-------------|
| **ATF1** | Landing page estatica con Bootstrap 5.3.3 (1 archivo HTML, navbar responsive, cards, tablas, formularios, modal) |
| **Segunda** | Aplicacion web Spring Boot + Thymeleaf con 4 paginas dinamicas, MVC por capas, layouts modulares |

### ATF1 — Primera Entrega
- Sitio estatico de una sola pagina con Bootstrap 5.3.3 (CDN)
- Navbar responsive con collapse, grid system (container + row + col-*)
- Cards (minimo 4), tablas estilizadas (table-hover), imagenes responsive
- Formulario con 4+ campos, modal de confirmacion Bootstrap
- Utilities: p-*, m-*, text-*, bg-*, rounded, shadow
- Capturas responsive: mobile (375px) y desktop (>=1200px)

### Segunda Entrega — Aplicacion Web Spring Boot
- Proyecto configurado via Spring Initializr con Spring Web + Thymeleaf
- Controladores @Controller con multiples rutas @GetMapping
- Vistas Thymeleaf con Model, th:text, th:each, th:if
- Sistema de plantillas modular con th:fragment y th:replace
- Bootstrap de la Unidad 1 integrado y responsivo
- Arquitectura Type-Based: Controller -> Service -> Repository

---

## Repositorio

[GitHub - Kaiilo1020/Marcos_de_Desarrollo_Web_Proyecto](https://github.com/Kaiilo1020/Marcos_de_Desarrollo_Web_Proyecto)
