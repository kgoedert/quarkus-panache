# What

Very simple crud application using [quarkus](www.quarkus.io) to manage movies and their actors contact information

# Why

To test quarkus with panache extension.

# Database

To build the dabase image:

```
cd src/main/docker/postgres
docker build -t postgres .
```

In src/main/docker/postgres there is a Dockerfile to run a postgres database. You can run it with:

```
docker run -e POSTGRES_PASSWORD=mysecretpassword -v <path to postgres data folder>:/var/lib/postgresql/data -p 5432:5432 postgres
```

To configure the database in the application go to `src/main/resources/application.properties`

# Run quarkus in dev mode

```
./mvnw compile quarkus:dev
```

The post related to this code can be found [here](https://dev.to/kgoedert/getting-started-with-quarkus-and-panache-5b5b)
