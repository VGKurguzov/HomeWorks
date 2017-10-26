#include <iostream>
#include <clocale>
using namespace std;
 
int main()
{
	setlocale(LC_CTYPE,"rus");
	const float ratio = 1./12;	
	int heightD;
	cout << "Введите Ваш рост в дюймах: ";
	cin >> heightD;
	cout << "Ваш рост в футах: " << heightD * ratio << '\n' << "Ваш рост в дюймах: " << heightD;
return 0;
}
