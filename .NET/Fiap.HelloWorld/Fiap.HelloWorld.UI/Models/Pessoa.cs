﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.HelloWorld.UI.Models
{
    public abstract class Pessoa
    {
        //Atributos
        private string _nome;
        private int _idade;

        //Propriedades (Getters e Setters)
        public Genero Genero { get; set; }

        public string Cpf { get; set; }

        public string Nome 
        { 
            get { return _nome; } 
            set { _nome = value; } 
        }

        public int Idade
        {
            get { return _idade; }
            set { _idade = value; }
        }

        //Métodos
        public abstract void Trabalhar();

        //virtual -> permite a sobrescrita
        public virtual void Andar()
        {
            Console.WriteLine("Pessoa andando");
        }

        public void Andar(string destino)
        {
            //validar se o destino existe, se não existir lançar uma exception

            Console.WriteLine($"Andando até {destino}");
        }
    }//class

    public enum Genero
    {
        Masculino, Feminino, Outros
    }

}//namespace
