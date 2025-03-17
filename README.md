## Descripcion
Este es el proyecto de pruebas de carga, se construyo usando gatling con el api de java.

En la carpeta test, dentro del paquete testApisLoad veras las clases con las ejecuciones de modelo abierto y cerrado.
## Funcionamiento
Para ejecutar el proyecto localmente hay que correr el comando
```
mvn gatling:test
```
Esto ejecutara las pruebas declaradas en el paquete de testApisLoad, y guardara el reporte en la ruta target/gatling/


## importante
Esta ejecucion se realiza automaticamente gracias al pipeline integrado en el proyecto, la ejecuion tambien puede desencadenarse manualmente.
El reporte, al igual que el proyecto de apis, se genera como un artefacto que puedes descargar desde el apartado de actions de github.

-Sobre los modelos abiertos y cerrados, se agrego ademas una duracion de 30 y 10 segundos para ver el comportamiento de un flujo de clientes en ese margen de tiempo

-Sobre el aviso de actualizacion de version de gatling en el reporte, la version de la dependencia propuesta existe, pero al integrarse con el plugin falla la compilacion para las diferentes versiones desde las 3.10 hasta la 3.13 , entonces para poder relaizar la ejecucion con el pluguin usando la version 4.2.6, es necesario usar la version de la dependencia 3.9.5

