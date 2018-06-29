#pragma once
#include "stdafx.h"
#include <iostream>

const int m = 2;

//template<typename T>
struct TPagina
{
	int registro[2 * m];

	//T dados[2 * m];

	int quantidade;

	TPagina * filhos[2 * m + 1];
};
