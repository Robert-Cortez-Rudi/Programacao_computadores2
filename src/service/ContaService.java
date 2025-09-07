package service;

import exception.SaldoInsuficienteException;
import model.ContaCorrente;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import model.Conta;

public class ContaService {

    // Coleção em memória de todas as contas
    private ArrayList<ContaCorrente> contas = new ArrayList<>();

    // Ler uma única conta do arquivo (primeira linha) e adicioná-la à lista
    public ContaCorrente lerConta(String caminho) throws IOException {
        ArrayList<String> linhas = new ArrayList<>(Files.readAllLines(Paths.get(caminho)));
        if (linhas.isEmpty()) return null;

        String[] dados = linhas.get(0).split(",");
        int numero = Integer.parseInt(dados[0].trim());
        String titular = dados[1].trim();
        double saldo = Double.parseDouble(dados[2].trim());

        ContaCorrente conta = new ContaCorrente(numero, titular, saldo);
        return conta;
    }

    // Lê todas as contas do arquivo e adiciona na lista
    public void carregarTodasContas(String caminho) throws IOException {
        ArrayList<String> linhas = new ArrayList<>(Files.readAllLines(Paths.get(caminho)));

        for (String linha : linhas) {
            String[] dados = linha.split(",");

            int numero = Integer.parseInt(dados[0].trim());
            String titular = dados[1].trim();
            double saldo = Double.parseDouble(dados[2].trim());

            ContaCorrente conta = new ContaCorrente(numero, titular, saldo);
            adicionarConta(conta);
        }
    }

    // Adicionar conta à lista
    public void adicionarConta(ContaCorrente conta) {
        contas.add(conta);
    }

    // Buscar conta pelo número
    public ContaCorrente buscarConta(int numero) {
       for (ContaCorrente c : contas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }

    // Listar todas as contas
    public ArrayList<ContaCorrente> getContas() {
        return contas;
    }

    // Sacar valor de uma conta
    public void sacarValor(ContaCorrente conta, double valor) throws SaldoInsuficienteException {
        conta.sacar(valor);
    }

    // Depositar valor em uma conta
    public void depositarValor(ContaCorrente conta, double valor) {
        conta.depositar(valor);
    }

    // Atualizar conta em arquivo
    public void atualizarConta(ContaCorrente conta, String caminho) throws IOException {
        String dados = conta.getNumero() + "," + conta.getTitular() + "," + conta.getSaldo();
        Files.write(Paths.get(caminho), dados.getBytes());
    }
    
    // Salvar as Contas em arquivo
    public void salvarContas(String caminho) throws IOException {
        ArrayList<String> linhas = new ArrayList<>();
        for (ContaCorrente c : contas) {
            linhas.add(c.getNumero() + "," + c.getTitular() + "," + c.getSaldo());
        }
        Files.write(Paths.get(caminho), linhas, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public List<Conta> getConta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
