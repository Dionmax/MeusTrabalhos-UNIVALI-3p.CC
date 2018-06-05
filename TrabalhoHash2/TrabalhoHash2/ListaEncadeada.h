#pragma once
#include <iostream>
#include "string"

using namespace std;

template<typename T>
struct Elemento
{
	T objeto;

	Elemento * proxima;
};

template<typename T>
struct Lista
{
	Elemento<T> * inicio;
	int quantidade;
};

template<typename T>
void inicializar(Lista<T> & lista)
{
	lista.inicio = NULL;
	lista.quantidade = 0;
}

template<typename T>
bool inserirInicioDaEncadeada(Lista<T> & lista, T obj)
{
	bool espacoLivre = true;

	Elemento<T> * novo = new Elemento<T>;

	novo->objeto = obj;

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

template<typename T>
bool inserirFinalDaLista(Lista<T> &lista, T obj, int &instrucoes)
{
	bool espacoLivre = true;

	if (lista.quantidade == 0)
	{
		instrucoes++;
		inserirInicioDaEncadeada(lista, obj);
	}

	Elemento<T> *novo = new Elemento<T>;

	novo->objeto = obj;
	novo->proxima = NULL;


	if (novo == NULL)
		espacoLivre = false;
	else
	{
		Elemento<T> * ultimo;

		ultimo = lista.inicio;

		while (ultimo->proxima != NULL)
		{
			instrucoes++;
			ultimo = ultimo->proxima;
		}

		ultimo->proxima = novo;

		lista.quantidade++;
	}

	return espacoLivre;
}

template<typename T>
bool removerInicioListaEncadeada(Lista<T> & lista)
{
	bool espacoLivre = true;

	Elemento<T> * GuardarPrimeiraPosicao;

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

template<typename T>
bool removerFimDaLista(Lista<T> & lista)
{
	bool espacoLivre = true,
		achou = false;

	Elemento<T> * ultimo, *penultimo;

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

		delete ultimo;

		lista.quantidade--;
	}

	return espacoLivre;
}

template<typename T>
void imprimirListaEncadeada(Lista<T> lista)
{
	Elemento<T> * comecoLista;

	if (lista.inicio == NULL)
		return;

	comecoLista = lista.inicio;

	while (comecoLista != NULL)
	{
		cout << comecoLista->objeto << endl;
		comecoLista = comecoLista->proxima;
	}
}

//Função Personalizada para esse trabalho.
template<typename T>
void pesquisarListaE(Lista<T> lista, T objeto, int &instrucoes)
{
	Elemento<T> * comecoLista;

	if (lista.inicio == NULL)
		return;

	comecoLista = lista.inicio;

	while (comecoLista != NULL)
	{
		if (comecoLista->objeto == objeto)
			return;

		instrucoes++;

		comecoLista = comecoLista->proxima;
	}
}
