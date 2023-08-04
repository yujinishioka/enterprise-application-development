using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.HelloWorld.UI.Models
{
    public class Animal
    {
        public string Porte { get; set; }
        public int Idade { get; set; }
        public int Peso { get; set; }

        public Animal(float peso, int idade) 
        {
            float Peso = peso;
            int Idade = idade;
        }
    }
}
