#include <iostream>

using namespace std;

int main() { 
	int cel;
	double fah;
	cout << "Please enter a Celsius value: ";
	cin >> cel;
	fah = 32 + 1.8*cel;
	cout << cel << " degrees Celsius is " << fah << " degrees Fahrenheit";
    return 0; 
}
