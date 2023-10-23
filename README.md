# Demo Spring Boot
### Require:
* Text Editor or IDE (VScode or IntelliJ)
* Docker 
* Postman
---
### Run Application
 * Before run application, you need to run database first with command :

    ```bash
    docker-compose up -d
    ```

* After that, access to database container:
    ```bash
    docker exec -it postgres bash
    ```
    or You can access database with any tools can connect to Postgresql
    <br>
    <br>
* To login into Postgresql, copy this to your terminal :
    ```
    psql -U root -W
    ```
    And type `password` for Postgresql password
    <br>
    <br>

* Next, create your own database name student:
    ```sql
    create database student;
    ```
* Finally, open your IDE and run application

---
### Check data in Postgresql by Terminal
* Access to Postgresql in docker container
* Next, copy this command to use *student database*:
    ```bash
    \c student
    ```
    And type `password` for Postgresql password
    <br>
    <br>
* Then you can use SQL to Query Data :
    ```sql
    SELECT * FROM student;
    ```
    