# Contact Sphere

The Contact Sphere is a web application built with Spring Boot, Thymeleaf, and PostgreSQL, providing users with the ability to store and access their family or friend's contact information from anywhere.

Access the Contact Sphere [here](https://contactsphere-13bt.onrender.com).

## Features

- **User Authentication**: Users can register, log in, and securely manage their contacts.
- **CRUD Operations**: Create, read, update, and delete contact information.
- **Responsive UI**: Thymeleaf templates ensure a responsive and user-friendly interface.
- **Database Storage**: PostgreSQL database is used to persist contact details.
- **Security**: User authentication and authorization to ensure data privacy.

## Technologies Used

- **Backend**: Java with Spring Boot
- **Frontend**: Thymeleaf for server-side templating
- **Database**: PostgreSQL
- **Build Tool**: Maven

## Prerequisites

- Java Development Kit (JDK)
- PostgreSQL Database
- Maven Build Tool

## Setup and Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/nirdesh17/contact-manager.git
2. **Configure PostgreSQL**: 
Create a new database and user for the Contact Manager application.
3. **Update application.properties**:
Open `src/main/resources/application.properties` and configure the database connection properties.
    ```bash
    spring.datasource.url=your_database_url
    spring.datasource.username=your_database_username
    spring.datasource.password=your_database_password

4. **Build and Run**:
    ```bash
    mvn spring-boot:run
5. **Access the application**:
Open a web browser and visit `http://localhost:8081`.

## Usage
1. Register a new account or log in if you already have one.
2. Use the navigation to manage your contacts (add, edit, delete).
3. Log out when done.


## Contributing
Feel free to contribute to the development of this extension. Create a pull request with your improvements, bug fixes, or new features.

### Connect me:
[Linkedin](https://www.linkedin.com/in/nirdesh-devadiya-55b408209)
