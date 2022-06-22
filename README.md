"# micro-afiliaciones" 
## Prueba técnica para desarrollador backend
### ¿Qué se desea?

Implementar una aplicación web orientada a microservicios REST que contenga lo
siguiente.

- CRUD de afiliados.

- CRUD de casos.

- Cobertura de pruebas unitarias al 80%

- Persistencia en base de datos.


### Plus del ejercicio

- Api que permita búsqueda por filtros.

- Un filtro que mezcle fechas con la tabla afiliados.

- Manejo de excepciones y errores.

- Documentación de Api ́s con Swagger.

## Solución Propuesta

Para la actividad planteada se decidió desarrollar 2 microservicios, los cuales son los siguientes:

- afiliados: Este microservicio es el encargado de todas las operaciones que se realizan
sobre la tabla de afiliados en la base de datos. Podemos encontrar las operaciones CRUD
(Create, Read, Update, Delete) y algunos filtros de búsqueda como por ejemplo obtener
un afiliado por Id, por numero de identificación, por usuario de creación y por un intervalo
que filtra los afiliados que fueron creados entre una fecha inicial y una fecha final.

- casos: De manera similar al ms-afiliados, este microservicio esta encargado de realizar
todas las consultas y operaciones sobre la tabla de casos en la base de datos. Podemos
realizar operaciones CRUD (Create, Read, Update, Delete) y filtrar nuestras búsquedas por
el Id del caso, usuario de creación, el Id del gestor del caso y de igual manera contamos
con un filtro para obtener los casos cuya fecha de inicio de caso se encuentre entre un
intervalo de una fecha inicial y una fecha final.
### Swagger:

- ms-afiliados: http://localhost:8080/swagger-ui.html#/afiliados-controller
- ms-casos: http://localhost:8080/swagger-ui.html#/caso-controller

Finalmente, es necesario probar nuestra aplicación, para debemos desarrollar pruebas unitarias que
se encarguen de verificar que cada una de nuestras líneas de código escritas funcionen como lo
deben hacer. JUnit es la tecnología que nos ayuda a escribir y configurar nuestras pruebas unitarias,
estas las podemos encontrar en el paquete de ‘test’ y están separadas para los controladores y para
los servicios, ya que, estos requieren de una configuración diferente, en los controladores se deben
simular peticiones a nuestro servidor y en los servicios, se debe hacer llamado de los métodos
creados. Con alguna herramienta de análisis de código estático, se asegura que las pruebas unitarias
desarrollados cuentan con un porcentaje de cobertura mínimo de 80%, esto para asegurar que
escribimos un código de calidad y que cumple con la función para el cual fue desarrollado.
![casos](https://user-images.githubusercontent.com/58458106/174944099-999883fa-2751-4f6b-9cc8-4222157b8920.png)
![afiliaciones](https://user-images.githubusercontent.com/58458106/174944101-e6f68dda-52d7-49ab-810f-93a62dfa6cfb.png)

