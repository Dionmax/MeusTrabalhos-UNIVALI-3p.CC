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
	
}
