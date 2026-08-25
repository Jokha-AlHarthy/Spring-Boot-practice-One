# Spring Boot Practice Project

## Overview

A small Spring Boot project for practicing CRUD operations using in-memory Lists instead of a database.

The **Person** feature is already completed and is used as the main example.

## Tasks

Complete the following features:

* **Task**
* **PhoneNumber**
* **UserName**

## What to Implement

### Task

* Create request and response classes
* Create `TaskService`
* Complete `TaskController`
* Implement Add, Get, Update, and Delete operations
* Generate a unique task number

### PhoneNumber

* Create request and response classes
* Create `PhoneNumberService`
* Create `PhoneNumberController`
* Implement CRUD operations
* Connect PhoneNumber with Person

### UserName

* Fix the username update logic
* Handle null values safely
* Optionally add an endpoint to view username history

## Project Structure

```text
com.cl.demo
├── controllers
├── entities
├── requestobjects
├── responseobjects
├── services
└── DemoApplication.java
```

## Important Rules

* Use `BaseClass` for common fields such as `id`, `isActive`, `createdDate`, and `updatedDate`.
* Use `UUID.randomUUID()` when creating new records.
* Use `isActive = false` for delete operations instead of removing records.
* Only return active records when reading data.
* Use `HelperUtils.compare()` when updating fields.
* Set `updatedDate` whenever a record is updated.
* Controllers should call Services and return Response objects.
* Validate important fields before saving.
* Follow the same structure and style as the completed `Person` feature.

## Goal

Finish the **Task**, **PhoneNumber**, and **UserName** features by following the same approach used in the completed **Person** feature.
