<a href="https://www.oracle.com/java/technologies/downloads/"><img src="https://img.icons8.com/?size=2x&id=13679&format=png" align="right" width="10%"></a>

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
## Java 2nd Labwork
### Step 1: Navigate to the Project Directory
```bash
cd ~/Desktop/Java\ Language\ Labs/JavaLg2
```
### Step 2: Compile the Java Code
```bash
javac -d out -cp src/main/java src/main/java/org/example/*.java src/test/java/org/example/*.java
```
### Step 3: Run the Main Class
```bash
java -cp out org.example.LabWork2
```
### Step 4: Run the JUnit Tests
```bash
java -jar junit-platform-console-standalone.jar -cp out --select-class org.example.LabWork2Test
```
### Step 5: Run the tests with Maven
```bash
mvn test
```

# Java 3rd Labwork
### Step 1: Navigate to the Project Directory
```bash
cd ~/Desktop/Java\ Language\ Labs/JavaLg3
```
### Step 2: Compile the Java Code
```bash
javac -d out -cp src/main/java src/main/java/org/example/*.java src/test/java/org/example/*.java
```
### Step 3: Run the Main Class
```bash
javac -d out -cp src/main/java src/main/java/org/example/*.java src/test/java/org/example/*.java
```
### Step 4: Run the JUnit Tests
```bash
java -jar junit-platform-console-standalone.jar -cp out --select-class org.example.CarTest
```
### Step 5: Run the tests with Maven
```bash
mvn test
```

# Java 4th Labwork
### Step 1: Clone the Repository
```bash
git clone <repository-url>
cd <repository-name>
```
### Step 2: Compile the Code
```bash
cd src/main/java
javac org/example/*.java
```
### Step 3: Run the Application
```bash
java org.example.LabWork2Executor
```
### Step 4: Run Unit Tests (Optional)
```bash
# Navigate back to the root directory (if necessary)
cd ../../../..
```
### Step 5: Run the tests with Maven
```bash
mvn test
```
