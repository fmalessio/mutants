# Proyecto de detección de mutantes

Tecnologías utilizadas Java, Spring boot, JPA, MVC, Amazon Web Services (AWS) y MySQL.

## Local
Para ejecutar la aplicación en el ambiente local debemos ir hasta la clase "MutantsApplication" en el paquete "com.fmalessio.mercadolibre.Mutants", luego click derecho sobre la clase "Run as" -> "Java application".

Luego, desde cualquier cliente HTTP (Postman recomendado), se podrán ejecutar los [endpoints](#endpoints) utilizando la URL:

	- http://localhost:8080

## Deployado sobre AWS

Se podrán ejecutar los [endpoints](#endpoints) utilizando la URL:

	- http://mutants-prod.sa-east-1.elasticbeanstalk.com
	
## Base de datos

Se utiliza una base de datos relacional MySQL:

	- mutantsdb.cbmkeepkk0bf.sa-east-1.rds.amazonaws.com

Comentarios:
Los DNA serán únicos por individuo (mutante o humano), por lo tanto las cadenas que adn se concatenan con "-" y se guardan como un identificador.
Para más detalles revisar la entidad: "Dna.java" en el paquete "com.fmalessio.mercadolibre.Mutants.entity"

Esquema:
Nombre de la base de datos: "mutantsdb".
2 Comlumnas: dna (string), is_mutant (boolean).
"dna" será el ID, por ejemplo: "ATGCGA-CAGTGC-TTATGT-AGAAGG-CCCCTA-TCACTG".

### Endpoints

API Resources, Request & Response

  - [GET /testApi](#get-testapi)
  - [POST /mutant](#post-mutant)
  - [GET /stats](#get-stats)

### GET /testApi

El objetivo de este endpoint es poder verificar que la aplicación este funcionando correctamente.
El parámetro "name" define a quién saludará la aplicación como respuesta, el valor por defecto es "World".

Ejemplo:
- Request:
	
```json
	/testApi?name=Mutant
```

- Response:

```json
	Hello Mutant!
```
	
### POST /mutant

* 200 - OK --> Si es un mutante
* 403 - Forbidden --> Si es un humano
* 400 - Bad Request --> Si el DNA enviado no es correcto

Ejemplo 1 - Mutante:

- Request:

```json
	/mutant
```

- Headers:

```json
	Content-Type: application/json
```

- Request body:

```json
	{ "dna": ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"] }
```

- Response:

```json
	[Status 200 OK]
```
	
Ejemplo 2 - No mutante:

- Request body:

```json
	{ "dna": ["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"] }	
```
	
- Response:

```json
	[Status 403 Forbidden]
```

- Response body:

```json
	{
	    "timestamp": "2018-09-23T21:30:09.727+0000",
	    "status": 403,
	    "error": "Forbidden",
	    "message": "Is not a mutant",
	    "path": "/mutant"
	}
```

### GET /stats

Devuelve un Json con las estadísticas de las verificaciones de ADN.

Ejemplo:
- Request:
	
```json
	/stats
```

- Response body:

```json
	{
	    "count_mutant_dna": 1,
	    "count_human_dna": 2,
	    "ratio": 0.5
	}
```