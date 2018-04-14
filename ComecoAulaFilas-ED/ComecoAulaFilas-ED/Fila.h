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
void inicializarFila(TFila<T> fila)
{
	fila.inicio = NULL;
	fila.fim = NULL;
	fila.quantidade = 0;
}

template<typename T>
bool enfileirar(TFila<T> fila, T obj)
{
	bool verificacao = false;

	ElementoF<T> *novo = new ElementoF<T>;

	if (novo != NULL)
		verificacao = true;

	novo->objeto = obj;

	novo->proximo = NULL;

	fila.fim->proximo = novo;

	fila.fim = novo;

	fila.quantidade++;

	return verificacao;
}
