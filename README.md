# Inventory Management System 

Hi there! Welcome to my Java mini-project. 

## What is this?
I built this simple console-based application to help small shop owners move away from writing down their daily stock in paper notebooks. It lets you digitally add products, search for specific items, and automatically calculates the total monetary value of your entire inventory. 

The most helpful part of this project is that it uses Java File Handling. Every time you add an item or close the program, it saves everything to a text file (`inventory.txt`). When you open the program again later, all your old data is loaded right back up so nothing gets lost!

## What can it do?
* **Add Products:** Quickly type in a new product's ID, Name, Quantity, and Price.
* **View Inventory:** See a clean, formatted list of everything currently in stock.
* **Search by ID:** Look up a specific item to see if you have it and what it costs.
* **Do the Math:** Automatically multiplies the quantity and price of everything to give you the total stock value.
* **Error Catching:** I added `try-catch` blocks, so if you accidentally type a word instead of a number, the program will just ask you to try again instead of completely crashing.

## Concepts I Used
* **Language:** Core Java
* **OOP Principles:** Classes, Objects, Constructors, Encapsulation, and Method Overloading.
* **Data Storage:** Used an `ArrayList` to manage data while the app is running, and `BufferedReader` / `BufferedWriter` to permanently save it to a file.

## How to run it on your computer
Want to test it out? It's really easy:
1. Make sure you have Java installed on your computer.
2. Download or clone this folder and open your terminal/command prompt inside it.
3. Compile both Java files at the same time by typing: 
   `javac *.java`
4. Run the main menu by typing: 
   `java InventoryManager`

## Project Files
* `InventoryManager.java` - The main file that runs the menu and handles the file saving.
* `Product.java` - The class that acts as a blueprint for the products.
* `inventory.txt` - The file that is automatically generated to save your data.

---
**Created by:**
Netra B. (RA2411042020042)
SRM Institute of Science and Technology, Ramapuram
