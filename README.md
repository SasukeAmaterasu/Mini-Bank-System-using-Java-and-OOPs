# Mini-Bank-System-using-Java-and-OOPs
Creating a basic bank system using Java and OOPs concept. It cover the concept of abstraction, inheritence , encapsulation and polymorhism.
# 🏦 Mini Bank System (Java OOP)

A console-based banking application built in Java demonstrating **full Object-Oriented Programming concepts** such as **abstraction**, **inheritance**, and **polymorphism**.  
This project simulates basic banking operations like account creation, deposit, withdrawal, and balance inquiry.

---

## 🚀 Features
- **Create Accounts**  
  - Savings Account (no overdraft)  
  - Current Account (with overdraft facility)  
- **Deposit Money** into any account  
- **Withdraw Money** with account-specific rules  
- **View Balance** for individual accounts  
- **View All Accounts** in the system  
- **Error Handling** for invalid inputs or account numbers  

---

## 🛠️ Technologies Used
- **Java** (Core Java, OOP concepts)
---

## 📂 Project Structure
BankAccount (abstract)
   - accountNumber : String
   - accountHolderName : String
   - balance : double
   + deposit(amount)
   + withdraw(amount)
   + getBalance()

SavingsAccount extends BankAccount
   - interestRate : double
   + withdraw(amount) // Specific rule

CurrentAccount extends BankAccount
   - overdraftLimit : double
   + withdraw(amount) // Specific rule

Bank
   - accounts : List<BankAccount>
   + createAccount()
   + getAccountByNumber()
   + deposit()
   + withdraw()
   + displayAllAccounts()

Main
   - main() // Menu & user interaction
