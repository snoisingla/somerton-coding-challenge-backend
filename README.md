# somerton-coding-challenge-backend

## Step 1: Install and setup PostGres :

1. Install psql
2. Create username `postgres` and password `admin`
3. Create database `somerton` and connect to this database

```
> psql -U postgres
> admin
> create database somerton
> \connect somerton
```

## Step 2: Run service using Eclipse IDE :

1. Download and install Eclipse Java EE IDE for Web Developers.
2. Clone this project `somerton-coding-challenge-backend`
3. Run Eclipse. Go to File -> Import -> Maven -> Existing Maven Projects and select the cloned folder
4. Use Eclipse -> Run to start the server
