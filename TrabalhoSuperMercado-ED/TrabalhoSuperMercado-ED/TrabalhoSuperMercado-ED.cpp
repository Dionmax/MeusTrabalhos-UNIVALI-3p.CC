// TrabalhoSuperMercado-ED.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>

#include "Fila.h"

using namespace std;



int main()
{
	int numeroClientes = 0;

	cin >> numeroClientes;

	TFila<Cliente> * caixas = new TFila<Cliente>[numeroClientes];

	inicializarFila<Cliente>(caixas);

	cin.get();
    return 0;
}

