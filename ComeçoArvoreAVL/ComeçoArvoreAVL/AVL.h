#pragma once

#include <iostream>

using namespace std;

template<typename T>
struct TNodoAVL
{
	int chave;

	T dado;
	TNodoAVL *maior;
	TNodoAVL *menor;

	int bal;
};

template<typename T>
struct TAVL
{
	TNodoAVL<T> *raiz;
	int quantidade;
};

template<typename T>
void inicializarAVL(TAVL<T> &arvore)
{
	arvore.raiz = NULL;
	arvore.quantidade = 0;
}

template<typename T>
int inserirAVL(TNodoAVL<T> *&nodo, int chave, T dado)
{
	if (nodo == NULL) {
		nodo = new TNodoAVL<T>;
		nodo->chave = chave;
		nodo->dado = dado;
		nodo->maior = NULL;
		nodo->menor = NULL;
		nodo->bal = 0;
		return 1;
	}

	if (chave > nodo->chave) //Direita <-
	{

		int balanceamento = inserirAVL(nodo->maior, chave, dado);

		nodo->bal += b;

		if (nodo->bal == 2)
		{
			if (chave > nodo->menor->chave)
				dirdir(nodo);
			else
				diresq(nodo);

			balanceamento = 0;
		}

		if (nodo->bal == 0)
			balanceamento = 0;

		return balanceamento;
	}

	if (chave < nodo->chave) //Esquerda <-
	{

		int balanceamento = inserirAVL(nodo->maior, chave, dado);

		nodo->bal += b;

		if (nodo->bal == 2)
		{
			if (chave > nodo->menor->chave)
				dirdir(nodo);
			else
				diresq(nodo);

			balanceamento = 0;
		}

		if (nodo->bal == 0)
			balanceamento = 0;

		return balanceamento;
	}


}

template<typename T>
void dirdir(TNodoAVL<T> *&r) {

	// a recebe raiz

	TNodoAVL<T>* a = r;

	// b recebe sub-árvore a maioreita de a

	TNodoAVL<T>* b = a->maior;

	// e assim vai...

	a->maior = b->menor;

	b->menor = a;

	a->bal = 0;

	b->bal = 0;

	r = b;

}

template<typename T>
void diresq(TNodoAVL<T> *&r) {

	//a recebe raiz

	TNodoAVL<T> *a = r;

	//c recebe sub-árvore da maioreita da raiz

	TNodoAVL<T> *c = a->maior;

	// e assim vai...

	TNodoAVL<T> *b = c->menor;

	c->menor = b->maior;

	a->maior = b->menor;

	b->menor = a;

	b->maior = c;

	//refaz balanceamentos

	switch (b->bal) {

	case -1:

		a->bal = 0;

		c->bal = +1;

		break;

	case 0:

		a->bal = 0;

		c->bal = 0;

		break;

	case +1:

		a->bal = -1;

		c->bal = 0;

		break;

	}

	b->bal = 0;

	//reconfigura raiz

	r = b;

}

template<typename T>
void esqesq(TNodoAVL<T> *&r) {

	//b recebe raiz da sub-árvore

	TNodoAVL<T> * b = r;

	//a recebe sub-árvore da maioreita de b

	TNodoAVL<T> * a = b->menor;

	//... e assim vai...

	b->menor = a->maior;

	a->maior = b;


	//tanto a nova raiz quanto a antiga recebem zero no balanceamento

	a->bal = 0;

	b->bal = 0;

	r = a;

}

template<typename T>
void esqdir(TNodoAVL<T> *&r) {

	// c recebe  raiz

	TNodoAVL<T> *c = r;

	//a recebe sub-árvore da menoruerda da raiz

	TNodoAVL<T> *a = c->menor;

	//r recebe sub-árvore da maioreita de a

	TNodoAVL<T> *b = a->maior;

	// e assim vai...

	c->menor = b->maior;

	a->maior = b->menor;

	b->menor = a;

	b->maior = c;

	//refaz balanceamento dos nós

	switch (b->bal) {

	case -1:

		a->bal = 0;

		c->bal = 1;

		break;

	case 0:

		a->bal = 0;

		c->bal = 0;

		break;

	case +1:

		a->bal = -1;

		c->bal = 0;

		break;

	}

	b->bal = 0;

	//reconfigura raiz

	r = b;

}

