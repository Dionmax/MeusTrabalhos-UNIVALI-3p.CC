#pragma once

#include <iostream>
#include "string"

using namespace std;

const int TAMANHO_MAXIMO = 52;

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

