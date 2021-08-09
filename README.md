<h1 align="center"> Chatter </h1> <br>

<p align="center">
  Simple web chat on java
</p>


## Table of Contents

- [Introduction](#introduction)
- [Requirements](#requirements)
- [Quick Start](#quick-start)

## Introduction

This simple web application on java for chatting is made using the spring framework and Websocket technology. Access to the chat is provided after registration. All users are stored in PostgreSQL, messages in mongoDB.


## Requirements
The application can be run locally or in a docker container, the requirements for each setup are listed below.

### Local
* [Java 11 SDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
* [Gradle 6.3 and later](https://docs.gradle.org/6.3/release-notes.html)
* [Docker](https://www.docker.com/get-docker) (for creating databases)


### Docker
* [Docker](https://www.docker.com/get-docker)


## Quick Start

### Configure Acess data for databases
Update __application.properties__. Set `username` `password` and other parametres for mongoDB and postgreSQL databases.

The default value in the __application.properties__ file is set to connect to postgreSQL with user `postgres` and password `qwerty` on port `5433`. For mongoDB with user `mongo` and password `qwerty` on port `27018`. Default port on web server `8080`.

### Run Local

Run the databases using shell scripts.(They use docker).

Migrations for postgreSQL will be installed automaticly by Flyway

```bash
$ ./tools/create_empty_postgres.sh
$ ./tools/create_empty_mongodb.sh
```
Run application
```bash
$ gradle bootRun
```
Application will run by default on port `8080`

Configure the port by changing `server.port` in __application.properties__


### Run Docker

First build the image:
```bash
$ docker build -t chatter .
```

When ready, run it:
```bash
$ docker run -p 8080:8080 chatter
```

Application will run by default on port `8080`
