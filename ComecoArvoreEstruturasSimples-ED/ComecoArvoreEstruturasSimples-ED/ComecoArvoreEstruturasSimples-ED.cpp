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
	TNodoABB<int> nodo;

	inicializarABB(nova_arvore);

	//insirirABB_it(nova_arvore, 14, 40);

	//insirirABB_it(nova_arvore, 16, 37);

	//insirirABB_it(nova_arvore, 11, 38);

	inserir_funcional(nova_arvore, 14, 31);

	inserir_funcional(nova_arvore, 15, 31);

	inserir_funcional(nova_arvore, 12, 32);

	inserir_funcional(nova_arvore, 18, 30);

	inserir_funcional(nova_arvore, 13, 33);

	//encontrarRemove(nova_arvore.raiz, 13);

	infixa(nova_arvore.raiz);

	cin.get();
    return 0;
}

