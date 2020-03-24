#  IMDB for books

We want to create an application for all books in the world. In the application you can rate books. You can filter and sort as you like to find the most suitable book for you to read.

Build book recommender system.

Your part is to develop API on Java and using Spring framework. This time you will not concentrate on visual part, only REST API implementation, so that other developers can use your developed API.

## Getting started

Go to [https://bitbucket.org/sergeipojev/test-assignment-junior](https://bitbucket.org/sergeipojev/test-assignment-junior) and fork this repository to your own one. Afterwards, clone your repository to machine and open project in your preferable IDE as Maven project.

When all maven dependencies are downloaded, make sure that you can run application. Proceed to BooksApplication class and in context menu, select _Run…_ It will run local server. When Spring Context is loaded, proceed to **localhost:8080/heartbeat** , where you should get "OK". It will mean, that server is up and running.

As it turned out, some of the API functionality is already done for you. If you will check the sources, you will see, that all required entities are in place and should not be changed. Application is already using H2 (in-memory) database, which is accessible from **localhost:8080/h2-console**. Your job is to finish the task.

As there is not much data inserted in database, please add more entries to existing DB. You can do so by adding additional insert statements to **data.sql** file located under resources package.

Use Postman application to test your developed REST endpoints.

## Requirements

- REST endpoints for CRUD operations for **Book** domain.
- REST endpoint to add rating by book ISBN.
- REST endpoint to get all books with rating.
- REST endpoint to get book by ISBN with rating.
- REST endpoint to get ranking of books (top 10, top 50, top 100)

Mandatory technology stack:

- Java 11+
- Maven
- Use H2 Database (as preconfigured)

Bonus points:

- Logging (log4j)
- Using Lombok
- Business logic (if such exists) covered with Junit` tests.

If you see, that current implementation is too hard or not correct, feel free to change it.

Provide us source code along with installation and execution instructions via email.

Do not hesitate to send us even partly completed assignment.