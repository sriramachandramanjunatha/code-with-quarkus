# code-with-quarkus
code-with-quarkus
./mvnw compile quarkus:dev
./mvnw quarkus:add-extension -Dextension="rest-jackson,jdbc-h2,hibernat
e-orm-panache,smallrye-openapi"
./mvnw quarkus:add-extension -Dextension="spring-web,spring-data-jpa"
./mvnw quarkus:add-extension -Dextension="smallrye-fault-tolerance"
./mvnw quarkus:add-extension -Dextension="smallrye-health"
./mvnw quarkus:add-extension -Dextension="opentelemetry"

POST
http://localhost:8080/movie
{
  "title": "SriRama SaiRama!",
  "releaseDate": "1980-05-17"
}

GET
http://localhost:8080/movie?year=1980
http://localhost:8080/movie


GET
http://localhost:8080/coffee
http://localhost:8080/coffee/{id}/recommendations
	eg: http://localhost:8080/coffee/3/recommendations
http://localhost:8080/q/health
http://localhost:8080/health
http://localhost:8080/health/ready