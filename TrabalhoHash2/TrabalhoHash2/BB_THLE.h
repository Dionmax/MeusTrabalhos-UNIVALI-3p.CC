#pragma once
#include <iostream>
#include <string>

#include "ListaEncadeada.h"

using namespace std;

const int TAMANHO_THEC = 1000;
#define VAZIO = NULL;

template<typename T>
struct THEC {
	pair<int, Lista<T>> TCintens[TAMANHO_THEC];
	int qtd;
};

template<typename T>
void inicializarListaComposta(THEC <T> & tabela)
{
	for (int indice = 0; indice < TAMANHO_THEC; indice++)
	{
		tabela.TCintens[indice].first = -1;
		inicializar(tabela.TCintens[indice].second);
	}
}

template<typename T>
void inserirListaComposta(THEC <T> &tabela, int chave, int &instrucoes)
{
	int posicao = chave % TAMANHO_THEC;

	if (tabela.TCintens[posicao].first == -1) 
		tabela.TCintens[posicao].first = chave;
	else
	{
		instrucoes++;
		inserirFinalDaLista(tabela.TCintens[posicao].second, chave, instrucoes);
	}

		tabela.qtd++;
}

template<typename T>
void pesquisarListaComposta(THEC <T> &tabela, int chave, int &instrucoes)
{
	int posicao = chave % TAMANHO_THEC;

	if (tabela.TCintens[posicao].first == chave)
		return;
	else {
		instrucoes++;
		pesquisarListaE(tabela.TCintens[posicao].second, chave, instrucoes);
	}
}
