#pragma once
#include <iostream>
#include <string>

template <typename T>
struct ElementoDE
{
	T objeto;

	ElementoDE *proxima, *anterior;
};

template <typename T>
struct ListaDE
{
	ElementoDE<T> *inicio, *fim;

	int quantidade;
};

template <typename T>
void inicializarListaDE(ListaDE<T> &lista)
{
	lista.inicio = NULL;
	lista.fim = NULL;

	lista.quantidade = 0;
}

template <typename T>
bool insirirComecoListaDE(ListaDE<T> &lista, T obj)
{
	bool verificacao = true;

	ElementoDE<T> * novo = new ElementoDE<T>;

	novo->objeto = obj;

	if (novo == NULL)
		verificacao = false;
	else
	{
		novo->anterior = NULL;

		novo->proxima = lista.inicio;

		lista.inicio = novo;

		if (lista.quantidade == 0)
			lista.fim = novo;
		else
			lista.inicio->proxima->anterior = novo;

		lista.quantidade++;
	}

	return verificacao;
}

template <typename T>
bool removerInicioDaListaDE(ListaDE<T> &lista)
{
	bool verificacao = true;

	ElementoDE<T> * aux;

	aux = lista.inicio;

	if (lista.quantidade == 0)
		verificacao = false;
	else
	{
		lista.inicio = aux->proxima;
		aux->proxima->anterior = NULL;

		delete aux;

		lista.quantidade--;
	}
	return verificacao;
}

template <typename T>
bool insirirFinalDaListaDE(ListaDE<T> &lista, T obj)
{
	bool verificacao = true;

	ElementoDE<T> * novo = new ElementoDE<T>;

	novo->objeto = obj;

	if (novo == NULL)
		verificacao = false;
	else
	{
		novo->proxima = NULL;

		novo->anterior = lista.fim;

		if (lista.quantidade > 0)
			lista.fim->proxima = novo;
		else
			lista.inicio = novo;

		lista.fim = novo;
		lista.quantidade++;
	}

	return verificacao;
}

template <typename T>
bool removerFinalListaDE(ListaDE<T> &lista)
{
	bool verificacao = true;

	ElementoDE<T> * aux;

	aux = lista.fim;

	if (lista.quantidade == 0)
		verificacao = false;
	else
	{
		lista.fim = aux->anterior;

		aux->anterior->proxima = NULL;

		delete aux;

		lista.quantidade--;
	}

	return verificacao;
}

template <typename T>
bool insirirPosicaoListaDE(ListaDE<T> &lista, T obj, int posicao)
{
	bool verificacao = true;

	ElementoDE<T> * novo = new ElementoDE<T>,
		*aux;

	if (posicao == 0)
		insirirComecoListaDE(lista, obj);

	novo->objeto = obj;

	if (novo == NULL)
		verificacao = false;
	else
	{
		aux = lista.inicio;

		for (int indice = 0; indice < posicao - 1; indice++)
			aux = aux->proxima;

		novo->anterior = aux;

		novo->proxima = aux->proxima;

		aux->proxima->anterior = novo;

		aux->proxima = novo;

		lista.quantidade++;
	}

	return verificacao;
}

template <typename T>
bool removerPosicaoListaDE(ListaDE<T> &lista, int posicao)
{
	bool verificacao = true;

	ElementoDE<T> * aux, *aux_dois;

	if (posicao == 0)
		removerInicioDaListaDE(lista);
	else if (posicao == lista.quantidade - 1)
		removerFinalListaDE(lista);

	aux = lista.inicio;

	if (posicao > lista.quantidade || posicao == 0 || posicao == lista.quantidade - 1)
		verificacao = false;
	else
	{
		for (int indice = 0; indice < posicao - 1; indice++)
			aux = aux->proxima;

		aux_dois = aux->proxima;

		aux->proxima = aux->proxima->proxima;

		delete aux_dois;

		lista.quantidade--;
	}

	return verificacao;
}

template <typename T>
void trocarPosicoes(T &objeto_um, T &objeto_dois)
{
	T objeto_aux = objeto_um;

	objeto_um = objeto_dois;
	objeto_dois = objeto_aux;
}

template <typename T>
void bubblesortListaDE(ListaDE<T> &lista)
{
	ElementoDE<T> *aux;

	aux = lista.inicio;

	for (int indice = 0; indice < lista.quantidade; indice++)
	{
		for (int indicador = 0; indicador < lista.quantidade - 1; indicador++)
		{
			if (aux->objeto > aux->proxima->objeto)
				trocarPosicoes(aux->objeto, aux->proxima->objeto);

			aux = aux->proxima;
		}
		aux = lista.inicio;
	}
}

template <typename T>
void imprimirListaDE(ListaDE<T> lista)
{
	ElementoDE<T> * novo;

	novo = lista.inicio;

	for (int indice = 0; indice < lista.quantidade; indice++)
	{
		cout << novo->objeto << endl;

		novo = novo->proxima;
	}

	cout << endl;
}
