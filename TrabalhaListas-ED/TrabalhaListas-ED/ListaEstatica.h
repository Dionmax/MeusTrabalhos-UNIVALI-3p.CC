#pragma once
#include <iostream>
#include <string>

using namespace std;

const int TAMANHO_MAXIMO = 50;

template <typename T>
struct ListaObjetos
{
	T objetos[TAMANHO_MAXIMO];
	int quantidadeObjetos;
};

template <typename T>
void inicializarListaEstatica(ListaObjetos <T>&lista)
{
	lista.quantidadeObjetos = 0;
}

template <typename T>
bool verificarEspacosLivres(ListaObjetos <T>lista)
{
	bool livre = true;

	if (lista.quantidadeObjetos == TAMANHO_MAXIMO)
		livre = false;

	return livre;
}

template <typename T>
bool insirirComecoListaEstatica(ListaObjetos <T>&lista, T obj)
{
	bool espacoLivre;

	espacoLivre = verificarEspacosLivres(lista);

	if (espacoLivre)
	{
		for (int indice = lista.quantidadeObjetos; indice > 0; indice--)
			lista.objetos[indice] = lista.objetos[indice - 1];

		lista.objetos[0] = obj;
		lista.quantidadeObjetos++;
	}

	return espacoLivre;
}

template <typename T>
bool removerComecoListaEstatica(ListaObjetos <T>&lista)
{
	bool verificacao = true;

	if (lista.quantidadeObjetos > 0)
	{
		for (int indice = 0; indice < lista.quantidadeObjetos; indice++)
			lista.objetos[indice] = lista.objetos[indice + 1];

		lista.quantidadeObjetos--;
	}
	else
		verificacao = false;

	return verificacao;
}

template <typename T>
bool insirirFimDaListaEstatica(ListaObjetos <T>&lista, T obj)
{
	bool espacoLivre;

	espacoLivre = verificarEspacosLivres(lista);

	if (espacoLivre)
	{
		lista.objetos[lista.quantidadeObjetos] = obj;
		lista.quantidadeObjetos++;
	}

	return espacoLivre;
}

template <typename T>
bool removerFimListaEstatica(ListaObjetos <T>&lista)
{
	bool verificacao = true;

	if (lista.quantidadeObjetos > 0)
		lista.quantidadeObjetos--;
	else
		verificacao = false;

	return verificacao;
}

template <typename T>
bool insirirPosicaoListaEstatica(ListaObjetos <T>&lista, T obj, int posicao)
{
	bool espacoLivre;

	espacoLivre = verificarEspacosLivres(lista);

	if (espacoLivre && posicao < lista.quantidadeObjetos)
	{
		for (int indice = lista.quantidadeObjetos + 1; indice > posicao; indice--)
			lista.objetos[indice] = lista.objetos[indice - 1];

		lista.objetos[posicao] = obj;

		lista.quantidadeObjetos++;
	}

	return espacoLivre;
}

template <typename T>
bool removerPosicaoListaEstatica(ListaObjetos <T>&lista, int posicaoLista)
{
	bool verificacao = true;

	int posicao = posicaoLista - 1;

	if (lista.quantidadeObjetos > 0 && posicao < lista.quantidadeObjetos)
	{
		for (int indice = posicao; indice < lista.quantidadeObjetos; indice++)
			lista.objetos[indice] = lista.objetos[indice + 1];

		lista.quantidadeObjetos--;
	}
	else
		verificacao = false;

	return verificacao;
}

template <typename T>
bool bubblesorteListaEstatica(ListaObjetos <T>&lista)
{
	T auxiliar;

	bool verificacao = true;

	if (lista.quantidadeObjetos > 0)
	{
		for (int indice = 0; indice < lista.quantidadeObjetos; indice++)
			for (int indice_dois = 0; indice_dois < lista.quantidadeObjetos - 1; indice_dois++)
				if (lista.objetos[indice_dois] > lista.objetos[indice_dois + 1])
				{
					auxiliar = lista.objetos[indice_dois];
					lista.objetos[indice_dois] = lista.objetos[indice_dois + 1];
					lista.objetos[indice_dois + 1] = auxiliar;
				}
	}
	else
		verificacao = false;

	return verificacao;
}

//Começo Merge
template <typename T>
void mergeSortJuntar(ListaObjetos <T> &lista, int inicio, int meio, int fim, ListaObjetos <T> &lista_aux)
{
	int esquerda = inicio,
		direita = meio;

	for (int indice = inicio; indice < fim; indice++)
		if ((esquerda < meio) and ((direita >= fim) or (lista.objetos[esquerda] < lista.objetos[direita])))
		{
			lista_aux.objetos[indice] = lista.objetos[esquerda];
			esquerda++;
		}
		else
		{
			lista_aux.objetos[indice] = lista.objetos[direita];
			direita++;
		}

	for (int indice = inicio; indice < fim; indice++)
		lista.objetos[indice] = lista_aux.objetos[indice];
}

template <typename T>
void mergeSortDividir(ListaObjetos <T> &lista, int inicio, int fim, ListaObjetos <T> &lista_aux)
{
	if ((fim - inicio) < 2) return;

	int meio = ((inicio + fim) / 2);

	mergeSortDividir(lista, inicio, meio, lista_aux);
	mergeSortDividir(lista, meio, fim, lista_aux);
	mergeSortJuntar(lista, inicio, meio, fim, lista_aux);
}

template <typename T>
void mergeSort(ListaObjetos <T> &lista, int tamanho)
{
	ListaObjetos<T> *lista_aux = new ListaObjetos<T>[tamanho-1];

	mergeSortDividir(lista, 0, tamanho-1, *lista_aux);
}
//Fim Merge

template <typename T>
void imprimirListaEstatica(ListaObjetos <T>lista)
{
	for (int indice = 0; indice < lista.quantidadeObjetos; indice++)
		cout << lista.objetos[indice] << endl;
}
