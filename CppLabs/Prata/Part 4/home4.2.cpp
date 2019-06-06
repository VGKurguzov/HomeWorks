#include <iostream>
#include <clocale>
using namespace std;
 
int main()
{
	setlocale(LC_CTYPE,"rus");
	const int FuteDuime = 12;
	const float DuimeMetr = 0.0254;
	const float FuntKg = 2.2;
	float heightD, heightF, weightF, imt;
	cout << "Введите Ваш рост в дюймах: ";
	cin >> heightD;
	cout << "Введите Ваш рост в футах: ";
	cin >> heightF;
	cout << "Введите Ваш вес в фунтах: ";
	cin >> weightF;
	heightF *= FuteDuime;
	heightF *= DuimeMetr;
	heightD *= DuimeMetr;
	weightF *= FuntKg;
	imt = weightF/(heightD*heightF);
	cout << "ИМТ = " << imt;
return 0;
}
