## Getting Started

Welcome to the Quantum Bookstore project! This project is designed to manage an online bookstore, providing functionalities for different types of books, inventory management, and testing capabilities.

## Folder Structure

The workspace contains the following structure:

- `src`: the folder to maintain source files
  - `App.java`: The entry point of the application.
  - `Book.java`: Defines the abstract class for books.
  - `EBook.java`: Extends the Book class for electronic books.
  - `PaperBook.java`: Extends the Book class for physical books.
  - `Inventory.java`: Manages the collection of books.
  - `QuantumBookstoreFullTest.java`: Contains tests for the bookstore functionalities.
  
- `lib`: the folder to maintain dependencies.

- `.vscode`: contains configuration settings for the Java project.

## Functionality Overview

The Quantum Bookstore project includes:

- **Book Management**: Support for both electronic and physical books, with properties such as ISBN, title, year, price, and author name.
- **Inventory Management**: Ability to add, remove, and manage books in the inventory, ensuring accurate tracking of stock.
- **Testing**: A dedicated testing class to verify the functionality of the bookstore, ensuring that all operations work as expected.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Setup Instructions

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Ensure that you have the necessary Java SDK installed.
4. Build the project and run `App.java` to start the application.

Feel free to explore the code and contribute to the project!