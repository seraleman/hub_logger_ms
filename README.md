# Logger_ms

## Tabla de contenido

1. [Descripción](#descripción)
2. [Tecnología](#tecnología)
3. [Instalación](#instalación)

## Descripción

Microservicio que administra los registros y las razones de visitas enlazándo esta información coherentemente.

---

## Tecnología

- Java
- Spring Boot
- MongoDB
- Docker

---

## Instalación

Para su uso se debe crear el archivo que contendrá la conexión a la base de datos y otra información.

- Crear archivo **application.properties** en _resources/_ e inlcuir el siguiente código:

```
spring.data.mongodb.uri=${URL_BD:mongodb+srv: url de la base de datos}
server.port=${PORT:8080}
spring.data.mongodb.auto-index-creation=true
```

- Dependiendo del editor de código que se use, hay diferentes modos de correr la aplicación.
  Si se está usando VSC (consultar paquete de extensiones necesarios para correr Java y Spring Boot)
  en _SPRING BOOT DASHBOARD_ el ícono de _play_ corre la app.

---
