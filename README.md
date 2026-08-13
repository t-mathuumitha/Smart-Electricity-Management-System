# ⚡ Smart Electricity Management System

A **Java-based Smart Electricity Management System** that calculates appliance-wise energy consumption and estimates daily and monthly electricity bills.

The project demonstrates important **Object-Oriented Programming (OOP)** concepts such as **Abstraction, Inheritance, Encapsulation, and Polymorphism**.

## 📌 Project Overview

The Smart Electricity Management System allows users to enter the daily usage hours of different household appliances and calculates:

* Appliance-wise energy consumption
* Total daily energy consumption
* Daily electricity bill
* Estimated monthly energy consumption
* Estimated monthly electricity bill

The system currently supports:

* 💡 Light
* 🌀 Fan
* ❄️ Air Conditioner

## ✨ Features

* Add different types of appliances
* Store appliance details such as name, brand, and power
* Calculate energy consumption based on usage
* Apply different appliance-specific energy calculations
* Generate an appliance energy report
* Calculate electricity bills based on consumption units
* Estimate monthly energy usage and bill
* Console-based user interaction
* Input validation through Java's `Scanner`

## 🛠️ Technologies Used

* **Java**
* **Java OOP**
* `ArrayList`
* `Scanner`
* Abstract Classes
* Inheritance
* Method Overriding
* Encapsulation
* Polymorphism

## 🧠 OOP Concepts Demonstrated

### 1. Abstraction

The `Appliance` class is an abstract class that defines common properties and behavior for all appliances.

```java
public abstract double calculateEnergy(int hours);
```

Each appliance provides its own implementation of energy calculation.

### 2. Encapsulation

Appliance properties such as name, brand, and power are declared as private and accessed using getter methods.

```java
private String name;
private String brand;
private int power;
```

### 3. Inheritance

The appliance classes inherit from the `Appliance` class.

```java
class Light extends Appliance
class Fan extends Appliance
class AirConditioner extends Appliance
```

### 4. Polymorphism

The `calculateEnergy()` and `display()` methods are overridden by each appliance type.

```java
Appliance appliance = ...
appliance.calculateEnergy(hours);
```

The appropriate implementation is executed depending on the actual appliance object.

## 📂 Project Structure

```text
SmartElectricity/
│
├── SmartElectricity.java
│
├── Appliance
│   ├── Light
│   ├── Fan
│   └── AirConditioner
│
├── ElectricityBill
│
└── SmartEnergy
```

All classes are currently implemented in a single Java source file.

## ⚙️ How It Works

### Step 1 — Add Appliances

The system creates three appliances:

```text
LED Bulb       → Philips    → 100 W
Ceiling Fan    → LG         → 200 W
Split AC       → Samsung    → 500 W
```

### Step 2 — Enter Usage Hours

The user enters the number of hours each appliance is used per day.

```text
Enter Light Usage Hours : 5
Enter Fan Usage Hours   : 8
Enter AC Usage Hours    : 4
```

### Step 3 — Calculate Energy

Energy consumption is calculated in **kWh**.

General formula:

```text
Energy (kWh) = Power (W) × Usage Hours / 1000
```

For the Light and Fan, the calculation also considers brightness and speed levels.

### Step 4 — Calculate Electricity Bill

The `ElectricityBill` class calculates the bill according to the applicable consumption slabs.

### Step 5 — Generate Report

The system displays:

```text
Daily Energy Consumption
Daily Electricity Bill
Monthly Energy
Estimated Monthly Bill
```

## 💻 Sample Output

```text
Enter Light Usage Hours : 5
Enter Fan Usage Hours : 8
Enter AC Usage Hours : 4

========== APPLIANCE DETAILS ==========

--------------------------------
Appliance : LED Bulb
Brand     : Philips
Power     : 100 W
Brightness : 80%

--------------------------------
Appliance : Ceiling Fan
Brand     : LG
Power     : 200 W
Speed Level : 5

--------------------------------
Appliance : Split AC
Brand     : Samsung
Power     : 500 W
Temperature : 22 °C

========== ENERGY REPORT ==========

Appliance : LED Bulb
Hours Used  : 5
Energy Used : 0.40 kWh

Appliance : Ceiling Fan
Hours Used  : 8
Energy Used : 1.60 kWh

Appliance : Split AC
Hours Used  : 4
Energy Used : 2.00 kWh

==========================================
Daily Energy Consumption : 4.00 kWh
Daily Electricity Bill   : Rs. 7.60
Monthly Energy           : 120.00 kWh
Estimated Monthly Bill   : Rs. 228.00
==========================================
```

> **Note:** The sample bill is based on the slab rates implemented in the program and is intended for demonstrating the program logic.

## 🚀 How to Run

### 1. Clone the Repository

```bash
git clone <your-repository-url>
```

### 2. Open the Project

Open the project using an IDE such as:

* IntelliJ IDEA
* Eclipse
* NetBeans
* Visual Studio Code

### 3. Compile the Program

```bash
javac SmartElectricity.java
```

### 4. Run the Program

```bash
java SmartElectricity
```

### 5. Enter Appliance Usage

Enter the number of hours each appliance is used when prompted.

## 🔮 Future Improvements

The project can be extended with:

* GUI using Java Swing or JavaFX
* Add/remove appliances dynamically
* User login system
* Database integration using MySQL
* Electricity consumption history
* Monthly consumption charts
* Energy-saving recommendations
* Appliance search and filtering
* Export reports to PDF
* Admin dashboard
* Real-time electricity usage monitoring

## 🎯 Learning Outcomes

This project helps demonstrate practical understanding of:

* Java classes and objects
* Abstract classes
* Inheritance
* Encapsulation
* Polymorphism
* Method overriding
* ArrayList collections
* User input handling
* Mathematical calculations
* Basic system design

## 👩‍💻 Author

**Mathuumitha Thevarajah**

Data Analyst | Java | SQL | Python | Web Development

## 📄 License

This project is created for **educational and academic purposes**.
