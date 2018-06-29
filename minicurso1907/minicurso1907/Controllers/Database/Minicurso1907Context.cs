using Microsoft.EntityFrameworkCore;
using minicurso1907.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace minicurso1907.Controllers.Database
{
    public class Minicurso1907Context : DbContext
    {
        public Minicurso1907Context(DbContextOptions<Minicurso1907Context> options)
            : base(options)
        {
            
        }

        public DbSet<Filme> Filmes { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Filme>()
                .HasKey(f => f.ID);

            modelBuilder.Entity<Filme>()
               .Property(x => x.Titulo)
               .HasMaxLength(50);

            base.OnModelCreating(modelBuilder);
        }
    }
}
