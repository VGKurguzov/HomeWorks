#include <iostream>

using namespace std;

int fun1(){
	cout << "Three blind mice" << endl;
 	  return 0;
}
int fun2(){
	cout << "See how they run";
 	  return 0;
}
 int main() { 
	fun1();
	fun1();	
	fun2();
	cout << '\n';
	fun2();
      return 0; 
}
