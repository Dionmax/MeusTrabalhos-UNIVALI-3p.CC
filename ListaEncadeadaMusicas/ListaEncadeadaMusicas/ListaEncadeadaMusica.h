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
	bool espacoLivre = true;

	Elemento * novo = new Elemento;

	novo->musica = musica;

	if (novo == NULL)
		espacoLivre = false;
	else
	{
		novo->proxima = lista.inicio;
		lista.inicio = novo;
		lista.quantidade++;
	}

	return espacoLivre;
}

bool insirirFinalDaLista(Playlist & lista, ListaMusicas musica)
{
	bool espacoLivre = true;

	if (lista.quantidade == 0)
		insirirInicioDaPlaylistEscadeada(lista, musica);

	Elemento * novo = new Elemento;

	novo->musica = musica;
	

	if (novo == NULL)
		espacoLivre = false;
	else
	{
		Elemento * ultimo;

		ultimo = lista.inicio;

		while (ultimo->proxima != NULL)
			ultimo = ultimo->proxima;

		ultimo->proxima = novo;

		lista.quantidade++;
	}

	novo->proxima = NULL;

	return espacoLivre;
}

bool removerInicioPlaylistEncadeada(Playlist & lista, ListaMusicas musica)
{
	bool espacoLivre = true;

	Elemento * GuardarPrimeiraPosicao;

	if (lista.quantidade == 0)
		espacoLivre = false;
	else
	{
		GuardarPrimeiraPosicao = lista.inicio;

		lista.inicio = GuardarPrimeiraPosicao->proxima;

		delete GuardarPrimeiraPosicao;

		lista.quantidade--;
	}

	return espacoLivre;
}

bool removerFimDaLista(Playlist & lista)
{
	bool espacoLivre = true,
		achou = false;

	Elemento * ultimo, *penultimo;

	ultimo = lista.inicio;

	if (ultimo == NULL)
		espacoLivre = false;
	else
	{
		do {
			
			penultimo = ultimo;

			if (ultimo->proxima != NULL)
				ultimo = ultimo->proxima;
			else
				achou = true;

		} while (!achou);

		penultimo->proxima = NULL;

		//delete ultimo;

		lista.quantidade--;
	}

	return espacoLivre;
}

void imprimirListaEncadeada(Playlist lista)
{
	Elemento * comecoLista;

	comecoLista = lista.inicio;

	do
	{
		cout << comecoLista->musica.artista << " -- ";
		cout << comecoLista->musica.titulo << endl;

		comecoLista = comecoLista->proxima;
	} while (comecoLista->proxima != NULL);
	
}

