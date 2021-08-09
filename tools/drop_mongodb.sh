#!/bin/sh
docker container stop mongodb-db
docker container rm mongodb-db
read -n 1 -s -r -p "Press any key to continue"