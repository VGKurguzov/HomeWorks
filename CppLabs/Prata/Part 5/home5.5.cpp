#include <iostream>
#include <clocale>
#include <cstdlib>
using namespace std;
 
int main()
{
	setlocale(LC_CTYPE,"rus");
	struct pizza {
		string name;
		float diametr;
		float weight;
	};
	pizza *accounting = new pizza;
	    cout << "Введите диаметр пиццы: ";
     cin >> accounting->diametr;
     system("cls");
	cout << "Введите компанию-производителя пиццы: ";
     cin >> accounting->name;
     system("cls");
   	cout << "Введите вес пиццы: ";
	 cin >> accounting->weight;   
	 system("cls");
	 cout << "Радиус пиццы: " << accounting->diametr << '\n';
	 cout << "Название компании-производителя пиццы: " << accounting->name << '\n';
	 cout << "Вес пиццы: " << accounting->weight;
	 delete accounting;
return 0;
}
