#pragma once
#include <iostream>
#include <string>

using namespace std;

template <typename T>
struct Elemento
{
	T objeto;

	Elemento *proxima;
};

template <typename T>
struct ListaObjetos
{
	Elemento <T> *inicio;

	int quantidade;
};

template <typename T>
void inicializarListaEncadeada(ListaObjetos <T>&lista)
{
	lista.inicio = NULL;

	lista.quantidade = 0;
}

template <typename T>
bool insirirComecoListaEncadeada(ListaObjetos <T>&lista, T obj)
{
	bool verificacao = true;

	Elemento<T> *novo = new Elemento<T>;

	if (novo == NULL)
		verificacao = false;
	else
	{
		novo->objeto = obj;

		novo->proxima = lista.inicio;

		lista.inicio = novo;

		lista.quantidade++;
	}

	return verificacao;
}

template <typename T>
bool removerComecoListaEncadeada(ListaObjetos <T>&lista)
{
	bool verificacao = true;

	Elemento<T> *aux;

	if (lista.quantidade == 0)
		verificacao = false;
	else
	{
		aux = lista.inicio;

		lista.inicio = aux->proxima;

		delete aux;

		lista.quantidade--;
	}

	return verificacao;
}

template <typename T>
bool insirirFimListaEncadeada(ListaObjetos <T>&lista, T obj)
{
	bool verificacao = true;

	Elemento<T> *novo = new Elemento<T>, *ultimo;

	if (lista.quantidade == 0)
		insirirComecoListaEncadeada(lista, obj);

	if (novo == NULL)
		verificacao = false;
	else
	{
		novo->objeto = obj;

		novo->proxima = NULL;

		ultimo = lista.inicio;

		while (ultimo->proxima != NULL)
			ultimo = ultimo->proxima;

		ultimo->proxima = novo;

		lista.quantidade++;
	}

	return verificacao;
}

template <typename T>
bool removerFinalListaEncadeada(ListaObjetos <T>&lista)
{
	bool verificacao = true,
		achou = false;

	Elemento<T> *ultimo, *penultimo;

	ultimo = lista.inicio;

	if (lista.quantidade == 0)
		verificacao = false;
	else
	{
		do
		{
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

	return verificacao;
}

template <typename T>
bool insirirPosicaoListaEncadeada(ListaObjetos <T>&lista, T obj, int posicao)
{
	bool verificacao = true;

	Elemento<T> *novo = new Elemento<T>, *aux;

	novo->objeto = obj;

	if (posicao == 0)
		insirirComecoListaEncadeada(lista, obj);

	if (posicao > lista.quantidade || posicao <= 0 || novo == NULL)
		verificacao = false;
	else
	{
		aux = lista.inicio;

		//Gambiarra Made for Dion =D (-1)
		for (int indice = 0; indice < posicao - 1; indice++)
			aux = aux->proxima;

		novo->proxima = aux->proxima;

		aux->proxima = novo;

		lista.quantidade++;
	}

	return verificacao;
}

template <typename T>
bool removerPosicaoListaEncadeada(ListaObjetos <T>&lista, int posicao)
{
	bool verificacao = true;

	Elemento<T> *aux, *aux_dois;

	if (posicao == 0)
		removerComecoListaEncadeada(lista);

	if (posicao > lista.quantidade || posicao <= 0)
		verificacao = false;
	else
	{
		aux = lista.inicio;

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
void bubblesortListaEncadeada(ListaObjetos <T>&lista)
{
	Elemento<T> *comparador = lista.inicio;


	for (int indicador = 0; indicador < lista.quantidade; indicador++)
	{
		for (int indice = 0; indice < lista.quantidade - 1; indice++)
		{
			if (comparador->objeto > comparador->proxima->objeto)
				trocarPosicoes(comparador->objeto, comparador->proxima->objeto);

			comparador = comparador->proxima;
		}

		comparador = lista.inicio;
	}
}

/*
template <typename T>
ListaObjetos<T> listaMerge(ListaObjetos <T>&lista_um, ListaObjetos <T>&lista_dois)
{
	ListaObjetos<T> comeco,
		*lista_aux = &comeco;

	while (lista_um && lista_dois)
		if (lista_um.inicio->objeto < lista_dois.inicio->objeto)
		{
			lista_aux->inicio->proxima = lista_um.inicio;

			lista_aux->inicio = lista_um.inicio;

			lista_dois.inicio = lista_um.inicio->proxima;
		}
		else
		{
			lista_aux->inicio->proxima = lista_dois.inicio;

			lista_aux->inicio = lista_dois.inicio;

			lista_dois.inicio = lista_dois.inicio->proxima;
		}

	lista_aux->inicio->proxima = (!lista_um) ? lista_dois : lista_um;
}

template <typename T>
ListaObjetos<T> mergeSort(ListaObjetos <T>&lista)
{
	ListaObjetos<T> *lista_aux_um, *lista_aux_dois;

	if (!lista.inicio || !lista.inicio->proxima)
		return lista;

	lista_aux_um->inicio = lista.inicio;
	lista_aux_dois->inicio = lista.inicio->proxima;

	while (lista_aux_dois->inicio && lista_aux_dois->inicio->proxima)
	{
		lista.inicio = lista.inicio->proxima;

		lista_aux_dois->inicio = lista_aux_dois->inicio->proxima->proxima;
	}

	lista_aux_dois->inicio = lista.inicio->proxima;

	lista.inicio->proxima = NULL;

	return listaMerge(*lista_aux_um, *lista_aux_dois);
}

*/

template <typename T>
void imprimirListaEncadeada(ListaObjetos <T>lista)
{
	for (int indice = 0; indice < lista.quantidade; indice++)
	{
		cout << lista.inicio->objeto << endl;

		lista.inicio = lista.inicio->proxima;
	}

	cout << endl;
}
