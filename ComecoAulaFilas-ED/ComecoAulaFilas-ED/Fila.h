#pragma once
#include <iostream>
#include <string>

using namespace std;

template<typename T>
struct ElementoF
{
	T objeto;
	ElementoF<T> * proximo;
};

template<typename T>
struct TFila
{
	ElementoF<T> *inicio;
	ElementoF<T> *fim;
	int quantidade;
};

template<typename T>
void inicializarFila(TFila<T> &fila)
{
	fila.inicio = NULL;
	fila.fim = NULL;
	fila.quantidade = 0;
}

template<typename T>
bool enfileirar(TFila<T> &fila, T obj)
{
	bool verificacao = false;

	ElementoF<T> *novo = new ElementoF<T>;

	if (novo != NULL)
		verificacao = true;

	novo->objeto = obj;

	novo->proximo = NULL;

	if (fila.quantidade > 0)
		fila.fim->proximo = novo;
	else
		fila.fim = novo;

	fila.quantidade++;

	return verificacao;
}

template<typename T>
bool desenfileirar(TFila<T> &fila)
{
	bool verificacao = true;
	ElementoF<T> *aux;

	aux = fila.inicio;

	if (fila.quantidade == 0)
		verificacao = false;
	else
	{
		fila.inicio = fila.inicio->proximo;

		delete aux;

		if (fila.quantidade == 1)
			fila.fim = NULL;

		fila.quantidade--;
	}

	return verificacao;
}
