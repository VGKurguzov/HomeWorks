#include <iostream>
#include <string>

using namespace std;
 
int main()
{
       struct human {
	string FName;
	string LName;
	char Grade;	
	short Age;
	}; 
	
	human person;
	cout << "What is your first name? ";
	getline(cin, person.FName);
    cout << "What is your last name? ";
	getline(cin, person.LName);
	cout << "What letter grade do you deserse? ";
	cin >> person.Grade;
	cout << "What is your age? ";
	cin >> person.Age;
	cout << "Name: " << person.LName << " , " << person.FName << '\n' << "Grade: " << person.Grade << '\n' << "Age: " << person.Age;
return 0;
}












