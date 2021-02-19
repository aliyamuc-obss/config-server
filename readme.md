### Run postgres
docker pull postgres:13.2
docker run --name workshop-postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres

### Check config server for property source
curl localhost:8080/bar/dev

### It should be like this
{"name":"bar","profiles":["dev"],"label":null,"version":null,"state":null,"propertySources":[{"name":"class path resource [configs/bar-dev.properties","source":{"role":"developer"}}]}

### Check return value of RESTful API after bootstraping
curl localhost:8081/role 

### It should be like this
developer

### Change value of "role" in bar-dev.properties as "super developer" and restart config-server

### Refresh the client to pull the latest config param changes
curl localhost:8080/actuator/refresh -d {} -H "Content-Type: application/json"

### It should be like this
["role"]

### Check return value of RESTful API after config param change
curl localhost:8081/role

### It should be like this
super developer


