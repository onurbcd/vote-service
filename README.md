# Vote Service
Voting Sessions Manager.

## Postgres in Docker

```
docker run -p5432:5432 --name postgres -e POSTGRES_PASSWORD=secret -e POSTGRES_USER=admin -e POSTGRES_DB=vote-service-dev -d postgres:latest
```
