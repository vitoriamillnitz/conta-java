package com.github.vitoriamillnitz.banco.app;

import com.github.vitoriamillnitz.banco.modelo.*;
import com.github.vitoriamillnitz.banco.modelo.atm.CaixaEletronico;
import com.github.vitoriamillnitz.banco.modelo.pagamento.Boleto;
import com.github.vitoriamillnitz.banco.modelo.pagamento.DocumentoPagavel;
import com.github.vitoriamillnitz.banco.modelo.pagamento.Holerite;

public class Principal {

    public static void main(String[] args) {
        Pessoa titular1 = new Pessoa();
        titular1.setNome("João da Silva");
        titular1.setDocumento("12312312311");

        Pessoa titular2 = new Pessoa();
        titular2.setNome("Maria Abadia");
        titular2.setDocumento("222333444555");

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 123, 987);
        ContaEspecial suaConta = new ContaEspecial(titular2, 222, 333, 1_000);

        minhaConta.depositar(30_000);
        minhaConta.sacar(1_000);
//        minhaConta.creditarRendimentos(0.8);
//        minhaConta.debitarTarifaMensal();

        suaConta.depositar(15_000);
        suaConta.sacar(15_500);
        suaConta.depositarTarifaMensal();

        Boleto boletoEscola = new Boleto(titular2, 800);
        Holerite salarioFuncionario = new Holerite(titular2, 100, 160);

        caixaEletronico.pagar(boletoEscola, minhaConta);
        caixaEletronico.pagar(salarioFuncionario, minhaConta);

        System.out.println("Boleto pago: " + boletoEscola.estaPago());
        System.out.println("Salário pago: " + salarioFuncionario.estaPago());


        caixaEletronico.imprimirSaldo(minhaConta);
        System.out.println();
        caixaEletronico.imprimirSaldo(suaConta);
    }
}
