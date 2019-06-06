#include <iostream>
//#include <clocale>
using namespace std;
 
int main()

{
//	setlocale(LC_CTYPE,"rus");
	struct CandyBar {
		string name;
		float weight;
		short cal;
	};
	CandyBar snack[3] = {{"Iphone", 2.3, 350}, {"Дядя Ваня", 9.9, 400}, {"Zewa", 0.5, 3145}};
                                                
for (int count=0;count<3;count++) 
	cout << snack[count].name  << '\n' << snack[count].weight << '\n' << snack[count].cal << '\n'<< '\n';

return 0;
}
