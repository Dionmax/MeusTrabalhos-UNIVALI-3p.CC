#pragma once
#include <iostream>
#include <string>

#include "ListaEncadeada.h"

using namespace std;

const int TAMANHO_THEA = 1000;
#define VAZIO = NULL;

template<typename T>
struct THEA {
	pair<int, T> Titens[TAMANHO_THEA];
	int qtd;
};

template<typename T>
void inicializarListaSimples(THEA<T> & tabela)
{
	for (int indice = 0; indice < TAMANHO_THEA; indice++)
		tabela.Titens[indice].first = -1;
	tabela.qtd = 0;
}

template<typename T>
void inserirNaListaSimples(THEA<T> & tabela, int chave, T objeto, int &pesquisaDeInstrucoues)
{
	int cheio = 1;

	if (tabela.qtd == TAMANHO_THEA)
		return;

	int posicao = chave % TAMANHO_THEA;

	if (tabela.Titens[posicao].first == -1) {
		tabela.Titens[posicao].first = chave;
		tabela.Titens[posicao].second = objeto;
		tabela.qtd++;
		return;
	}
	else
	{
		while (tabela.Titens[posicao].first != -1 && cheio != -1)
		{
			if (posicao == 999)
			{
				cheio--;
				posicao = 0;
			}
			else
			{
				posicao++;

				pesquisaDeInstrucoues++;
			}

			if (tabela.Titens[posicao].first == -1) {
				tabela.Titens[posicao].first = chave;
				tabela.Titens[posicao].second = objeto;
				tabela.qtd++;
				return;
			}
		}
	}
}

template<typename T>
int pesquisarListaSimples(THEA<T> & tabela, int chave, int &pesquisaDeInstrucoues)
{
	int cheio = 1;

	int posicao = chave % TAMANHO_THEA;

	if (tabela.Titens[posicao].first == chave)
		return posicao;
	else
	{
		while (tabela.Titens[posicao].first != chave && cheio != -1)
		{
			if (tabela.Titens[posicao].first == -1)
				return posicao;

			if (posicao == 999)
			{
				cheio--;
				posicao = 0;
			}
			else
			{
				posicao++;

				pesquisaDeInstrucoues++;
			}

		}
	}

	return posicao;
}
