// See https://aka.ms/new-console-template for more information
using Fiap.HelloWorld.UI.Models;

// Instanciar Aluno
Aluno aluno = new Aluno();

// Atribuir nome
aluno.Nome = "Yuji";
aluno.Idade = 27;
aluno.Cpf = "418579968";

// Exibir nome
Console.WriteLine(aluno.Nome);

// Instanciar um Cachorro
Cachorro dog = new Cachorro(15, 5, "Rex")
{
    Dono = "Yuji"
};

// Exibir
Console.WriteLine($"Nome: {dog.Nome}, Peso: {dog.Peso}, Dono: {aluno.Nome}");