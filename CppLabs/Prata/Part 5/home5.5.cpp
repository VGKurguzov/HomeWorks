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
	    cout << "������� ������� �����: ";
     cin >> accounting->diametr;
     system("cls");
	cout << "������� ��������-������������� �����: ";
     cin >> accounting->name;
     system("cls");
   	cout << "������� ��� �����: ";
	 cin >> accounting->weight;   
	 system("cls");
	 cout << "������ �����: " << accounting->diametr << '\n';
	 cout << "�������� ��������-������������� �����: " << accounting->name << '\n';
	 cout << "��� �����: " << accounting->weight;
	 delete accounting;
return 0;
}
