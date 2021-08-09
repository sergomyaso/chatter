#!/bin/sh
docker run -d --name mongodb-db -p 27018:27017 -e MONGO_INITDB_ROOT_USERNAME=mongo -e MONGO_INITDB_ROOT_PASSWORD=qwerty mongo
read -n 1 -s -r -p "Press any key to continue"