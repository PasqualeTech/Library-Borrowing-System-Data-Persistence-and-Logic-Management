# Library Borrowing System: Data Persistence & Logic Management

[Italiano](#italiano) | [English](#english)

---

## <a name="italiano"></a> 🇮🇹 Versione Italiana

### 📚 Descrizione
Un sistema di gestione bibliotecaria che introduce il concetto di **Persistenza dei Dati**. Il software permette di gestire un catalogo di libri, monitorare la loro disponibilità e salvare lo stato su file locale.

### 🛠️ Evoluzione Tecnica
* **File Handling:** Uso di `FileWriter` e `Scanner` per il salvataggio permanente (`.txt`).
* **State Management:** Gestione della disponibilità dei libri (In Prestito / Disponibile).
* **Robustezza:** Caricamento automatico del database all'avvio dell'applicazione.

---

## <a name="english"></a> 🇬🇧 English Version

### 📚 Description
A Library Management System introducing the concept of **Data Persistence**. This software manages a book catalog, tracks borrowing status, and saves data to a local file.

### 🛠️ Technical Evolution
* **File Handling:** Implementation of `FileWriter` and `Scanner` for permanent storage (`.txt`).
* **State Management:** Logic-based tracking of book availability (Borrowed / Available).
* **Resilience:** Automatic database loading upon application startup.

---

### 💻 Setup
1. `javac LibrarySystemApp.java`
2. `java LibrarySystemApp`
