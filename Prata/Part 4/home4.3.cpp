#include <iostream>
#include <clocale>
using namespace std;
 
int main()
{
	setlocale(LC_CTYPE,"rus");
    float km, litres;
    cout << "Введите сколько Вы проехали(в км): ";
	cin >> km;
	cout << "Введите сколько бензина вы потратили(в литрах): ";
	cin >> litres;
	cout << "Потребление Вашего автомобиля составляет " << km/litres*100 << " л./100 километров";

return 0;
}
