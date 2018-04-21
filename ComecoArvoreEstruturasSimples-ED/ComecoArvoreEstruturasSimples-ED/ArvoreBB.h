#pragma once
#include <iostream>
#include <string>

using namespace std;

template<typename T>
struct TNodoABB
{
	int chave;

	T objeto;

	TNodoABB *menor,
		*maior;
};

template<typename T>
struct TABB
{
	TNodoABB<T> *raiz;
	int quantidade;
};

template<typename T>
void inicializarABB(TABB<T> & arvore)
{
	arvore.raiz = NULL;
	arvore.quantidade = 0;
}

template<typename T>
bool insirirABB_it(TABB<T> & arvore, int novoChave, T obj)
{
	bool verificacao = false;

	TNodoABB<T> *novo = new TNodoABB<T>;

	TNodoABB<T> *aux_raiz;

	novo->objeto = obj;
	novo->maior = NULL;
	novo->menor = NULL;
	novo->chave = novoChave;

	if (novo != NULL)
		verificacao = true;

	if (arvore.quantidade == 0)
		arvore.raiz = novo;
	else
	{
		aux_raiz = arvore.raiz;

		while (aux_raiz->menor != NULL && aux_raiz->maior != NULL)
		{
			if (aux_raiz->chave < novoChave)
				if (aux_raiz->menor != NULL)
					aux_raiz = aux_raiz->menor;
				else
					aux_raiz->menor = novo;
			else
				if (aux_raiz->maior != NULL)
					aux_raiz = aux_raiz->maior;
				else
					aux_raiz->maior = novo;
		}

		arvore.quantidade++;
	}

	return verificacao;
}
