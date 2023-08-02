// See https://aka.ms/new-console-template for more information
using Fiap.HelloWorld.UI.Models;

Console.WriteLine("Hello, World!");

// Instanciar Aluno
Aluno aluno = new Aluno();

// Atribuir nome
aluno.Nome = "Yuji";
aluno.Idade = 27;
aluno.Cpf = "418579968";

// Exibir nome
Console.WriteLine(aluno.Nome);
