Spring Reward Application
This repository contains the source code for the Spring Reward Application. This application is designed to manage users, transactions, and redemptions within a reward system. Users can create accounts, log in, perform transactions, and redeem rewards. The application is built using Spring Boot.

Table of Contents
Installation
Usage
API Endpoints
User Endpoints
Transaction Endpoints
Redemption Endpoints
Notes
Contributing
License
Installation
Prerequisites
Java 8 or higher
Maven
Spring Boot
Steps
Clone the repository

bash
Copy code
git clone https://github.com/username/spring-reward-application.git
cd spring-reward-application
Build the application

bash
Copy code
mvn clean install
Run the application

bash
Copy code
mvn spring-boot:run
The application will start on http://localhost:8080.

Usage
Once the application is running, you can interact with the API using tools like Postman or curl.

API Endpoints
User Endpoints
Create User

http
Copy code
POST /createUser
Request Body

json
Copy code
{
    "username": "string",
    "password": "string",
    "email": "string"
}
Response

json
Copy code
{
    "id": "string",
    "username": "string",
    "email": "string",
    "createdAt": "string"
}
Login User

http
Copy code
POST /LoginUser
Request Body

json
Copy code
{
    "username": "string",
    "password": "string"
}
Response

json
Copy code
{
    "id": "string",
    "username": "string",
    "email": "string",
    "loggedInAt": "string"
}
Sign Out

http
Copy code
POST /signOut
Response

json
Copy code
{
    "message": "User signed out successfully"
}
Transaction Endpoints
Create Transaction

http
Copy code
POST /Transaction/{amount}
Path Variable

amount: The amount for the transaction.
Response

json
Copy code
{
    "transactionId": "string",
    "amount": "number",
    "transactionDate": "string"
}
Get Transaction History

http
Copy code
GET /TransactionHistory
Response

json
Copy code
[
    {
        "transactionId": "string",
        "amount": "number",
        "transactionDate": "string"
    },
    ...
]
Redemption Endpoints
Redeem Item

http
Copy code
POST /Redem/{name}
Path Variable

name: The name of the item to redeem.
Response

json
Copy code
{
    "redemptionId": "string",
    "itemName": "string",
    "redemptionDate": "string"
}
Get Redemption History

http
Copy code
GET /RedemHistory
Response

json
Copy code
[
    {
        "redemptionId": "string",
        "itemName": "string",
        "redemptionDate": "string"
    },
    ...
]
Notes
Users must be logged in to perform transactions and redemptions.
Contributing
Contributions are welcome! Please open an issue or submit a pull request.
