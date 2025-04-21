# 📦 Electronics Inventory API

A Spring Boot-based REST API for managing an inventory of electronic products. This application supports CRUD operations, bulk insertion, category-based filtering, and grouping functionality.

---

## 🚀 Features

- Add, update, delete, and fetch electronics
- Search by product ID or category
- Bulk insert electronic items
- Group products by category

---

## 🛠️ Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/electronics-inventory.git
   cd electronics-inventory
2. configure database-
 spring.application.name=electronics-inventory
spring.datasource.url=jdbc:mysql://localhost:3306/electronics_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

** API EndPoints:
Method | Endpoint | Description
GET | /electronics | Fetch all electronics
GET | /electronics/id/{id} | Get a product by ID
GET | /electronics/category/{category} | Filter products by category
GET | /electronics/groupByCategory | Group products by category
POST | /electronics/add | Add a new electronic item
POST | /electronics/addbulk | Add multiple products in bulk
PUT | /electronics/update/{id} | Update an existing product
DELETE | /electronics/delete/{id} | Delete a product by ID
