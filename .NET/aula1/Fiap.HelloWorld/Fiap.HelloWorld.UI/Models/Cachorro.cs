using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.HelloWorld.UI.Models
{
    public class Cachorro: Animal
    {
        public string Raca { get; set; }
        public string Nome { get; set; }
        public string Dono { get; set; }

        // Construtor
        public Cachorro(float peso, int idade) : base(peso, idade) 
        { 
        
        }

        public Cachorro(float peso, int idade, string nome) : base(peso, idade)
        {
            Nome = nome;
        }
    }
}
