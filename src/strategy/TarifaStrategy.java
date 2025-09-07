/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

/**
 *
 * @author Rober
 */
public enum TarifaStrategy {
    FIXA {
        @Override
        public double calcular(double saldo) {
            return 10.0; 
        }
    },
    PERCENTUAL {
        @Override
        public double calcular(double saldo) {
            return saldo * 0.01; 
        }
    },
    ISENTA {
        @Override
        public double calcular(double saldo) {
            return 0.0;
        }
    };

    public abstract double calcular(double saldo);
}
