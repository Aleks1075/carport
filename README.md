## Project Overview

In this project, we developed a dynamic web application for Johannesfog, focusing on the sale of custom-sized carports. One of the key components was creating a calculation engine to handle various carport dimensions chosen by customers. The project aimed to analyze and meet client requirements, work according to Kanban principles, and create user stories with estimates and acceptance criteria.

The solution is based on a MySQL database and reflects a multi-layer architecture running on a Java server, built using Java classes, servlets, and JSP pages. The project is implemented in the cloud, with the source code available in a GitHub repository. Over the four-week project period, we held four meetings with teachers acting as customer representatives, taking notes and minutes systematically to address any issues encountered.

This project provided a significant learning opportunity, aiming to gain new knowledge and experience in core subjects of the second semester. The final product includes a working web application and a report documenting the process.

# Background

Johannes Fog is a well-established company founded in 1920, with several expansions over the years. Today, it has 9 timber and building centers across Zealand and a Home & Design house in Lyngby. Although they have a functional IT system, it no longer meets modern requirements, which is where our project comes in.

In the system we developed, users can register and log in either as a customer or an administrator. Customers can request a carport by selecting the width and length, view ongoing requests, saved orders, carport drawings, and bills to be paid, and subsequently see the bill of materials and carport drawing. Customers can also view and update their profiles to ensure their information is always accurate.

Administrators can view all orders, see requests for individual orders, approve orders for customer payment, and generate a bill of materials viewable on the customer side after payment. They can also delete orders, view all registered customers, contact them if necessary, and manage materials in stock by adding, updating prices, and removing materials.

# Business Understanding

## SWOT Analysis
A SWOT analysis helped us identify and evaluate our strengths, weaknesses, opportunities, and threats. This analysis provided insights into how to leverage our strengths and address our weaknesses while recognizing opportunities and mitigating potential threats.

# Technology Choices

The technologies used in this project include:

IntelliJ IDEA 2021.2.4 (Ultimate Edition)
MySQL Workbench Version 8.0.28
Apache Tomcat 9.0.67
Java version 19
Corretto 19
JDBC MySQL connector Version 8.0.30
JSTL Version 1.2
Bootstrap 5.0
Digital Ocean – Linux Ubuntu droplet server
The project is based on this start code: Start Code

# Workflows to be IT-Supported

## As-Is Diagram
The current workflow at Fog involves customers sending a request for a carport, received via email by an administrator. The administrator reviews the order, contacts the customer if necessary, and enters all information into a program that generates a drawing and bill of materials. Finally, the customer receives an invoice for payment and, upon payment, a building guide with drawing and bill of materials.

## To-Be Diagram
The new system involves customers logging in or creating an account and then sending a request for carport dimensions. Customers can view order status and details on the order page, with the bill of materials visible only after payment.

Administrators can view all registered orders, order details, carport drawings, approve orders for customer payment, and contact customers if necessary. They can also delete orders, view all registered customers, and manage materials in stock.

# User Stories

User stories and acceptance criteria are divided into two tables for better overview, one for customer perspective and the other for administrator perspective.

# Domain Model, EER Diagram & Class Diagram

These diagrams provide the foundation for our system, representing relationships and interactions between various entities in our domain. The EER diagram shows the setup of our database, and the class diagram illustrates the structure of our system.

# Navigation Diagram & Figma

The navigation diagram shows the flow on our website, and the Figma design tool was used to create and visualize user interfaces for our website. The links to our Figma design and other resources can be found under the "Links" section.

# Architectural Choices

We used the MVC architecture (Model-View-Controller) to separate different layers of code, making the codebase more manageable and easier to navigate. The start code provided included basic functionalities such as login, logout, home page, and templates.

# Special Considerations

## Sessions
We used RequestScope for displaying information or data and SessionScope for user login sessions.

## Error Handling
Basic error handling was implemented, primarily catching SQLExceptions and displaying error messages.

## User Input Validation
Validation was implemented to ensure users fill out all required fields and input correct data types.

## Drawing and Bill of Materials Calculation
Our system generates SVG drawings based on customer-selected dimensions and calculates the bill of materials accordingly.

# Implementation Status

We completed all 25 user stories and acceptance criteria. We are satisfied with the result but see potential for further improvements, such as enhancing the payment functionality and implementing additional features.

# Process

We used Kanban for project management, with weekly sprints, regular meetings, and systematic note-taking. Effective communication and collaboration were maintained throughout the project using Discord and Trello.

# Reflection

The project emphasized the importance of both SYS and coding aspects. Effective communication, collaboration, and structured workflows contributed to the project's success.

# Conclusion

The final product is a functioning website that meets customer requirements, along with a comprehensive report documenting the entire process.
