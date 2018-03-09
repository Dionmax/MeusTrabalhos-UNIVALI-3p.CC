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

bool insirirInicioDaPlaylistEscadeada(Playlist & lista, ListaMusicas musica)
{
	bool EspacoLivre = false;

	Elemento * novo = new Elemento;

	novo->musica = musica;

	if (novo != NULL)
		EspacoLivre = true;

	novo->proxima = lista.inicio;

	lista.inicio = novo;
	lista.quantidade++;

	return EspacoLivre;
}

