# GadgetShop

A JavaFX desktop application developed as part of a university Object-Oriented Programming coursework. The application simulates a gadget shop management system, allowing users to create and interact with two types of gadgets — Mobile phones and MP3 players — through a graphical user interface.

---

## Author

**Raul Barros** — Version 1.0, 2026

---

## Overview

GadgetShop demonstrates core OOP principles including inheritance, polymorphism, and encapsulation. The application is built around a class hierarchy where `Mobile` and `Mp3` both extend the abstract base class `Gadget`. All gadgets are stored in an `ArrayList` and managed through a centralised JavaFX GUI.

---

## Class Structure

```
Gadget                  (superclass)
├── Mobile              (extends Gadget)
└── Mp3                 (extends Gadget)

GadgetShop              (main application — extends Application, implements EventHandler)
```

### `Gadget`
The base class. Stores shared attributes common to all gadgets: `model`, `price`, `weight`, and `size`. Provides getter methods and overridable `toString()` and `display()` methods.

### `Mobile`
Extends `Gadget`. Adds `initialCredit` management with the ability to make phone calls and top up credit. Key methods:
- `makePhoneCall(phoneNumber, durationOfCall)` — deducts credit based on call duration
- `addCredit(newCredit)` — adds a positive credit amount to the current balance

### `Mp3`
Extends `Gadget`. Adds `memory` management for storing music files. Key methods:
- `uploadMusic(mp3File)` — decrements available memory if sufficient space exists
- `deleteMusic(mp3File)` — frees memory by removing a file of the given size

### `GadgetShop`
The main application class. Extends `javafx.application.Application` and implements `EventHandler<ActionEvent>` to handle all button interactions from a single centralised `handle()` method. Maintains an `ArrayList<Gadget>` to store all created gadgets at runtime.

---

## Features

- Add Mobile gadgets with model, price, weight, size, and initial credit
- Add MP3 gadgets with model, price, weight, size, and memory capacity
- Make a phone call from a registered Mobile, deducting credit for the call duration
- Add credit to all registered Mobile gadgets
- Upload and delete MP3 files from registered MP3 gadgets, tracking available memory
- Display all gadgets currently stored in the application
- View detailed information for a specific gadget by index
- Tab-based navigation separating Mobile and MP3 controls
- Input validation with descriptive error dialogs for all fields
- Log area displaying the result of every user action
- Exit/reset button to clear all fields and the log area

---

## Event Handling

All buttons are registered using `setOnAction(this)`, where `this` refers to the `GadgetShop` instance. Because `GadgetShop` implements `EventHandler<ActionEvent>`, it acts as a centralised listener for all button events. When a button is clicked, JavaFX invokes the `handle(ActionEvent e)` method, which uses `e.getSource()` to identify the originating button and delegates execution to the appropriate private response method.

---

## Requirements

| Requirement | Version |
|---|---|
| Java | 11 or higher |
| JavaFX | 17 or higher |

---

## How to Run

**1. Clone or download the project files.**

Ensure the following `.java` files are present in the same directory:
- `Gadget.java`
- `Mobile.java`
- `Mp3.java`
- `GadgetShop.java`

**2. Compile with JavaFX on the module path.**

```bash
javac --module-path /path/to/javafx-sdk/lib \
      --add-modules javafx.controls \
      Gadget.java Mobile.java Mp3.java GadgetShop.java
```

**3. Run the application.**

```bash
java --module-path /path/to/javafx-sdk/lib \
     --add-modules javafx.controls \
     GadgetShop
```

> Replace `/path/to/javafx-sdk/lib` with the actual path to your local JavaFX SDK installation.

---

## Usage

1. Select the **MOBILE** or **MP3** tab depending on the gadget type you wish to add.
2. Fill in the required fields and click the relevant **Add** button.
3. Use the action fields (phone number, credit amount, file size) to interact with added gadgets.
4. Click **Display all Gadgets** to list all items currently stored, with their index numbers.
5. Enter an index number and click **Display Info** to view the details of a specific gadget.
6. The **Log Area** at the bottom records all actions and their outcomes.
7. Click **Exit** to clear all fields and reset the log.

---

## OOP Concepts Demonstrated

- **Inheritance** — `Mobile` and `Mp3` extend `Gadget`, inheriting shared fields and overriding `display()` and `toString()`.
- **Polymorphism** — gadgets are stored as `ArrayList<Gadget>` and cast at runtime using `instanceof` checks.
- **Encapsulation** — all fields are declared `private`, accessed only through public getter methods.
- **Event-driven programming** — a single `EventHandler<ActionEvent>` implementation manages all GUI interactions via `e.getSource()` routing.

---

## Notes

- Phone calls and credit operations apply to **all** Mobile gadgets currently stored.
- File upload/delete operations apply to **all** MP3 gadgets currently stored.
- Index-based lookup uses the display number shown by **Display all Gadgets**.
