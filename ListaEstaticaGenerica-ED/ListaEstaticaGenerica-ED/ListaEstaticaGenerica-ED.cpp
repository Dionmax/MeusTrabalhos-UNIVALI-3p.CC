// ListaEstaticaGenerica-ED.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include <string>

using namespace std;

#include "ListaEstaticaGenerica.h"

int main()
{
	listaEstaticaG<float, 100> numeros;

	inicializar(numeros);

	inserirFimDaLista(numeros,(float)32.1);
	inserirInicioDaLista(numeros,(float)20.0);

	imprimirLista(numeros);

	cin.get();
    return 0;
}

