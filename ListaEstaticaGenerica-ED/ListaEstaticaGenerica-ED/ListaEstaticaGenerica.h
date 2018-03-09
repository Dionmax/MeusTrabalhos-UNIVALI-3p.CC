#pragma once
#include <iostream>
#include <string>

using namespace std;

template <typename T, int MAX>
struct listaEstaticaG
{
	T obejto[MAX];

	int quantidade;
};

template <typename T, int MAX>
bool verificarTamanhoMaximoLivre(listaEstaticaG <T, MAX> lista)
{
	bool verificação = true;

	if (lista.quantidade == MAX)
		verificação = false;

	return verificação;
}

template <typename T, int MAX>
void inicializar(listaEstaticaG <T, MAX> &lista)
{
	lista.quantidade = 0;
}

template <typename T, int MAX>
bool inserirFimDaLista(listaEstaticaG <T, MAX> &lista, T objeto)
{
	bool espacosLivres = false;

	espacosLivres = verificarTamanhoMaximoLivre(lista);

	if (espacosLivres)
	{
		lista.obejto[lista.quantidade] = objeto;
		lista.quantidade++;
	}

	return espacosLivres;
}

template <typename T, int MAX>
bool inserirInicioDaLista(listaEstaticaG <T, MAX> &lista, T objeto)
{
	bool espacosLivres = false;

	espacosLivres = verificarTamanhoMaximoLivre(lista);

	if (espacosLivres)
	{
		for (int indice = lista.quantidade; indice > 0; indice--)
			lista.obejto[indice] = lista.obejto[indice - 1];

		lista.obejto[0] = objeto;
		lista.quantidade++;
	}

	return espacosLivres;
}

template <typename T, int MAX>
void imprimirLista(listaEstaticaG <T, MAX> &lista)
{
	for (int indice = 0; indice < lista.quantidade; indice++)
		cout << lista.obejto[indice] << endl;
}
