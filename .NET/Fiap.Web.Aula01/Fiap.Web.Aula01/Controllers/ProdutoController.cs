<<<<<<< HEAD
﻿using Microsoft.AspNetCore.Mvc;
=======
﻿using Fiap.Web.Aula01.Models;
using Microsoft.AspNetCore.Mvc;
>>>>>>> 6fda4b618f2845b9603c69e40d131ad0c78fa69f

namespace Fiap.Web.Aula01.Controllers
{
    public class ProdutoController : Controller
    {
        public IActionResult Index()
        {            
            return View();
<<<<<<< HEAD
        }    

        //Método que recebe os dados do formulário

=======
        }

        //Método que recebe os dados do formulário
        [HttpPost]
        public IActionResult Cadastrar(Produto produto)
        {
            //Enviar um valor para a view
            ViewData["churros"] = produto.Nome;
            ViewBag.Produto = produto;
            return View();
            //Retorna um texto para o browser
            //return Content($"Nome: {produto.Nome} e Preço: {produto.Preco}");
        }
>>>>>>> 6fda4b618f2845b9603c69e40d131ad0c78fa69f
    }
}
