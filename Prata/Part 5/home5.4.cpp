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
	pizza accounting;
	cout << "������� ��������-������������� �����: ";
     cin >> accounting.name;
     system("cls");
    cout << "������� ������ �����: ";
     cin >> accounting.diametr;
     system("cls");
   	cout << "������� ��� �����: ";
	 cin >> accounting.weight;   
	 system("cls");
	 cout << "�������� ��������-������������� �����: " << accounting.name << '\n';
	 cout << "������ �����: " << accounting.diametr << '\n';
	 cout << "��� �����: " << accounting.weight;
return 0;
}
