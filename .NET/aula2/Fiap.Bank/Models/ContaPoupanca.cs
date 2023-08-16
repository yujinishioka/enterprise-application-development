using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.Bank.Models
{
    internal class ContaPoupanca : Conta, IContaInvestimento
    {
        decimal Taxa;
        decimal _rendimento;

        public ContaPoupanca(int agencia, int numero, DateTime dataAbertura, decimal saldo) : base(agencia, numero, dataAbertura, saldo)
        {
            Taxa = 2;
            _rendimento = 2;
        }

        public override void Depositar(decimal valor)
        {
            this.Saldo += valor;
        }

        public override void Retirar(decimal valor)
        {
            if(this.Saldo > (valor * this.Taxa))
            {
                this.Saldo -= (valor * this.Taxa);
                Console.WriteLine("Saldo retirado no valor: R$", valor);
            } else
            {
                Console.WriteLine("Saldo indisponivel");
            }
        }

        public decimal CalculaRetornoInvestimento()
        {
            return (this.Saldo * this._rendimento);
        }
    }
}
