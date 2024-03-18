## Nepal Locations APIs
## Getting Started
To run this project, follow these steps:

1. Download IntelliJ IDEA Community or Ultimate version from JetBrains website.
2. Download and install PostgreSQL database on your PC.
3. Ensure you have Java 17 installed on your machine.
4. Clone or download the Spring Boot project.
5. Open the project in IntelliJ IDEA.
6. Create a PostgreSQL database with the name 'nepal_locations'.
7. Update the PostgreSQL database password in the application.Properties file. Locate the datasource section and provide your username and password.


## application.properties

server.port=9988
spring.datasource.url=jdbc:postgresql://localhost:5432/nepal_locations
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true



## API Reference

#### Get All Province

```http
  localhost:9988/api/v1/locations/provinces

[
    {
        "id": 1,
        "name": "Koshi"
    },
    {
        "id": 2,
        "name": "Madhesh"
    },
    {
        "id": 3,
        "name": "Bagmati"
    },
    {
        "id": 4,
        "name": "Gandaki"
    },
    {
        "id": 5,
        "name": "Lumbini"
    },
    {
        "id": 6,
        "name": "Karnali"
    },
    {
        "id": 7,
        "name": "Sudurpashchim"
    }
]
```



#### Get Districts

```http
  localhost:9988/api/v1/locations/districts/5

  [
    {
        "provinceName": "Lumbini",
        "districtId": 47,
        "districtName": "Nawalparasi(Bardaghat Susta West)"
    },
    {
        "provinceName": "Lumbini",
        "districtId": 48,
        "districtName": "Dang"
    },
    {
        "provinceName": "Lumbini",
        "districtId": 49,
        "districtName": "Gulmi"
    },
    {
        "provinceName": "Lumbini",
        "districtId": 50,
        "districtName": "Kapilvastu"
    },
    {
        "provinceName": "Lumbini",
        "districtId": 51,
        "districtName": "Arghakharchi"
    },
    {
        "provinceName": "Lumbini",
        "districtId": 52,
        "districtName": "Palpa"
    },
    {
        "provinceName": "Lumbini",
        "districtId": 53,
        "districtName": "Rukum East"
    },
    {
        "provinceName": "Lumbini",
        "districtId": 54,
        "districtName": "Pyuthan"
    },
    {
        "provinceName": "Lumbini",
        "districtId": 55,
        "districtName": "Banke"
    },
    {
        "provinceName": "Lumbini",
        "districtId": 56,
        "districtName": "Bardiya"
    },
    {
        "provinceName": "Lumbini",
        "districtId": 57,
        "districtName": "Rupandehi"
    },
    {
        "provinceName": "Lumbini",
        "districtId": 58,
        "districtName": "Rolpa"
    }
]
```



#### Error Message

```http
 localhost:9988/api/v1/locations/districts/8
 {
    "status": 404,
    "error": "Not Found",
    "message": "District not found with this Province id: 8"
}
```


#### Get Municipalities

```http
  localhost:9988/api/v1/locations/municipalities/1
[
    {
        "id": 1,
        "name": "Phaktanglung Rural Municipality",
        "districtName": "Taplejung"
    },
    {
        "id": 2,
        "name": "Maiwakhola Rural Municipality",
        "districtName": "Taplejung"
    },
    {
        "id": 3,
        "name": "Meringden Rural Municipality",
        "districtName": "Taplejung"
    },
    {
        "id": 4,
        "name": "Mikawakhola Rural Municipality",
        "districtName": "Taplejung"
    },
    {
        "id": 5,
        "name": "Phungling Municipality",
        "districtName": "Taplejung"
    },
    {
        "id": 6,
        "name": "Serijdangha Rural Municipality",
        "districtName": "Taplejung"
    },
    {
        "id": 7,
        "name": "Sidingwa Rural Municipality",
        "districtName": "Taplejung"
    },
    {
        "id": 8,
        "name": "Yangwarak Rural Municipality",
        "districtName": "Taplejung"
    },
    {
        "id": 9,
        "name": "Aatharai Triveni Rural Municipality",
        "districtName": "Taplejung"
    }
]

```


