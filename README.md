# University Management System

Sistema de gestión universitaria desarrollado como práctica de backend.

## ¿Con qué está hecho?

- Java 21
- Spring Boot 4.1.1
- Maven — incluido en el repositorio a través del wrapper, no requiere instalación
- PostgreSQL 18
- Docker
- Flyway

## ¿Qué necesito instalado antes de empezar?

**1. JDK 21**

Verificar la instalación:

```bash
java -version
```

**2. IDE**

Se recomienda alguno de los siguientes:

- IntelliJ IDEA
- Visual Studio Code con las extensiones de Java
- Eclipse

**3. Docker**

Verificar la instalación:

```bash
docker --version
```

Podés instalarlo siguiendo el siguiente link: https://www.docker.com/products/docker-desktop/

## ¿Cómo lo levanto?

Clonar el repositorio:

```bash
git clone <repo-url>
```

Los archivos de configuración no están en el repositorio porque contienen credenciales. Copiá las plantillas y completá los valores:

```bash
cp .env.example .env
```

```bash
cp src/main/resources/application-local.properties.example src/main/resources/application-local.properties
```

El usuario, la contraseña y el nombre de la base tienen que ser los mismos en los dos archivos: el .env es con el que se crea la base dentro del contenedor, y el application-local.properties es con el que la aplicación se conecta a ella.

Levantar base de datos:

```bash
docker compose up -d
```

Iniciar el servidor:

```bash
./mvnw spring-boot:run
```

En Windows, usar `mvnw.cmd` en lugar de `./mvnw`.

## Documentación

- [Diagrama entidad-relación](docs/der.png) — modelo de datos
- [Modelo en DBML](docs/der.dbml) — fuente del diagrama
- [Decisiones de arquitectura](docs/adr/) — por qué el modelo es así