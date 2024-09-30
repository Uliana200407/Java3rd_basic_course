# Java3rd_basic_course
## Java 1st Labwork

This repository contains lab works for the Java programming course. Each lab is organized in a separate folder, including source code, tests, and Maven configuration files.

## Running Lab Works with Maven

Each lab work in the repository has its own structure and can be run using Maven. Below are instructions for running a lab work.

### Requirements
- **Java JDK** 1.8 or newer
- **Maven** 3.x

### Running a Lab Work

1. **Clone the repository:**

   ```bash
   git clone (https://github.com/Uliana200407/Java3rd_basic_course.git)
   cd src

2. **Navigate to the specific lab work**

For example, to run the first lab work:

```bash
cd JavaLg1
```

3. **Run the project using Maven**
```bash
mvn clean install
mvn exec:java -Dexec.mainClass="org.example.MatrixLab"
```
4. **Running Tests**
```bash
mvn test
```

