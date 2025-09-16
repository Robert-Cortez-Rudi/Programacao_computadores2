/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Rober
 * Created: 10 de set. de 2025
 */

CREATE DATABASE banco_digital;
use banco_digital;

CREATE TABLE conta (
	numero INT PRIMARY KEY,
    titular VARCHAR(100),
    saldo DECIMAL(10,2)
);

select * from conta;
