# Java Chess System

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)

## About the Project

This project is a complete chess game system developed in **Java**, running directly in the console. It was created as a practical application of the concepts learned in the "Java COMPLETO Programação Orientada a Objetos + Projetos" course by [Prof. Dr. Nelio Alves](https://github.com/acenelio) on the Udemy platform.

The system faithfully implements all the fundamental rules of chess, including piece movements, check, checkmate, and special moves like Castling, En Passant, and Pawn Promotion. The project is structured using a layered architecture (Board, Chess, and Application), demonstrating a strong application of Object-Oriented Programming principles.

---

### 💻 Preview

Here is a preview of the game running in the terminal:

<p align="center">
  <img src="https://github.com/KELER147/chess-system-java/blob/main/src/imgs/img.png?raw=true" alt="Legend Preview">
</p>

<p align="center">
  <img src="https://github.com/KELER147/chess-system-java/blob/main/src/imgs/img_1.png?raw=true" alt="Board Preview">
</p>

<p align="center">
  <img src="https://github.com/KELER147/chess-system-java/blob/main/src/imgs/img_2.png?raw=true" alt="Checkmate Preview">
</p>

---

### ✨ Features

- **Layered Architecture:** Organized into `Board`, `Chess`, and `Application` layers.
- **Full Chess Rules:** Implementation of all piece movements and game states.
- **Special Moves Implemented:**
  - Castling
  - En Passant
  - Promotion
- **Clean and Interactive UI:** A user-friendly console interface that displays the board, captured pieces, and turn information.
- **Defensive Programming:** Robust exception handling for invalid moves and user inputs.

---

### 🚀 Technologies and Concepts Applied

This project was a deep dive into core Java and Object-Oriented Programming concepts. The main topics covered were:

- **Fundamentals of Java:**
  - Basic Syntax
  - Control Structures (if/else, for, while)
  - Debugging

- **Object-Oriented Programming (OOP):**
  - **Encapsulation:** Protecting data integrity.
  - **Inheritance and Polymorphism:** Creating a hierarchy of pieces with specific behaviors.
  - **Constructors and Overriding:** (e.g., `toString`).
  - **Abstract Classes and Methods:** Defining a common structure for all pieces.
  - **Enumerations:** (e.g., `Color`).

- **Project Structure:**
  - **Layered Pattern:** Separating responsibilities for better maintainability.
  - **System Design:** Following the structure proposed in the course.

- **Data Structures:**
  - **Matrices:** For representing the game board.
  - **Lists:** To manage captured pieces and pieces on the board.

- **Exception Handling:**
  - Creating and using custom exceptions (`BoardException`, `ChessException`) for robust error management.

---

### How to Run

To run this project, you will need to have the **Java Development Kit (JDK)** installed on your machine.

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/KELER147/chess-system-java.git](https://github.com/KELER147/chess-system-java.git)
    ```

2.  **Navigate to the project directory:**
    ```bash
    cd chess-system-java
    ```

3.  **Compile the Java files:**
    ```bash
    javac -d bin src/application/*.java src/boardgame/*.java src/chess/*.java src/chess/pieces/*.java
    ```

4.  **Run the main application:**
    ```bash
    java -cp bin application.Program
    ```

And the game will start in your console!

---
<p align="center">
  Developed with ♥ by Keler
</p>
