#pragma once
#include <iostream>
#include <string>

using namespace std;

template<typename T>
class Heap
{
	pair<int, T> arrayPrincipal[100];
	int quantidade = 0;

public:
	Heap();
	~Heap();

	int getTopo();
	void inserir(int chave, T dado);
	void deletarTopo();
	void alterarChave(T dado, int chave);
	void toStringChave();

private:
	int getPai(int indice);
	int getFilhoEsquerda(int indice);
	int getFilhoDireita(int indice);

	void heapify_up(int indice);
	void heapify_down(int indice);

	void deletar(int posicao);
};


template<typename T>
inline Heap<T>::Heap()
{
}

template<typename T>
inline Heap<T>::~Heap()
{
}

template<typename T>
inline int Heap<T>::getTopo()
{
	if (this->arrayPrincipal[0].first != NULL)
		return this->arrayPrincipal[0].first;
}

template<typename T>
inline int Heap<T>::getPai(int indice)
{
	return (indice - 1) / 2;
}

template<typename T>
inline int Heap<T>::getFilhoEsquerda(int indice)
{
	return (indice * 2) + 1;
}

template<typename T>
inline int Heap<T>::getFilhoDireita(int indice)
{
	return (indice * 2) + 2;
}

template<typename T>
inline void Heap<T>::heapify_up(int indice)
{
	if (indice == 0) return;

	int pai_aux = this->getPai(indice);

	if (this->arrayPrincipal[indice].first > arrayPrincipal[pai_aux].first)
	{
		swap(this->arrayPrincipal[indice], this->arrayPrincipal[pai_aux]);

		this->heapify_up(pai_aux);
	}
}

template<typename T>
inline void Heap<T>::heapify_down(int indice)
{
	int direita_aux = this->getFilhoDireita(indice);
	int esquerda_aux = this->getFilhoEsquerda(indice);

	int maior = indice;

	if (direita_aux <= this->quantidade && this->arrayPrincipal[direita_aux].first > this->arrayPrincipal[indice].first)
		maior = direita_aux;

	if (esquerda_aux <= this->quantidade && this->arrayPrincipal[esquerda_aux].first > this->arrayPrincipal[indice].first)
		maior = esquerda_aux;

	if (maior != indice)
	{
		swap(this->arrayPrincipal[indice], this->arrayPrincipal[maior]);

		this->heapify_down(maior);
	}
}

template<typename T>
inline void Heap<T>::inserir(int chave, T dado)
{
	this->arrayPrincipal[this->quantidade].first = chave;
	this->arrayPrincipal[this->quantidade].second = dado;

	this->heapify_up(this->quantidade);

	this->quantidade++;
}

template<typename T>
inline void Heap<T>::deletarTopo()
{
	this->deletar(0);
}

template<typename T>
inline void Heap<T>::alterarChave(T dado, int chave)
{
	for (int indice = 0; indice < this->quantidade; indice++)
		if (this->arrayPrincipal[indice].second == dado)
		{
			this->arrayPrincipal[indice].first = chave;

			this->heapify_down(this->getPai(indice));
			this->heapify_up(this->getPai(indice));

			return;
		}
}

template<typename T>
inline void Heap<T>::deletar(int posicao)
{
	if (this->quantidade < 1)
		return;

	swap(this->arrayPrincipal[posicao], this->arrayPrincipal[this->quantidade - 1]);

	this->quantidade--;

	this->heapify_down(posicao);
}

template<typename T>
inline void Heap<T>::toStringChave()
{
	for (int indice = 0; indice < this->quantidade; indice++)
		cout << arrayPrincipal[indice].first << "|";

	cout << endl;
}
