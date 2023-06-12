
## Introduccion

 La aplicación se trata de una billetera digital en la cual una persona puede transitar por los procesos de registro de usuario, login, envío, recepción y recarga de dinero. Además, es posible realizar transferencias de moneda hacia establecimientos comerciales y operar mediante un CVU (clave virtual uniforme) y QR. Es posible agregar a mi lista de contactos otros usuarios de TransferTech y visualizar mis estadísticas transaccionales de acuerdo a mi actividad en la aplicación, y muchas otras cosas que hacen de esta aplicacion única.

------------
 ## Comenzando
Este proyecto está dividido en dos grandes secciones correspondientes al Frontend (client) y al Backend (api).

Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas.


------------
## Clonar el repo 💾

FrontEnd:
- Prerequisitos: Tener instalado Node.js y Angular.

1. Clonar el repositorio en la ubicación que elijas.
`https://github.com/No-Country/S8-09-java-angular`

2. Moverse a la carpeta frontend
`cd frontend`

3. Instalar dependencias 
`npm install`

4. Correr el proyecto en local
`ng serve`

BackEnd:
 - Prerequisitos: Tener instalado Docker y disponer de credenciales válidas de servicio de SMTP y de AWS con permisos para utilizar AWS Rekognition.
                  
 - Aclaración: el archivo docker-compose dispone de generación y renovación automática de certificados SSL, y de la configuración automática de Nginx como proxy reverso
en caso de que se suministre un dominio válido.

1. Clonar el repositorio en la ubicación que elijas.
`https://github.com/No-Country/S8-09-java-angular`

2. Moverse a la carpeta backend
`cd backend`

3. Definir las credenciales de SMTP y AWS como variables de entorno o como secretos.

4. Abrir el archivo docker-compose.yml y reemplazar la linea
`-image:{$IMAGE}` por `-build: .`

5. Correr el archivo docker-compose.yml
`docker-compose up`

------------

## Caracteristicas
- Registro de usuarios: Los usuarios pueden crear una cuenta en la aplicación proporcionando la información necesaria, como nombre, dirección de correo electrónico , contraseña. 

- Verificación de identidad: Los usuarios deben completar el proceso de autentificación, donde deberán responder con el código enviado a su email y posteriormente
  validar su identidad proporcionando su documentación la cual será verificada por IA.

- Inicio de sesión: Los usuarios registrados pueden acceder a la aplicación utilizando sus credenciales de inicio de sesión.

- Saldo de cuenta: Los usuarios pueden ver el saldo actual de su cuenta en la aplicación.

- Transacciones: Los usuarios pueden realizar transacciones, como enviar dinero a otros usuarios o recibir pagos de ellos.

- Historial de transacciones: Se mantiene un registro detallado de todas las transacciones realizadas por el usuario, lo que permite un seguimiento preciso de los movimientos de dinero.

------------

## Construido Con 🔨

FrontEnd:
- Angular
- Angular Material
- Boostrap

Backend:
 - Spring Boot
 - PostgreSQL
 - Docker
 - Nginx

------------
### Contributors 👥

FrontEnd:
- Facundo Ibars
- Burella Lucio
- Ramiro Cosa

Backend:
- Diego Haczek







