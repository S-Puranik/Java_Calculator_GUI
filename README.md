 Smart Calculator - Java GUI Project
Overview
Smart Calculator is a Java-based GUI application developed using Swing that combines multiple calculation utilities into a single platform. It includes a standard calculator, scientific calculator, and a multi-category unit converter.
The goal of this project is to provide a unified, user-friendly tool for performing everyday calculations and conversions efficiently.
________________________________________
Features
 Standard Calculator
•	Basic arithmetic operations: +, −, ×, ÷
•	Error handling (e.g., divide by zero)
•	Clear (C) functionality
 Scientific Calculator
•	Trigonometric functions: sin, cos, tan
•	Logarithmic function (log)
•	Square root, square (x²), reciprocal (1/x)
•	Degree to radian conversion for trig functions
 Unit Converter
Supports multiple categories:
•	Length (meter, kilometer, centimeter)
•	Weight (gram, kilogram)
•	Temperature (Celsius, Fahrenheit)
•	Area (square meter, square kilometer)
•	Volume (liter, milliliter)
•	Speed (m/s, km/h)
________________________________________
 Concepts Used
•	Java Swing (GUI development)
•	Object-Oriented Programming (OOP):
o	Encapsulation
o	Modularity
•	Event Handling (ActionListener)
•	Exception Handling
•	Package-based project structure
________________________________________
 Project Structure
src/ └── calculator/ ├── main/ # Entry point (Main.java) ├── ui/ # GUI components (CalculatorUI.java) ├── core/ # Core logic (StandardCalculator.java) ├── converter/ # Conversion logic (future scalable module) └── utils/ # Utility/helper classes
________________________________________
 How to Run
1.	Open terminal in project directory
2.	Navigate to src folder:
cd src
3.	Compile:
javac calculator/ui/CalculatorUI.java calculator/main/Main.java
4.	Run:
java calculator.main.Main
________________________________________
 Key Highlights
•	Clean and modular code structure
•	Easy to extend (add more units or functions)
•	Combines multiple tools into one application
•	Beginner-friendly yet conceptually strong
________________________________________
 Future Enhancements
•	History tracking of calculations
•	Dark/Light theme toggle
•	More scientific functions
•	Improved UI with layouts
________________________________________
 Author
Developed as part of a Java GUI Project for academic purposes.
________________________________________
 License
This project is intended for educational use.

