package com.github.vitoriamillnitz.banco.modelo;

import java.util.Objects;

public class Conta {

    private Pessoa titular; // o titular da com.github.vitoriamillnitz.banco.modelo.Conta é uma instância do tipo com.github.vitoriamillnitz.banco.modelo.Pessoa
    private int agencia;
    int numero;
    double saldo;

    Conta() {

    }

    public Conta(Pessoa titular, int agencia, int numero) {
        Objects.requireNonNull(titular); // uma excecao a partir de uma instrucao para nao precisar usar o if
        this.titular = titular; //o this referencia as variaveis da classe com.github.vitoriamillnitz.banco.modelo.Conta e nao ao construtor
        this.agencia = agencia;
        this.numero = numero;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }
        saldo = saldo + valor;
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }
        if (getSaldoDisponivel() - valor < 0) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        saldo = saldo - valor;
    }

    public void sacar(double valor, double taxaSaque) {
        sacar(valor + taxaSaque);
    }

    public Pessoa getTitular() {
        return titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getSaldoDisponivel() {
        return getSaldo();
    }

}

