# **Skills Test: Test Platform & QA Engineering Leadership**

**Role:** Software Engineering, Test Platform and QA

**Objective:** This exercise aims to evaluate your technical proficiency in designing and implementing robust test automation frameworks. We are looking for candidates who can demonstrate strong coding practices, architectural thinking for reusability and maintainability, and a clear understanding of the strengths and weaknesses of different testing platforms.

**Scenario:** You will be building automated test solutions against a publicly available, stable, and simple e-commerce website: [`https://www.saucedemo.com/`](https://www.saucedemo.com/)

**Test Outcomes & Deliverables:**

Your submission should demonstrate your ability to:

1. **Design a Core Test Library:** Create reusable and well-structured test library components for common functionalities encountered on `saucedemo.com`. A key example is a login mechanism (e.g., encapsulating the steps to log in with a given username and password). These libraries should promote reusability across multiple tests.

2. **Develop a Functional Test Suite:** Build a comprehensive test suite that specifically validates the functionality of adding items to the shopping cart and completing the checkout process on `saucedemo.com`. This suite should leverage the core test libraries you've developed.

**Important Implementation Requirements:**

Both the core test library and the functional test suite must be implemented **twice**, using the following technology stacks:

* **Implementation 1: Selenium with Java**

  * **Core Library:** Implement the common functionalities (e.g., login) as reusable Java classes or methods using Selenium WebDriver. Ideally this is something that can be packaged and deployed to a company maven repository such as [GCP Artifact Registry](https://cloud.google.com/artifact-registry/docs).
  * **Test Suite:** Develop the add-to-cart and checkout tests using Selenium WebDriver in Java, leveraging your core library. Add as many tests as you feel is a reasonable use of your time to demonstrate your proficiency.


* **Implementation 2: Playwright with TypeScript**

  * **Core Library:** Implement the common functionalities (e.g., login) as reusable TypeScript functions or classes using Playwright. Ideally this is something that can be packaged and deployed to a company NPM repository as [GCP Artifact Registry](https://cloud.google.com/artifact-registry/docs).
  * **Test Suite:** Develop the add-to-cart and checkout tests using Playwright in TypeScript, leveraging your core library. Add as many tests as you feel is a reasonable use of your time to demonstrate your proficiency.

## Repository structure

The solution is organized in **separate folders per language and framework**:

| Folder | Stack | Description |
|--------|--------|-------------|
| **Selenium_Python** | Selenium WebDriver + Python + pytest | Core library (auth, pages, checkout flow) and functional tests for login, add-to-cart, and checkout. |
| **Selenium_Java** | Selenium WebDriver + Java + JUnit 5 | Core library (auth, pages, checkout flow) and add-to-cart/checkout tests; Maven build. |
| **Playwright_TypeScript** | Playwright + TypeScript | Core library (auth, pages, checkout flow) and add-to-cart/checkout tests; npm build. |

Each folder has its own **README** with setup and run instructions. Target application: [saucedemo.com](https://www.saucedemo.com/).

**Code Quality & Visibility:**

* All code for this exercise **must be open-sourced** in your git repository.
* We expect to see **regular, meaningful commits** throughout your development process. This allows us to observe your iterative approach, thought process, and commitment to version control best practices.
* Organize your repository and code in a logical and professional manner, demonstrating good software engineering principles (e.g., clear folder structure, meaningful variable names, appropriate comments where necessary, use of build tools if applicable).

**Evaluation Criteria:**

Your submission will be evaluated based on both your leadership skills and your technology skills:

* **Leadership Skills**
  * **Communication Skills:**
    * Well thought-out and compelling video explanation of your exploration, experience and discoveries.
  * **Software Design & Architecture:**
    * Clean separation of concerns.
    * Scalability considerations for future test growth.
    * Readability and organization of the codebase.
    * Modularity, reusability, and maintainability of the core test libraries.
  * **Version Control & Documentation:**
    * Consistent and meaningful commit history.
    * Clear README files in your repositories explaining how to set up and run the tests.
* **Technical skills**
  * **Problem-Solving & Efficiency:**
    * Elegant solutions to common automation challenges (e.g., element locators, waiting strategies).
    * Efficiency of the implemented tests.
  * **Technical Proficiency (Coding):**
    * Correctness and functionality of the tests.
    * Adherence to best practices for Java and TypeScript.
    * Effective use of Selenium and Playwright APIs.

**Instructions:**

* You are free to use any build tools (e.g., Maven, Gradle for Java; npm, yarn for TypeScript), libraries and frameworks you deem appropriate. We are looking to measure your decision process in selecting and using tools.
* You are free to use Google search, books, AI coding assistants, and any other resources that you want to, but be aware that you will be judged heavily on your understanding and communication of your solution. **We allow and encourage the use of AI for this task.**
* Ensure your README provides clear instructions on how to set up dependencies and run your tests.
* Feel free to add any additional comments or explanations in your repository README that you believe will enhance our understanding of your work.

**Assessment Process:**

Once we have received your submission;

* We will review your video & code
* We will schedule a follow up interview to debrief on your findings

## CodeSubmit

Please organize, design, test, and document your code as if it were
going into production - then push your changes to the master branch.

Have fun coding! 🚀
