#include <iostream>

using namespace std;

class Auto;
 
class Person
{
public:
    Person(string n)
    {
        name = n;
    }
    void drive(Auto &a);
private:
    string name;
};
 
class Auto
{
private:
    string name; 
	friend class Person;
public:
    Auto(string autoName)
    {
        name = autoName;
    }
    string getName() 
	{
		return name; 
	}  
};
 
void Person::drive(Auto &a)
{
    cout << name << " to drive " << a.name << endl;
}
 
int main()
{
    Auto autocar("Tesla");
    Person human("Elon Mask");
    human.drive(autocar);
    return 0;
}
