# 🏥 Hospital Management System

A full-stack web application built using **Spring Boot**, **MySQL**, and **Spring Security** to manage Patients, Doctors, and Appointments.

---

## 🚀 Tech Stack

- **Backend:** Java 17, Spring Boot, Spring Data JPA (Hibernate)
- **Database:** MySQL
- **Security:** Spring Security (Basic Auth + Role-Based Access)
- **Frontend:** HTML, CSS, JavaScript (Fetch API)
- **Build Tool:** Maven
- **API Testing:** Postman

---

## ✨ Features

- **Patient Management:** Add, view, update, and delete patients.
- **Doctor Management:** Add, view, update, and delete doctors.
- **Appointment Management:** Book appointments linking patients and doctors (`@ManyToOne`).
- **Role-Based Access Control:** ADMIN (full access) and USER (read-only).
- **Global Exception Handling:** Custom exceptions with `@RestControllerAdvice`.
- **Responsive Frontend Dashboard:** Login page, CRUD forms, and real-time API responses.

---

## 🏗️ Architecture

3-Tier Architecture:

- **Controller Layer:** Handles HTTP requests (`@RestController`).
- **Service Layer:** Business logic (`@Service`).
- **Repository Layer:** Database operations (`JpaRepository`).

---

## 🔧 How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/samadhan-dev-1303/hospital-management-system.git