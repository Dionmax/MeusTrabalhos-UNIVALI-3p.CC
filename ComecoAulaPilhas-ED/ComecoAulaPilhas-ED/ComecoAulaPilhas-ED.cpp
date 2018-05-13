// ComecoAulaPilhas-ED.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>

#include "Pilha.h"

using namespace std;

int main()
{
	Pilha<int> teste;

	inicializarPilha(teste);

	push(teste, 12);

	push(teste, 10);

	push(teste, 13);

	imprimirPilha(teste);

	pop(teste);

	imprimirPilha(teste);

	cin.get();

    return 0;
}

