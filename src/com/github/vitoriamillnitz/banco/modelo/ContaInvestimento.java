package com.github.vitoriamillnitz.banco.modelo;

public class ContaInvestimento extends Conta {

    public ContaInvestimento(Pessoa titular, int agencia, int numero) {
        super(titular, agencia, numero); //chamando os construtores da super classe Conta
    }

    @Override
    public void debitarTarifaMensal() {
        if (getSaldo() < 10_000) {
            sacar(30);
        }
    }

    public void creditarRendimentos(double percentualJuros) {
        double valorRendimentos = getSaldo() * percentualJuros / 100;
        depositar(valorRendimentos);
    }
}
