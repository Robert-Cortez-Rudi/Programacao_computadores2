/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.Conta;
import strategy.TarifaStrategy;

/**
 *
 * @author Rober
 */
public class TarifaService {

    public double calcularTarifa(Conta conta, TarifaStrategy strategy) {
        return strategy.calcular(conta.getSaldo());
    }
}
