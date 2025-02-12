# Selenium Test Project - Insider Careers Page Testing

## 📌 Project Overview
This is a **Selenium WebDriver automation project** for testing the Careers page of [Insider](https://useinsider.com/). The framework is structured using the **Page Object Model (POM)** and **TestNG** for test execution and assertions.

## 📂 Project Structure
```
SeleniumTestProject/
│── src/main/java/
│   ├── pages/                 # Page Object Model (POM) classes
│   │   ├── HomePage.java
│   │   ├── CareersPage.java
│   │   ├── QAPage.java
│   │   ├── JobDetailsPage.java
│   ├── utils/                 # Utility class for WebDriver
│   │   ├── WebDriverManagerUtil.java
│── src/test/java/
│   ├── tests/                 # Test cases
│   │   ├── InsiderTest.java
│── pom.xml                    # Maven dependencies
│── testng.xml                 # TestNG configuration file
│── README.md                  # Documentation
```

## 🔹 Technologies Used
- **Java** (Programming Language)
- **Selenium WebDriver** (Browser Automation)
- **TestNG** (Test Framework)
- **Maven** (Dependency Management)
- **WebDriverManager** (Driver Management)

## 📌 Page Object Model (POM) Breakdown
This project follows the **Page Object Model (POM)** for better test structure and maintainability. Each page of the website has its own class with web element locators and related methods.

### **1️⃣ HomePage.java**
- Ensures the Insider home page is loaded.
- Navigates to the Careers page.

### **2️⃣ CareersPage.java**
- Verifies that the Careers page is loaded.
- Navigates to the QA jobs section.

### **3️⃣ QAPage.java**
- Filters jobs based on location (**Istanbul, Turkey**) and department (**Quality Assurance**).
- Verifies that the jobs list is displayed.

### **4️⃣ JobDetailsPage.java**
- Verifies job details (Title, Department, and Location).
- Opens the job application page by clicking “View Role.”

### **5️⃣ WebDriverManagerUtil.java**
- Manages the WebDriver instance.
- Ensures that **Google Chrome** is properly set up for Selenium.

## 🏃 How to Run the Tests

### **1️⃣ Clone the Repository**
```sh
git clone https://github.com/your-repo/SeleniumTestProject.git
cd SeleniumTestProject
```

### **2️⃣ Install Dependencies**
Ensure you have **Maven** installed, then run:
```sh
mvn clean install
```

### **3️⃣ Run Tests Using TestNG**
You can run all tests using:
```sh
mvn test
```

Alternatively, you can execute the tests via **IntelliJ or Eclipse**:
- **Right-click `testng.xml` → Run 'testng.xml'**

## 📌 TestNG Configuration (`testng.xml`)
The `testng.xml` file configures which test classes to execute:
```xml
<suite name="InsiderSuite">
    <test name="QA Job Filter Test">
        <classes>
            <class name="tests.InsiderTest"/>
        </classes>
    </test>
</suite>
```

## ✅ Expected Test Flow
1. Open **Insider Homepage** and validate it is loaded.
2. Navigate to **Careers Page** and check sections.
3. Navigate to **QA Jobs** and apply filters.
4. Verify that the job results match the filter criteria.
5. Open a job listing and verify **Title, Department, and Location**.

## ❗ Notes
- Ensure **Google Chrome** is installed and accessible.
- If using **WSL2**, configure `WebDriverManagerUtil.java` to point to the Windows Chrome binary.

## 🛠️ Future Improvements
- Extend test cases to cover more job locations and departments.
- Implement cross-browser testing (Firefox, Edge).
- Integrate reporting using **Extent Reports**.

---
**Author:** HDR  
**Date:** February 2025  
🚀 Happy Testing! 🎯

