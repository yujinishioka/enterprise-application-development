using Microsoft.AspNetCore.Mvc;
using Fiap.Web.Aula02.Models;

namespace Fiap.Web.Aula02.Controllers
{
    public class VeiculoController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public IActionResult Cadastrar() {
            return View();
        }

        [HttpPost]
        public IActionResult Cadastrar(Veiculo veiculo)
        {
            return View();
        }
    }
}
