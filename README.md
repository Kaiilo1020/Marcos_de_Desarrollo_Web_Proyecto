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
|-- .gitignore
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
|-- capturas/                       (Evidencias visuales ATF1 + ATF2)
```

---

## Requisitos Previos

Antes de ejecutar, verifica que tienes Java 21 o superior instalado.

```bash
java -version
```

Debe mostrar algo como:
```
openjdk version "21" ...
```

Si muestra 8, 11 o 17, descarga e instala Java 21 desde:
https://adoptium.net/

---

## Ejecucion con ZIP de Entrega (Recomendado)

Usa este metodo si descargaste el ZIP que contiene el JAR ya compilado.

**Paso 1:** Descomprime el ZIP.

**Paso 2:** Abre la terminal dentro de la carpeta que contiene `pom.xml`.

> Nota: El ZIP tiene carpetas anidadas. Asegurate de estar en la carpeta INTERNA donde esta el archivo `pom.xml`.

**Paso 3:** Ejecuta el JAR:

```bash
java -jar target/novafarma-spring-1.0.0.jar
```

**Paso 4:** Abre tu navegador en:

```
http://localhost:8080
```

El servidor estara corriendo mientras la terminal permanezca abierta.
Para detenerlo, presiona `Ctrl + C` en la terminal.

> Nota: Los datos se almacenan temporalmente en memoria. Al reiniciar la aplicacion, solo se conservan los productos de prueba iniciales.

---

## Ejecucion desde GitHub (Para Desarrolladores)

Usa este metodo si clonaste el repositorio. Requiere Maven instalado.

**Paso 1:** Clona el repositorio:

```bash
git clone https://github.com/Kaiilo1020/Marcos_de_Desarrollo_Web_Proyecto.git
```

**Paso 2:** Entra a la carpeta del proyecto (donde esta `pom.xml`):

```bash
cd Marcos_de_Desarrollo_Web_Proyecto-master/Marcos_de_Desarrollo_Web_Proyecto-master
```

**Paso 3:** Verifica que tienes Maven instalado:

```bash
mvn -version
```

**Paso 4:** Compila el proyecto:

```bash
mvn clean package
```

**Paso 5:** Ejecuta el JAR generado:

```bash
java -jar target/novafarma-spring-1.0.0.jar
```

**Paso 6:** Abre tu navegador en:

```
http://localhost:8080
```

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
