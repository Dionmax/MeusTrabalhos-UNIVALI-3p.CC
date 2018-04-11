#pragma once
#include <iostream>
#include <string>

using namespace std;

template<typename T>
struct ElementoP
{
	T objeto;

	ElementoP <T> *debaixo;
};

template<typename T>
struct Pilha
{
	ElementoP <T> *topo;

	int quantidade;
};

template<typename T>
void inicializarPilha(Pilha<T> &torreP)
{
	torreP.topo = NULL;
	torreP.quantidade = 0;
}

template<typename T>
bool push(Pilha<T> &torreP, T obj)
{
	bool verificacao = false;

	ElementoP<T> *novo = new ElementoP<T>;

	if (novo != NULL)
		verificacao = true;

	novo->objeto = obj;

	novo->debaixo = torreP.topo;

	torreP.topo = novo;

	torreP.quantidade++;

	return verificacao;
}

template<typename T>
bool pop(Pilha<T> &torreP)
{
	bool verificacao = false;

	ElementoP<T> *aux;

	if (torreP.quantidade > 0)
	{
		aux = torreP.topo;

		torreP.topo = aux.debaixo;

		delete aux;

		torreP.quantidade--;

		verificacao = true;
	}

	return verificacao;
}

