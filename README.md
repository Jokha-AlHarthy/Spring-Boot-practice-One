\# Spring Boot Practice Project



\## 📌 Overview



A small \*\*Spring Boot practice project\*\* that stores data in memory using Lists instead of a database.



The \*\*Person\*\* feature is already completed and is used as the example to finish:



\* \*\*Task\*\*

\* \*\*PhoneNumber\*\*

\* \*\*UserName\*\*



\## 🎯 Objectives



\* Practice Spring Boot Controllers and Services

\* Create Request and Response objects

\* Work with in-memory Lists

\* Implement CRUD operations

\* Practice `@RestController`, `@Service`, and `@Autowired`

\* Follow the same structure and coding style as \*\*Person\*\*



\## 📂 Project Structure



```text

com.cl.demo

├── controllers

├── entities

├── requestobjects

├── responseobjects

├── services

└── DemoApplication

```



\## ✅ Main Tasks



\### 1. Task



Implement:



\* Request \& Response classes

\* `TaskService`

\* `TaskController`

\* CRUD operations

\* Task number generation



\### 2. PhoneNumber



Implement:



\* Request \& Response classes

\* `PhoneNumberService`

\* `PhoneNumberController`

\* CRUD operations

\* Connect PhoneNumber with Person



\### 3. UserName



\* Fix username update logic

\* Handle null values safely

\* Optionally add an endpoint to view username history



\## 🔧 Important Rules



\* Use `BaseClass` fields instead of duplicating them.

\* Use `UUID.randomUUID()` for IDs.

\* Use `isActive` for soft delete.

\* Use `HelperUtils.compare()` when updating fields.

\* Set `updatedDate` whenever a record is updated.

\* Controllers should call Services and return Response objects.

\* Validate important fields before saving.



\## 🚀 Goal



Complete \*\*Task, PhoneNumber, and UserName\*\* by following the same structure and style used in the completed \*\*Person\*\* feature.



