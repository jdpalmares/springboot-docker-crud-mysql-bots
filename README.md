# springboot-docker-crud-mysql-bots
Spring Boot Docker MySQL Simple CRUD Service Bot

Goal: Create a REST service to do CRUD operations on the database table that docker-compose sets up

The operations we'd like to see supported are 
 - List, lookup, and add new attacks
 - List, lookup and add new bots
 - Find attacks in a particular date range
 - When displaying an attack, list the bot names that participated
 
## Requirements
 - Use the provided MySQL database
    - `jdbc:mysql://mysqldb:3306/optic_data?useSSL=false`
    - Username and password are both `spring`
 - Use Spring boot to build your app/service. You can use whatever libraries and build system you like.
 - Add your Spring service to docker-compose.yaml so that it starts on `docker compose up --build` and is available on port 8080
 
## Schema

There are three tables we've already created for you to use:
 - bots: Defines a bot
    - `id` INT AUTO INCREMENT
    - `name` VARCHAR
 - attacks: Defines an attack
     - `id` INT AUTO INCREMENT
     - `site` VARCHAR
     - `attack_date` DATE
 - attack_bots: Defines the bots that participated in an attack
    - `bot_id` INT
    - `attack_id` INT