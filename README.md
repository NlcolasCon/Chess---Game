# Chess Game (Java)

A fully object-oriented implementation of the **classic Chess game** in Java.  
This project models chess pieces, their movement rules, and board validation, while demonstrating modular design and clean class hierarchy.

---

## Project Explanation
This project simulates chess on an `8x8` board using **OOP principles**.  
Each piece is modeled as a class with its own unique movement logic.  
Custom exceptions and utility classes ensure valid board operations and error handling.

### Core Components
- **Piece (Abstract Class)**  
  - Base class for all chess pieces.  
  - Defines color, position, and movement validation.
- **Concrete Pieces**  
  - `Pawn`, `Knight`, `Bishop`, `Rook`, `Queen`, `King`  
  - Each implements its unique movement rules.
- **Square**  
  - Represents a position on the chessboard.
- **Color**  
  - Enum-like class: `WHITE` and `BLACK`.
- **InvalidSquareException**  
  - Custom exception for invalid board references or illegal moves.
- **ChessMain**  
  - Entry point of the program, initializes the game and board.
- **ChessTest**  
  - Unit testing and validation of move logic.

---

## Repository Structure
Chess-Game/
┣ src/
┃ ┣ Piece.java
┃ ┣ Pawn.java
┃ ┣ Knight.java
┃ ┣ Bishop.java
┃ ┣ Rook.java
┃ ┣ Queen.java
┃ ┣ King.java
┃ ┣ Color.java
┃ ┣ Square.java
┃ ┣ ChessMain.java
┃ ┣ ChessTest.java
┃ ┗ InvalidSquareException.java
┣ LICENSE
┣ README.md

---

## Features
- Models all standard chess pieces with correct movement rules
- Validates moves with exceptions for invalid squares
- Encapsulated board logic via `Square` and `Piece`
- Clean **object-oriented design** with modular class structure
- Ready for extension (e.g., checkmate detection, game state tracking)

---

## Technologies
- Language: Java
- Paradigm: Object-Oriented Programming
- Tools: Any Java IDE (Eclipse, IntelliJ IDEA, VS Code)

---

## Author
- Developed by Nicolas Constantinou
- 2025

---

## Usage

### Compile:
```bash
javac src/*.java -d bin
java -cp bin ChessMain
