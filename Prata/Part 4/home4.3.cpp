#include <iostream>
#include <clocale>
using namespace std;
 
int main()
{
	setlocale(LC_CTYPE,"rus");
    float km, litres;
    cout << "������� ������� �� ��������(� ��): ";
	cin >> km;
	cout << "������� ������� ������� �� ���������(� ������): ";
	cin >> litres;
	cout << "����������� ������ ���������� ���������� " << km/litres*100 << " �./100 ����������";

return 0;
}
