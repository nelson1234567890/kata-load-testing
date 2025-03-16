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

