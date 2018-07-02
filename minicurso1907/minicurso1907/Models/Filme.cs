using minicurso1907.Models.Enum;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace minicurso1907.Models
{
    public class Filme
    {
        public int ID { get; set; }

        [Display(Name = "Título")]
        [StringLength(50, ErrorMessage =  "O titulo deve conter 50 caracteres ou menos")]
        public string Titulo { get; set; }

        [Display(Name = "Assistido em")]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0: dd/MM/yyyy}")]
        public DateTime AssistidoEm { get; set; }

        [Display(Name = "Status do Filme")]
        public StatusFilme Status { get; set; }

        [Display(Name = "Genêro")]
        public string Genero { get; set; }


        public string Sinopse { get; set; }

        public string Elenco { get; set; }

        [Display(Name = "URL para imagem da capa")]
        public string UrlCapa { get; set; }
    }
}
