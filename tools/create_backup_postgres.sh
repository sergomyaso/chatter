docker exec -t postgres-db pg_dumpall -c -U postgres > ./dump_`date +%d-%m-%Y"_"%H_%M_%S`.sql
