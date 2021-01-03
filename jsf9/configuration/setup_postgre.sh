docker volume create --name=pgdata
docker run -d -P --name postgresql --mount 'type=volume,src=pgdata,dst=/var/lib/postgresql/data,volume-driver=local' -e POSTGRES_PASSWORD=YOURPW -p 54321:5432 postgres:latest
