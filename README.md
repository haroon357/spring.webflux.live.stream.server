this is a simple demo project that get Customer data from PostgreSQL database in a reactive way using Flux
and then return this data as live stream Flux with  MediaType.TEXT_EVENT_STREAM_VALUE

**How To Run**
* run postgres docker image loacally form https://hub.docker.com/_/postgres
* connect to postgreSQL and create tables as per ...resources/sql/schema.sql
* ensure the database port and user/password are correct in .../resources/application.yaml
* run your application and it will start at default port 8080
* use ttp://localhost:8080/load?count=100 to load test data in customer table
* you check your server side application is working by running curl http://localhost:8080/customer

Note: In order to see how to consuem this TEXT_EVENT_STREAM using non-blocking webcleint please see https://github.com/haroon357/spring.webflux.live.stream.client