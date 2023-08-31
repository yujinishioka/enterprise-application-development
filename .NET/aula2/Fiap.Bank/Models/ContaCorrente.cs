using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.Bank.Models
{
    internal class ContaCorrente : Conta
    {
        TipoConta Tipo;

        public ContaCorrente(int agencia, int numero, DateTime dataAbertura, decimal saldo) : base(agencia, numero, dataAbertura, saldo)
        {
            Tipo = TipoConta.Comum;
        }

        public override void Depositar(decimal valor)
        {
            this.Saldo += valor;
            Console.WriteLine("Saldo depositado com sucesso. Saldo atual: R$", this.Saldo);
        }

        public override void Retirar(decimal valor)
        {
            if(this.Saldo >= valor && this.Tipo == TipoConta.Comum)
            {
                this.Saldo -= valor;
                Console.WriteLine("Saldo retirado no valor: R$", valor);
            } else
            {
                Console.WriteLine("Saldo insuficiente.");
            }
        }
    }
}
