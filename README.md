##Evaluación de Previred

##Presentación:
Nombre: Carlos Contreras Salas
Email: carlos.contreras.salas@gmail.com
Me enteré de este desafío por una entrevista con Leonardo Miranda de Tech Consult

## Para Poder compilar este desafío se debe realizar una de las siguientes opciones:

1) Abrir un un editor de Spring Boot y correr.
2) Abrir una terminal en la carpeta que contiene el proyecto y ejecutar con Maven:
  - mvn clean package (esto limpiara y posteriormente compilara creando la carpeta target)
  - ingresar a la carpeta target con cd target y ejecutar:
    java -jar .\api-periodos-1.0.0.jar

Nota: Antes de llamar al servicio debe correr la Api Rest Del GDD.

## URL de servicio de la Api Rest

1) Abrir en un navegador o postman o insomnia la siguinte URL: _http://localhost:8081/api/faltantes_
2) Para ver el Swagger debe ingresar a:  _http://localhost:8081/swagger-ui/index.html_ 
   y también a _http://localhost:8081/v2/api-docs_ 

##Se adjunta el archivo de ejemplo-response.json que es la respuesta del servicio en mi local
    {
        "id": 1,
        "fechaCreacion": "1987-07-01",
        "fechaFin": "2015-07-01",
            "fechas": [
            "1987-09-01",
            "1987-10-01",
            "1987-12-01",
            "1988-02-01",
            ...
            ],
            "fechasFaltantes": [
            "1987-07-01",
            "1987-08-01",
            "1987-11-01",
            ....
            ]
    }
