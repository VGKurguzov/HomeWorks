#include <iostream>
#include <clocale>
using namespace std;
 
int main()
{
	setlocale(LC_CTYPE,"rus");
	const float ratio = 1./12;	
	int heightD;
	cout << "������� ��� ���� � ������: ";
	cin >> heightD;
	cout << "��� ���� � �����: " << heightD * ratio << '\n' << "��� ���� � ������: " << heightD;
return 0;
}
