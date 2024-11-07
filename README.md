# MediBook

MediBook is a web application that allows users to manage their healthcare appointments with ease. Users can log in to view their dashboard, explore a list of specialists, book appointments, and manage existing ones.

## Features

### User Account Management
- **Log In / Log Out**: Users can securely log in and log out to access the application.
- **Dashboard**: After logging in, users are directed to their dashboard, which displays upcoming and past appointments.

### Specialist Directory
- **View Specialists**: Users can browse a list of available specialists.
- **Specialist Details**: Click on a specialist to view additional information about their expertise and availability.

### Appointment Management
- **Upcoming Appointments**: View all upcoming appointments, with the ability to sort by date (newest or oldest).
- **Past Appointments**: View a history of previous appointments for easy reference.
- **Detailed Appointment View**: Click on an upcoming appointment to view more details about it.
- **Cancel Appointment**: Users can cancel any upcoming appointments as needed.

### Booking Appointments
- **Book an Appointment**: 
  - **Filter by Doctor**: Select a specialist to book with.
  - **Filter by Date and Time**: Choose an available date and time within a two-week window.
- **Real-Time Availability**: Appointment times are filtered in real-time based on availability.

## Technology Stack

- **Backend**: Java with [Javalin](https://javalin.io/) for the web framework
- **Database Migration**: Flyway
- **Build Tool**: Maven
- **Frontend**: HTML, Thymeleaf templates, jQuery, and CSS

## Running the Project

To set up and run the project locally, follow these steps:

1. **Clone the Repository**:
- git clone https://github.com/corndel-swe/java-24-project-medi-book.git
- cd medibook
   
2. **Database setup - Clean, Compile and Migrate**:
- mvn clean
- mvn compile
- mvn flyway:migrate

3. **Run the application**
- Go into App and run
