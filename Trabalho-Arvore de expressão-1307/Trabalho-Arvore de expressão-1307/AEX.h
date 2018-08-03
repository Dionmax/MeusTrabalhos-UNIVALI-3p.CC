#pragma once
#include <iostream>
#include <string>

using namespace std;

struct Aex
{
	string chave;

	Aex * esquerda;
	Aex * direita;
};

struct AexRaiz
{
	Aex raiz;

	int quantidade;
};

void montarArvore(Aex *&raiz, string expressao)
{

}
