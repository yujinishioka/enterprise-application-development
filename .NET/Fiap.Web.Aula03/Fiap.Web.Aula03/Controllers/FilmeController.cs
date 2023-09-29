using Fiap.Web.Aula03.DataBase;
using Microsoft.AspNetCore.Mvc;

namespace Fiap.Web.Aula03.Controllers
{
    public class FilmeController : Controller
    {
        private StreamingContext _context;

        public FilmeController(StreamingContext context)
        {
            _context = context;
        }

        public IActionResult Index()
        {
            return View();
        }
    }
}
