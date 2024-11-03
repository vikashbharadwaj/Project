## Working on it....

# BankIt

BankIt is a full-featured banking system developed using Java and Spring Boot. It offers essential banking operations like credit, debit, and transfer to manage transactions efficiently. The system includes automated email notifications for each transaction, providing users with real-time updates. Additionally, users can access transaction history and receive PDF statements via email, enhancing account management.

## Features

- **Transaction Management**: Perform essential banking operations like **credit**, **debit**, and **fund transfer**.
- **Real-Time Notifications**: Automated email alerts for every transaction, giving users instant updates.
- **Transaction History**: View past transactions and generate statements.
- **PDF Statements**: Generate and email PDF statements directly to the user.

## Tech Stack

- **Java** with **Spring Boot** for building a robust backend
- **Maven** for dependency management
- **JPA (Java Persistence API)** for database interaction
- **MySQL** for data storage

## Project Structure

- **Controllers** (`/Controllers`)
  - Handle incoming requests and map them to appropriate services.
  - Example: `UserController` handles account creation, balance enquiry, credit, debit, and transfer operations.

- **DTO (Data Transfer Objects)** (`/DTO`)
  - Define request and response structures for data exchange.
  - Examples: `UserDTO`, `CreditDebitRequest`, `EnquiryRequest`, `Transfer`.

- **Services** (`/Services`)
  - Core business logic for banking operations.
  - Example: `UserService` implements the logic for creating accounts, balance enquiry, credit, debit, and transfer.

- **Repositories** (`/Repositories`)
  - Data access layer that interacts with the database.
  - Example: `UserRepository` extends `JpaRepository` and provides methods to manage user accounts and transactions.

- **Entities** (`/Entities`)
  - Define database tables and relationships.
  - Examples: `User` and `Transaction` entities representing database tables for users and transactions.

## How to Run

### Prerequisites

- **Java 11** or higher
- **Maven** for managing dependencies
- **MySQL** database server

### Setup Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/BankIt.git
   cd BankIt

2. **Configure Database**
- Create a MySQL database named `bankit_db`.
- Update the database configuration in `src/main/resources/application.properties` with your MySQL username and password:

  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/bankit_db
  spring.datasource.username=YOUR_USERNAME
  spring.datasource.password=YOUR_PASSWORD```

 3. **Configure Mail Server**
- To send email notifications, configure the mail server settings in `src/main/resources/application.properties`:

  ```properties
  spring.mail.host=smtp.example.com
  spring.mail.port=587
  spring.mail.username=YOUR_EMAIL@example.com
  spring.mail.password=YOUR_EMAIL_PASSWORD
  spring.mail.properties.mail.smtp.auth=true
  spring.mail.properties.mail.smtp.starttls.enable=true
  spring.mail.from=YOUR_EMAIL@example.com
  ```
- Replace `smtp.example.com`, `YOUR_EMAIL@example.com`, and `YOUR_EMAIL_PASSWORD` with your SMTP server details and credentials.

 4. **Install Dependencies**

      ``` bash
         mvn install
      ```
 5. **Run the Application**

      ```bash
         mvn spring-boot:run
      ```
      
## Contributing

Contributions are welcome! Please fork this repository and submit a pull request for any enhancements or bug fixes.


