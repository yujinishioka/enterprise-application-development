﻿using Fiap.Web.Aula03.DataBase;
using Fiap.Web.Aula03.Models;
using Microsoft.AspNetCore.Mvc;

namespace Fiap.Web.Aula03.Controllers
{
    public class FilmeController : Controller
    {        
        private StreamingContext _context;

        //O contexto é injetado no construtor
        public FilmeController(StreamingContext context)
        {
            _context = context;
        }

        [HttpPost]
        public IActionResult Remover(int id)
        {
            //Pesquisar o filme
            var filme = _context.Filmes.Find(id);
            //Remove o filme
            _context.Filmes.Remove(filme);
            _context.SaveChanges();
            //Mensagem de sucesso
            TempData["msg"] = "Filme removido!";
            //Redireciona para a index
            return RedirectToAction("Index");
        }

        [HttpGet]
        public IActionResult Editar(int id)
        {
            //Pesquisar o filme pelo Id
            var filme = _context.Filmes.Find(id);
            //Retorar a view com o objeto filme
            return View(filme);
        }

        [HttpPost]
        public IActionResult Editar(Filme filme)
        {
            //Atualizar o filme no banco de dados
            _context.Filmes.Update(filme);
            _context.SaveChanges();
            //Enviar uma para a view
            TempData["msg"] = "Filme atualizado!";
            //Redirecionar para a listagem
            return RedirectToAction("Index");
        }

        public IActionResult Index(string termoBusca)
        {
            //Pesquisar por parte do titulo
            var lista = _context.Filmes
                    .Where(f => f.Titulo.Contains(termoBusca) || termoBusca == null)
                    .ToList();
            return View(lista);
        }

        [HttpGet]
        public IActionResult Cadastrar()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Cadastrar(Filme filme)
        {
            _context.Filmes.Add(filme);
            _context.SaveChanges();
            TempData["msg"] = "Filme registrado!";
            return RedirectToAction("Cadastrar");
        }

    }
}
