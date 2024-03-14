# Cifrado

Is the process of encoding the information of its original presentation (plain text) to encode text, with the purpose of only decoding it using a key.

History of encode:
1. Store passwords in plain text.
2. Store password encoded with a hash function.
3. Store passwords encoded with a hash function + salt
4. Store passwords encoded with an adaptively function + job factor.

Security can be reached making validation of passwords computationally expensive. 

## Spring Security Algorithms

* BCrypt
* PBKDF2
* scrypt
* argon2

# JWT: JSON Web Token

https://jwt.io/introduction

## Session functionality:

1. Client sends a request to the server (/api/login)
2. Server validates username and password. If they're not valid, responds with a 401 unauthorized.
3. Server validates username and password. If they are valid, stores the user in the session.
4. It generates a cookie in the client.
5. In the next requests it validates if client is in session.

Disadvantages:

* Information on session stores in the server, consuming more resources.


## JWT functionality:

1. Client sends a request to the server (/api/login)
2. Server validates username and password. If they're not valid, responds with a 401 unauthorized.
3. Server validates username and password. If they are valid, generates a JWT token using a secret key.
4. Server returns the JWT token generated.
5. Client sends requests to the REST endpoints of server, using the JWT token in headers (Authorization header).
6. Server validates the JWT in each request, and if it's correct it allows the access to data.

Advantages:

* The token stores in the client, so it consumes less resources in the server, allowing a better scaling.

Disadvantages:

* The token is in the client, so it can't be invalidated before the expiration date assigned when it was created.
* For this, you can erase the token when the user logout.

## JWT token structure

three parts separated by dots (.), which are:

1. Header

```json
{
  "alg": "HS512",
  "typ": "JWT"
}
```

2. Payload (information, no sensible user data)

```json
{
  "name": "Sara",
  "admin": true
}
```

3. Signature
```
HMACKSHA256(base64UrlEncode(header) + "." + base64UrlEncode(payload), secret)
```

The User-Agent sends the JWT token in the headers:
```
Authorization: Bearer <token>
```

## Spring Configuration
* Spring Security
* Spring Web
* Spring boot DevTools
* Spring Data JPA
* PostreSQL
* JWT dependecie (manually add it to the pom.xml)
```
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.12.5</version>
</dependency>

```

## Open Authorization (OAuth)

Es un framework de autorización, abierto y está construido estándares IETF y licenciado bajo Open Web Foundation.

Es un protocolo de delegación:

Permite que alguien que controla un recurso permita a una aplicación de software acceder a ese recurso en su propio nombre sin pasar por ello.

Con la ayuda de OAuth los usuarios pueden autorizar a third part applications a acceder a sus datos o ejecutar determinadas operaciones sin
necesidad de proporcionar usuario y contraseña.

## Flujo de trabajo con OAuth:

1. Una aplicación solicita autenticación
2. Se realiza login mediante Google
3. La aplicación se comunica con Google donde utilizan las credenciales de Google sin que la aplicación pueda verlas.
4. El servidor de Google pregunta al usuario si desea conceder X permisos
5. El usuario acepta los permisos
6. Google genera un token de acceso como respuesta
7. La aplicación utiliza ese token

## Escenarios para aplicar OAuth

1. Autenticación HTTP en la que no se quiere utilizar usuario y contraseña todo el tiempo
2. Múltiples aplicaciones dentro de una misma empresa y en consecuencia multiples cuentas con el mismo usuario y contraseña
3. Arquitecturas de microservicios
4. Interacción de aplicaciones de terceros


## Proveedores

Google, Github, Facebook, Okta

## OAuth en Spring Security

Inicialmente había un proyecto llamado Spring Security OAuth.

En 2018 se sobreescribe para hacerlo más eficiente, con un código base más sencillo.

Se depreca el antiguo (https://spring.io/projects/spring-security-oauth) y ahora OAuth está integrado sobre el propio Spring Security.

Incluye:

* Client Support
* Resource server
* Authorization Server: https://github.com/spring-projects/spring-authorization-server

Keycloak: https://www.keycloak.org/

Ver ejemplos de aplicaciones: https://github.com/spring-guides/tut-spring-boot-oauth2

## Flujos de acción OAuth:

* Authorization code
* Implicit
* Resource Owner password credentials
* Client Credentials
* Refres Token

## OpenID Connect

* OpenID Connect --> Authentication
* OAuth 2.0 --> Authorization
* HTTP

