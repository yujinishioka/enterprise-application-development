using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.Bank.Models
{
    public abstract class Conta
    {
        public int Agencia { get; set; }
        public int Numero { get; set; }
        public DateTime DataAbertura { get; set; }
        public decimal Saldo { get; set; }

        public Conta(int agencia, int numero, DateTime dataAbertura, decimal saldo)
        {
            Agencia = agencia;
            Numero = numero;
            DataAbertura = dataAbertura;
            Saldo = saldo;
        }

        public abstract void Depositar(decimal valor);
        public abstract void Retirar(decimal valor);

    }
}
