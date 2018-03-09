#pragma once

#include <iostream>
#include "string"

using namespace std;

struct ListaMusicas
{
	string titulo;
	string artista;
};

struct Elemento
{
	ListaMusicas musica;

	Elemento * proxima;
};

struct Playlist
{
	Elemento * inicio;
	int quantidade;
};

void inicializar(Playlist & lista)
{
	lista.inicio = NULL;
	lista.quantidade = 0;
}

void insirirInicioDaPlaylistEscadeada(Playlist & lista, ListaMusicas musica)
{
	Elemento * novo = new Elemento;

	novo->musica = musica;
	novo->proxima = NULL;

	lista.inicio = novo;
	lista.quantidade++;
}

