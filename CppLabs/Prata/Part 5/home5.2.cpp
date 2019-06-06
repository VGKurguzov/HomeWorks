#include <iostream>
using namespace std;
 
int main()
{
	struct CandyBar {
		string name;
		float weight;
		short cal;
	};
	CandyBar snack = {"Mocha Munch", 2.3, 350};
	cout << snack.name << '\n' << snack.weight << '\n' << snack.cal;
return 0;
}
