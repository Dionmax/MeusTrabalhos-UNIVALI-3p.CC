using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using minicurso1907.Controllers.Database;
using minicurso1907.Models;

namespace minicurso1907.Controllers
{
    public class FilmeController : Controller
    {
        Minicurso1907Context _minicurso1907Context;

        public FilmeController(Minicurso1907Context minicurso1907Context)
        {
            _minicurso1907Context = minicurso1907Context;
        }

        // GET: Filme
        public ActionResult Index()
        {
            List<Filme> filmes = _minicurso1907Context.Filmes.ToList();

            return View(filmes);
        }

        // GET: Filme/Details/5
        public ActionResult Details(int id)
        {
            List<Filme> filmes = ObterFilmes();

            Filme filme = filmes.Where(f => f.ID == id).First();

            return View(filme);
        }

        // GET: Filme/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Filme/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create(Filme filme)
        {
            try
            {
                _minicurso1907Context.Add(filme);
                _minicurso1907Context.SaveChanges();

                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: Filme/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Filme/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit(int id, IFormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        // GET: Filme/Delete/5
        public ActionResult Delete(int id)
        {

            Filme filme = _minicurso1907Context.Filmes.First(f => f.ID == id);

            return View(filme);
        }

        // POST: Filme/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Delete(int id, Filme filme)
        {
            try
            {
                _minicurso1907Context.Remove(filme);
                _minicurso1907Context.SaveChanges();

                return RedirectToAction(nameof(Index));
            }
            catch
            {
                return View();
            }
        }

        public List<Filme> ObterFilmes()
        {
            List<Filme> filmes = new List<Filme>();

            filmes.Add(new Filme
            {
                ID = 1,
                Titulo = "Bolt",
                UrlCapa = "https://3.bp.blogspot.com/-u6ZEd1oYOIc/TtFdQpdg3DI/AAAAAAAABDg/OOHGLFXUk-g/s1600/bolt.jpg",
                Elenco = "Bolt e amigos",
                Genero = "Romance",
                Sinopse = "Altas aventuras com seus amiguinhos",
                Status = Models.Enum.StatusFilme.Planejado,
                AssistidoEm = new DateTime(2018, 12, 25)
            });

            filmes.Add(new Filme
            {
                ID = 2,
                Titulo = "Turma da monica",
                UrlCapa = "http://newscom.inf.br/Uploads/noticias/zoom_ca615e65410e9cdbefd165110560211a.jpg",
                Elenco = "Cebolinha e Monica",
                Genero = "Adulto, romance",
                Sinopse = "Entre quatro paredes, nada se comenta",
                Status = Models.Enum.StatusFilme.Assistido,
                AssistidoEm = DateTime.Now
            });

            filmes.Add(new Filme
            {
                ID = 3,
                Titulo = "Minecraft",
                UrlCapa = "https://i.ytimg.com/vi/vIKcI_ISfXM/maxresdefault.jpg",
                Elenco = "Steve e isolados",
                Genero = "Tristeza em conjunto",
                Sinopse = "Perdidos numa ilha",
                Status = Models.Enum.StatusFilme.Assistido,
                AssistidoEm = DateTime.Now
            });

            return filmes;
        }
    }
}