# TokoBunga-RestAPI

A Java-based RESTful API designed to handle flower store data communication, focusing on robust **Global Error Handling**, **Data Validation**, and **High Performance Under Load**. This repository serves as a practical implementation of software engineering best practices for backend developers.

## Key Features

- **Full CRUD Support:** Complete flow for managing flowers data (Get, Post, Put, Delete).
- **Comprehensive Error Handling:** Implemented defensive programming using Java Exceptions (`try-catch` & `throw`) to prevent runtime crashes (e.g., `NullPointerException`).
- **Data Integrity Gates:** Strict data validations on the service layer to block corrupted inputs (e.g., negative prices, empty names).
- **Proven Load Scalability:** Stress-tested with production-grade tools to verify server stability.

## Tech Stack

- **Language:** Java 25
- **Framework:** Spring Boot (Spring MVC, Spring Data JPA)
- **Database:** Postgresql
- **Testing Tool:** Grafana k6

---

## Performance & Load Testing Results

To guarantee stability under sudden traffic spikes, the core endpoints were benchmarked using **Grafana k6** in a local environment. 

### Test Configuration
- **Target Endpoint:** `GET /api/buah` (migrated to `/api/bunga`)
- **Simultaneous Load:** 50 Concurrent Virtual Users (VUs) constantly hitting the server.
- **Duration:** 20 Seconds.

### Benchmark Metrics (Baseline)

| Performance Metric | Achievement | Engineering Insights |
| :--- | :--- | :--- |
| **Total Requests** | 7,335 requests | The server effortlessly ingested the entire traffic without dropping packets. |
| **Throughput (RPS)**| **364.86 req/s** | Demonstrates excellent concurrency scalability on the embedded Tomcat server. |
| **Median Latency**  | **10.65 ms** | Over 50% of the clients received an instantaneous response. |
| **P95 Latency**     | **102.17 ms** | 95% of users experienced a response time well below the 100ms industry benchmark. |
| **Error Rate**      | **0.00%** | Zero failures. Proves the robustness of our data layers and exception handlers under load. |

---

## Project Architecture

The project follows a clean **Three-Tier Architecture** separation of concerns:
```text
toko-bunga/
├── Controller/  # Handles HTTP Requests, Query Params, and API Client Responses
├── Service/     # Core Business Logics, Data Gatekeeping, and Error Throwing
├── Repository/  # Database Operations via Spring Data JPA
└── testing/     # Contains the k6 automation load-test scripts
```

## How to Run the Load Test Locally

1. Ensure the Spring Boot application is up and running on port `8080`.
2. Open your terminal and navigate to the testing folder:
   ```bash
   cd testing
   ```
3. Run the k6 script:
   ```bash
   k6 run uji_bunga.js
   ```

---
*Developed with ☕ and passion for highly efficient backend engineering.*
