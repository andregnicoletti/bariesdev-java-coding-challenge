# Java HackerEarth Coding Challenge – Solutions and Study Guide

This repository contains three solved problems from a Java online coding test on HackerEarth. Each problem includes:
- English and Portuguese descriptions
- Fully commented Java 17 solutions
- Designed for study and practice

---

## 🚀 Problem 1: Seat Reservation

### 📝 Enunciado (EN)
A movie theater has N seats numbered from 1 to N. There are K operations:
- If `seat[i] == 0`: Reserve the smallest available seat.
- If `seat[i] > 0`: Cancel the reservation for that seat.
  Return a list of all reserved seats in the order they were reserved.

### 📌 Enunciado (PT)
Um cinema possui N assentos numerados de 1 até N. São feitas K operações:
- Se `seat[i] == 0`: Reserve o menor assento livre.
- Se `seat[i] > 0`: Cancele a reserva do assento correspondente.
  Retorne a lista dos assentos reservados na ordem em que foram feitas as reservas.

---

## 🧵 Problem 2: Comment Section Filter

### 📝 Enunciado (EN)
You are given N comments and a keyword S. Count how many comments contain the keyword `S`, considering:
- Words are separated by `_`
- Comparison is case-insensitive

### 📌 Enunciado (PT)
Você recebe N comentários e uma palavra-chave S. Conte quantos comentários contêm a palavra `S`, considerando:
- As palavras estão separadas por `_`
- A comparação ignora maiúsculas e minúsculas

---

## 📊 Problem 3: Best Subsequence

### 📝 Enunciado (EN)
Given an array `a` of size `n` and an integer `k`, find the subsequence of length `k` with the minimum "special value" defined as:
```
∑(i=2 to k) |pi - pi-1|
```
Return that minimum value. If not possible, return 0.

### 📌 Enunciado (PT)
Dado um array `a` de tamanho `n` e um inteiro `k`, encontre a subsequência de tamanho `k` com o menor "valor especial" definido por:
```
∑(i=2 até k) |pi - pi-1|
```
Retorne esse valor mínimo. Se não for possível, retorne 0.

---

## 💻 How to Run

Compile and run each solution using Java 17:
```bash
javac TestClass.java
java TestClass
```

Each function is designed to be easily testable and independent.

---

## ✍️ Author
André Nicoletti

---