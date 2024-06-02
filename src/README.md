# Project Overview

This project consists of a set of Java classes that together form a simple graphical user interface (GUI) application for user authentication and registration. The main components of this project are the `CommonConstans`, `Form`, `LoginFormGUI`, and `RegisterFormGUI` classes.

## Classes Description

### CommonConstans.java
This class contains common constants used throughout the application. These constants are likely used to maintain consistency and avoid hardcoding values in multiple places.

**Key functionalities:**
- Defines various constants used in the application.

### Form.java
The `Form` class represents a generic form component in the GUI application. It likely serves as a base class for more specific forms such as login and registration forms.

**Key functionalities:**
- Provides common functionalities for form handling.
- May include methods for form validation and data handling.

### LoginFormGUI.java
The `LoginFormGUI` class is responsible for creating and managing the login form GUI. It extends the functionalities of the `Form` class to specifically handle user login operations.

**Key functionalities:**
- Constructs the login form interface.
- Handles user input for login credentials.
- Implements login validation logic.

### RegisterFormGUI.java
The `RegisterFormGUI` class is responsible for creating and managing the registration form GUI. Similar to `LoginFormGUI`, it extends the `Form` class to handle user registration operations.

**Key functionalities:**
- Constructs the registration form interface.
- Handles user input for registration details.
- Implements registration validation logic.

## How to Run the Project

To run this project, you need to have Java installed on your system. You can compile and run the Java files using the following commands:

```sh
javac CommonConstans.java Form.java LoginFormGUI.java RegisterFormGUI.java
java LoginFormGUI
