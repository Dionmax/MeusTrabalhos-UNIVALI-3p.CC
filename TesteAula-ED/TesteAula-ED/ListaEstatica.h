#pragma once

#include <iostream>
#include "string"

using namespace std;

const int TAMANHO_MAXIMO = 52;

#define COPAS "copas"
#define OUROS "ouros"
#define PAUS "paus"
#define ESPADAS "espadas"

struct Baralho
{
	int numeroCartas;
	string naipeCartas;
};

struct ListaDeCartas
{
	Baralho cartas[TAMANHO_MAXIMO];
	int quantidadeDeCartas;
};

void inicializarListaDeCartas(ListaDeCartas &lista)
{
	lista.quantidadeDeCartas = 0;
}

bool verificarEspacosLivres(ListaDeCartas lista)
{
	bool livre = true;

	if (lista.quantidadeDeCartas == TAMANHO_MAXIMO)
		livre = false;

	return livre;
}

bool insirirFimListaDeCartas(ListaDeCartas &lista, Baralho cartas)
{
	bool espacosLivres;

	espacosLivres = verificarEspacosLivres(lista);

	if (espacosLivres)
	{
		lista.cartas[lista.quantidadeDeCartas] = cartas;
		lista.quantidadeDeCartas++;
	}

	return espacosLivres;
}

bool insirirInicioListaEstatica(ListaDeCartas &lista, Baralho cartas)
{
	bool espacosLivres;

	espacosLivres = verificarEspacosLivres(lista);

	if (espacosLivres)
	{
		for (int indice = lista.quantidadeDeCartas; indice > 0; indice--)
			lista.cartas[indice] = lista.cartas[indice - 1];

		lista.cartas[0] = cartas;
		lista.quantidadeDeCartas++;
	}

	return espacosLivres;
}

bool insirirPosicaoListaDeCartas(ListaDeCartas &lista, Baralho cartas, int posicao)
{
	bool espacosLivres;

	espacosLivres = verificarEspacosLivres;

	if (espacosLivres && posicao < lista.quantidadeDeCartas && posicao < 0)
	{
		for (int indice = lista.quantidadeDeCartas; indice > posicao; indice--)
			lista.cartas[indice] = lista.cartas[indice - 1];

		lista.cartas[posicao] = cartas;
		lista.quantidadeDeCartas++;
	}
	else
		espacosLivres = false;

	return espacosLivres;
}

bool removerUltimaPosicaoListaDeCartas(ListaDeCartas &lista)
{
	bool operacaoConcluida = false;

	if (lista.quantidadeDeCartas > 0)
	{
		lista.quantidadeDeCartas--;
		operacaoConcluida = true;
	}

	return operacaoConcluida;
}

bool removerIncioListaDeCartas(ListaDeCartas &lista)
{
	bool posicaoValida = false;

	if (lista.quantidadeDeCartas > 0)
	{
		for (int indice = 0;indice < lista.quantidadeDeCartas - 1; indice++)
			lista.cartas[indice] = lista.cartas[indice + 1];

		lista.quantidadeDeCartas--;

		posicaoValida = true;
	}

	return posicaoValida;
}

bool removerPosicaoListaDeCartas(ListaDeCartas &lista, int posicao)
{
	bool posicaoValida = false;

	if (posicao > 0 && posicao < lista.quantidadeDeCartas)
		posicaoValida = true;

	if (posicaoValida)
	{
		for (int indice = posicao;indice < lista.quantidadeDeCartas; indice++)
			lista.cartas[indice] = lista.cartas[indice + 1];

		lista.quantidadeDeCartas--;
	}

	return posicaoValida;
}

void imprimirListaDeCartas(ListaDeCartas lista)
{
	for (int indice = 0; indice < lista.quantidadeDeCartas; indice++)
	{
		cout << lista.cartas[indice].naipeCartas
			<< " => " <<
			lista.cartas[indice].numeroCartas << endl;
	}
}