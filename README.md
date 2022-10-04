# Cardstalker

## Introduction
Monitoring cardmarket and notify user of new best prices

## Local Setup

```
git clone git@github.com:TheGor1lla/cardstalker.git
cd cardstalker
docker-compose up -d
./mvnw spring-boot:run
```

## Authentication

The credentials for the user can be configured via the `application.yml`:

```yaml
app:
  username: gor1lla
  password: gor1lla
  role: USER
```