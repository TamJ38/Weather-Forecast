# Weather-Forecast

## Technologies Used

- Java, Spring Boot
- MySQL
- REST API (OpenWeatherMap)
- JavaScript (AJAX), HTML, CSS
- JSON

---

## Features

- Fetches weather data for 3 cities: Skopje, Ohrid, and Pehchevo
- Stores 16-day forecast in a MySQL database
- Analyzes and marks:
    - Days with temperatures above 25°C
    - Rainy days (if applicable)
- Exposes REST endpoints to access forecast data
- Display results on a responsive web page

---

## Steps

### 1. Clone the Repository

```bash
git clone https://github.com/TamJ38/Weather-Forecast.git
cd Weather-Forecast
```
---

### 2. Set Up the Database

- Create a MySQL database (weather_db)

---

### 3. Configure Properties

- Copy the data from the example configuration file (application.properties.example) to your application.properties file
- Update the following
  ```bash
  spring.datasource.username=your_mysql_user
  spring.datasource.password=your_mysql_password
  weather.api.key=41579da2c77f961738ade68b9bcecec5
  ```

---
  
### 4. Run the application

```bash
./mvnw spring-boot:run
```

---

### 5. Api Endpoints

- POST: /api/forecast/fetch - fetch and store forecast from API
- GET: /api/forecast - get all forecasts
- GET: /api/forecast/above25 - get all days with temperature > 25°C
- GET: /api/forecast/rainy- get all rainy days
- GET: /api/forecast/above25/{city} - get hot days by city
- GET: /api/forecast/rainy/{city} - Get rainy days by city

---

### 6. Frontend

```bash
http://localhost:8080/index.html
```