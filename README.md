# **Task Manager CLI Application**

## **Overview**

The Task Manager CLI Application is a Java-based command-line tool designed for efficient task management. It allows users to create task groups, add tasks to these groups, view tasks within a group, and manage tasks effectively.

## **Features**

Create Task Group: Users can create task groups with unique names and descriptions.
View All Task Groups: Users can view all existing task groups along with their associated tasks.
Manage Task Group: Users can manage individual task groups by adding tasks, viewing tasks, and removing tasks.
Save Task Groups: Users can save the current state of all task groups to XML files for future reference.
Load Task Groups: Users can load previously saved task groups from XML files.

## **Installation**

To install and run the Task Manager CLI Application, follow these steps:

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Compile the project using Maven:

   > mvn compile

4. Run the application using Maven:

   > mvn exec:java

## **Dependencies**

- Java Development Kit (JDK)
- Apache Maven
- Log4j2
- JUnit (for testing)
- JAXB (Java Architecture for XML Binding)

## **Usage**

Upon running the application, follow the on-screen prompts to navigate through the menu options and manage your tasks effectively.

## **Testing**

The project includes comprehensive unit tests using JUnit. You can run the tests using Maven:
mvn test

### **Contributors**

- Me, Myself and I
