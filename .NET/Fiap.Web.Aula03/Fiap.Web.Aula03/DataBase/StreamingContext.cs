using Fiap.Web.Aula03.Models;
using Microsoft.EntityFrameworkCore;

namespace Fiap.Web.Aula03.DataBase
{
    public class StreamingContext : DbContext
    {
        public DbSet<Filme> Filmes { get; set; }
        public StreamingContext(DbContextOptions op):base(op)
        {
        }
    }
}
