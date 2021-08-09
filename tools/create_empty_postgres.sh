#!/bin/sh
docker run -d --name postgres-db -p 5433:5432 -e POSTGRES_PASSWORD=qwerty -e POSTGRES_USER=postgres -e POSTGRES_DB=spring postgres:alpine
sleep 2
cat init_db.sql | docker exec -i postgres-db psql -U postgres
read -n 1 -s -r -p "Press any key to continue"