#pragma once
#include <iostream>
#include <string>

using namespace std;

struct ListaMusica
{
	string titulo,
		artista;
};

struct ElementoDE
{
	ListaMusica musica;

	ElementoDE *proximo,
		*anterior;
};

struct ListaDE
{
	ElementoDE *inicio,
		*fim;

	int quantiadade;
};

void inicializarListaDE(ListaDE &lista)
{
	lista.quantiadade = 0;
	lista.inicio = NULL;
	lista.fim = NULL;
}

bool inserirInicioDaListaDE(ListaDE &lista, ListaMusica musica)
{
	bool espacoLivre = true;

	ElementoDE *novo = new ElementoDE;

	if (novo != NULL)
	{
		novo->musica = musica;

		novo->anterior = NULL;

		novo->proximo = lista.inicio;

		lista.inicio = novo;

		if (lista.quantiadade == 0)
			lista.fim = novo;
		else
			lista.inicio->proximo->anterior = novo;

			lista.quantiadade++;
	}
	else
		espacoLivre = false;
	
	return espacoLivre;
}

bool inserirFimDaListaDE(ListaDE &lista, ListaMusica musica)
{
	bool espacoLivre = true;

	ElementoDE *novo = new ElementoDE;

	if (novo != NULL)
	{
		novo->musica = musica;

		novo->proximo = NULL;

		novo->anterior = lista.fim;

		if (lista.quantiadade > 0)
			lista.fim->proximo = novo;
		else
			lista.inicio = novo;

		lista.fim = novo;
		lista.quantiadade++;
	}
	else
		espacoLivre = false;

	return espacoLivre;
}

