using System;
using Microsoft.EntityFrameworkCore.Migrations;

namespace minicurso1907.Migrations
{
    public partial class inicial1 : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Filmes",
                columns: table => new
                {
                    ID = table.Column<int>(nullable: false)
                        .Annotation("Sqlite:Autoincrement", true),
                    Titulo = table.Column<string>(maxLength: 50, nullable: true),
                    AssistidoEm = table.Column<DateTime>(nullable: false),
                    Status = table.Column<int>(nullable: false),
                    Genero = table.Column<string>(nullable: true),
                    Sinopse = table.Column<string>(nullable: true),
                    Elenco = table.Column<string>(nullable: true),
                    UrlCapa = table.Column<string>(nullable: true)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Filmes", x => x.ID);
                });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Filmes");
        }
    }
}
