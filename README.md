# Consulta de Precios - README

Este proyecto de consulta de precios se basa en el enunciado proporcionado y utiliza Java 17 y Spring Boot en la versión 3.1.4.

## Configuración del Proyecto

El repositorio del proyecto se encuentra en [GitHub](https://github.com/FranMaster08/zara-challenge.git). Puedes clonarlo o descargarlo desde allí.

Asegúrate de tener Java 17 instalado en tu sistema antes de continuar.

## Compilación y Ejecución

Para compilar y ejecutar la aplicación, sigue estos pasos:

1. Clona o descarga el repositorio desde [GitHub](https://github.com/FranMaster08/zara-challenge.git).

2. Abre un terminal y navega hasta el directorio raíz del proyecto.

3. Utiliza el siguiente comando para compilar y ejecutar la aplicación:

```bash
./gradlew bootRun
```

Esto iniciará la aplicación Spring Boot y la configurará para que se ejecute en el puerto 8080.

## Pruebas del Servicio

Una vez que la aplicación se esté ejecutando, puedes probar el servicio REST utilizando una herramienta como cURL o un cliente HTTP.

### Ejemplo de Petición cURL

Aquí tienes un ejemplo de cómo realizar una petición cURL al servicio de consulta de precios:

```bash
curl -X POST -H "Content-Type: application/json" -d '{
  "applicationDate": "2023-01-14T10:00",
  "productId": "35455",
  "brandId": 1
}' http://localhost:8085/prices/getLatestPrice
```

Asegúrate de ajustar los parámetros de fecha, identificador de producto y identificador de cadena según tus necesidades.

### Documentación de la API

Para obtener más información sobre cómo utilizar la API, puedes consultar la documentación generada automáticamente en la siguiente URL:

[Documentación de la API](http://localhost:8080/swagger-ui/index.html)

## Pruebas Unitarias

El proyecto incluye pruebas unitarias para validar el servicio REST con los escenarios proporcionados en el enunciado. Para ejecutar las pruebas, utiliza el siguiente comando:

```bash
./gradlew test
```

## Detener la Aplicación

Para detener la aplicación Spring Boot, simplemente presiona `Ctrl + C` en el terminal donde se está ejecutando.

## Enunciado del Proyecto

En la base de datos de comercio electrónico de la compañía disponemos de la tabla PRICES que refleja el precio final (pvp) y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas. A continuación se muestra un ejemplo de la tabla con los campos relevantes:

**PRICES**

| BRAND_ID | START_DATE           | END_DATE             | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE | CURR |
|----------|----------------------|----------------------|------------|------------|----------|-------|------|
| 1        | 2020-06-14-00.00.00  | 2020-12-31-23.59.59  | 1          | 35455      | 0        | 35.50 | EUR  |
| 1        | 2020-06-14-15.00.00  | 2020-06-14-18.30.00  | 2          | 35455      | 1        | 25.45 | EUR  |
| 1        | 2020-06-15-00.00.00  | 2020-06-15-11.00.00  | 3          | 35455      | 1        | 30.50 | EUR  |
| 1        | 2020-06-15-16.00.00  | 2020-12-31-23.59.59  | 4          | 35455      | 1        | 38.95 | EUR  |

Campos:

- `BRAND_ID`: foreign key de la cadena del grupo (1 = ZARA).
- `START_DATE` y `END_DATE`: rango de fechas en el que aplica el precio tarifa indicado.
- `PRICE_LIST`: Identificador de la tarifa de precios aplicable.
- `PRODUCT_ID`: Identificador código de producto.
- `PRIORITY`: Desambiguador de aplicación de precios. Si dos tarifas coinciden en un rango de fechas se aplica la de mayor prioridad (mayor valor numérico).
- `PRICE`: precio final de venta.
- `CURR`: iso de la moneda.

Se pide:

Construir una aplicación/servicio en SpringBoot que provea una end point rest de consulta tal que:

- Acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
- Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.

Se debe utilizar una base de datos en memoria (tipo h2) e inicializar con los datos del ejemplo, (se pueden cambiar el nombre de los campos y añadir otros nuevos si se quiere, elegir el tipo de dato que se considere adecuado para los mismos).

