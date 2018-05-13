// ComecoArvoreEstruturasSimples-ED.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>

#include "ArvoreBB.h"

using namespace std;

int main()
{
	TABB<int> nova_arvore;

	inicializarABB(nova_arvore);

	//insirirABB_it(nova_arvore, 14, 40);

	//insirirABB_it(nova_arvore, 16, 37);

	//insirirABB_it(nova_arvore, 11, 38);

	inserir_recursivo(nova_arvore.raiz, 14, 31);
	nova_arvore.quantidade++;

	inserir_recursivo(nova_arvore.raiz, 15, 31);
	nova_arvore.quantidade++;

	inserir_recursivo(nova_arvore.raiz, 12, 32);
	nova_arvore.quantidade++;

	inserir_recursivo(nova_arvore.raiz, 18, 30);
	nova_arvore.quantidade++;

	inserir_recursivo(nova_arvore.raiz, 13, 33);
	nova_arvore.quantidade++;

	//encontrarRemove(nova_arvore.raiz, 13);

	infixa(nova_arvore.raiz);

	cin.get();
    return 0;
}

