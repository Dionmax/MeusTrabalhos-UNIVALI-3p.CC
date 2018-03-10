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
	bool EspacoLivre = true;

	Elemento * novo = new Elemento;

	novo->musica = musica;

	if (novo == NULL)
		EspacoLivre = false;
	else
	{
		novo->proxima = lista.inicio;
		lista.inicio = novo;
		lista.quantidade++;
	}

	return EspacoLivre;
}

bool insirirFinalDaLista(Playlist & lista, ListaMusicas musica)
{
	bool EspacoLivre = true;

	if (lista.quantidade == 0)
		insirirInicioDaPlaylistEscadeada(lista, musica);

	Elemento * novo = new Elemento;

	if (novo == NULL)
		EspacoLivre = false;
	else
	{
		novo->musica = musica;
		novo->proxima = NULL;

		Elemento * ultimo;

		ultimo->proxima = lista.inicio;

		while (ultimo->proxima != NULL)
			ultimo = ultimo->proxima;

		ultimo->proxima = novo;

		lista.quantidade++;
	}

	return EspacoLivre;
}

bool removerInicioPlaylistEncadeada(Playlist & lista, ListaMusicas musica)
{

}

