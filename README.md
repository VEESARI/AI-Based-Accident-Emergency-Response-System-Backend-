# SafeRoute AI — Spring Boot backend

Academic prototype for accident-report intake and response-status tracking.

## Requirements
- Java 17 or later
- MySQL 8.x
- Maven (or add the Maven Wrapper in your IDE)

## 1. Create the database
In MySQL Workbench or a MySQL terminal:

```sql
CREATE DATABASE accident_response_db;
```

## 2. Configure credentials
Edit `src/main/resources/application.properties`, or set environment variables:

```bash
export DB_URL='jdbc:mysql://localhost:3306/accident_response_db?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC'
export DB_USERNAME='root'
export DB_PASSWORD='your_mysql_password'
```

Do not commit passwords to a public repository.

## 3. Start backend
From this folder:

```bash
mvn spring-boot:run
```

The API runs at `http://localhost:8080`.

## Main endpoints
- `GET /api/accidents`
- `GET /api/accidents/{id}`
- `POST /api/accidents`
- `PATCH /api/accidents/{id}/status`
- `GET /api/dashboard/stats`
- `GET /api/hospitals`
- `GET /api/hospitals/nearby?lat=17.385&lng=78.4867`
- `GET /actuator/health`

Example POST JSON:

```json
{
  "reporterName": "Demo User",
  "location": "Madhapur, Hyderabad",
  "latitude": 17.4483,
  "longitude": 78.3915,
  "accidentType": "Vehicle collision",
  "peopleAffected": 2,
  "injuries": "Injury reported",
  "emergencyRequired": "Ambulance",
  "description": "Demo record only"
}
```

## Important scope notes
- The severity output is a transparent educational rule-based estimate, not a trained or clinically validated AI model.
- The hospital nearby endpoint currently returns records with coordinates; actual distance ranking, live bed availability, dispatch, and notifications are not implemented.
- No login/registration endpoints are implemented in this starter version. Do not expose it publicly or use it for real emergency dispatch without adding authentication, authorization, privacy controls, testing, and verified integrations.
- Do not use demo data as real emergency information.
