#pragma once

#include <iostream>
#include <string>

template<typename T>
struct TnodoSBB
{
	int chave;

	T dado;

	TnodoSBB<T> *menor;
	TnodoSBB<T> *maior;

	char orientacaoMenor;
	char orientacaoMaior;
};

template<typename T>
struct TSBB
{
	TnodoSBB<T> * raiz;
	int quantidade;
};

template<typename T>
int insiridadeSBB(TnodoSBB<T> *& nodo, int chave, T dado)
{
	if (nodo == NULL)
	{
		nodo = new TnodoSBB<T>;
		nodo->chave = chave;
		nodo->dado = dado;
		nodo->maior = NULL;
		nodo->menor = NULL;
		nodo->orientacaoMaior = NULL;
		nodo->orientacaoMenor = NULL;
		return 0;
	}
	else
	{
		if (chave > nodo->chave)
		{
			int r = insiridadeSBB(nodo->maior, chave, dado);

			if (r == 1)
			{
				nodo->orientacaoMaior = 'h';
				r++;
			}
			else if (r == 2 && nodo->orientacaoMaior == 'h')
			{
				if (chave > nodo->menor->chave)
					dirdir(nodo); // projeto de algoritomos de Nivio Ziviani
				else
					diresq(nodo);

				r = 1;
			}

			// Fazer para o esquerda;

			return r;
		}
	}
}

