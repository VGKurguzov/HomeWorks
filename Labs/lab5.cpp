#include <iostream>
#include <string>

using namespace std; 

int main() {
	short n=3;
	struct TRAIN {
		string  pn;
		short np;
		float t;		
	};
	TRAIN type[n];
	for(int i = 0;i < n; i++) {
		cout << '\t' << i+1 << " train: " << endl;
		cout << "Enter destination: " << endl;
		cin >> type[i].pn;
		cout << "Enter number train: " << endl;
		cin >> type[i].np;
		cout << "Enter departure time: " << endl;
		cin >> type[i].t;
	}
	TRAIN types;
	types.pn="";
	types.np=0;
	types.t=0;
	
	for(int count = 0;count < n; count++) {
	for(int i = 0;i < n; i++) {
		if (type[i].np > type[i+1].np) {
			if(i == n-1)
			continue;
		types.pn=type[i+1].pn;
		types.np=type[i+1].np;
		types.t=type[i+1].t;	
		type[i+1].np=type[i].np;
		type[i+1].pn=type[i].pn;
		type[i+1].t=type[i].t;
		type[i].np=types.np;
		type[i].pn=types.pn;
		type[i].t=types.t;
			}
		}
	}
	short number, flag=0;
	cout << "Enter number train: " << endl;
	cin >> number;
	for (int i = 0;i < n; i++) {
	if (number == type[i].np)
	cout << "----------Train----------" << endl;
	cout << "destination: " << type[i].pn << '\n' << "number train: " << type[i].np << '\n' << "departure time: " << type[i].t << endl;
	cout << "-------------------------" << endl;
	flag+=1;
	}
	if(flag == 0)
		cout << "such routes no"<< endl;
		
	system("pause");
	exit(0);
    return 0;
}
