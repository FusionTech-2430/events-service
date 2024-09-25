
![Logo](https://github.com/FusionTech-2430/.github/blob/main/profile/Banner2.png?raw=true)

# AllConnected Events Service

Microservicio encargado de gestionar los eventos de la plataforma __AllConnected__.

---
## Stack Tecnológico 🛠️

**Servidor:** Springboot

![BD](https://skillicons.dev/icons?i=spring,maven)

**Base de datos:** PostgresQL

![BD](https://skillicons.dev/icons?i=postgresql)

---
## Variables de Entorno 🔒

Para ejecutar este proyecto, necesitarás agregar las siguientes variables de entorno a tu archivo .env

### Conexion a la base de datos

`DATASOURCE_URL`
`DATASOURCE_USERNAME`
`DATASOURCE_PASSWORD`

### Configuración de Firebase
Estas variables son extraidas del archivo de configuración de Firebase en formato JSON

`GOOGLE_ADMIN_CONFIG_TYPE`
`GOOGLE_ADMIN_CONFIG_PROJECT_ID`
`GOOGLE_ADMIN_CONFIG_PRIVATE_KEY`
`GOOGLE_ADMIN_CONFIG_PRIVATE_KEY_ID`
`GOOGLE_ADMIN_CONFIG_CLIENT_EMAIL`
`GOOGLE_ADMIN_CONFIG_CLIENT_ID`
`GOOGLE_ADMIN_CONFIG_CLIENT_X509_CERT_URL`

---
## Ejecutar Localmente 💻

Clona el proyecto

```bash
  git clone https://github.com/FusionTech-2430/events-service.git
```

Ve al directorio del proyecto

```bash
  cd events-service
```

Instala las dependencias

```bash
  mvn install
```

Inicia el servidor

```bash
  mvn spring-boot:run
```

---

## Autores 🧑🏻‍💻

- [@alejandronoss1017](https://github.com/alejandronoss1017)
- [@carlosantiagorojas](https://github.com/carlosantiagorojas)
