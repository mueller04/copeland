# Copeland

Copeland is a practice application for obtaining real time weather data.

## Installation

Use gradle to install copeland

```bash
./gradlew build
```
## Usage

```bash
# start the server
./gradlew bootrun

# unit test
./gradlew test
```

Use a REST client of your choice such as:

[postman](https://www.postman.com/downloads/)

use http://localhost:8080/weather for the url

required params

* appid - the api key provided to you

supply at least one optional param. These are in order or precedence.  lon and lat must be supplied together.

* lon
* lat
* city
* zip

