#include <iostream>
#include <fstream>
#include <string>
#include<sstream> //

using namespace std;

struct scan_info {
		char model[25];
		int price;
		double x_size;
		double y_size;
		int optr;
		int grey;
	};
void write (int &nref,scan_info *type) {
	stringstream conv;
	string stroka1,stroka2;
	long count =0;
	for (int i =0;i<nref;i++) {
		if (type[i].price < 200) {
			continue;
			count++;
		}		
			} 
			
			for (int i =0;i<nref;i++) {	
			if (type[i].price < 200) 
			continue;
			if (type[i].model[0] > 'A' && type[i].model[0] < 'Z') {
				conv << type[i].x_size;
  				conv >> stroka1;
  				conv << type[i].y_size;
  				conv >> stroka2;
				ofstream fout;
				fout.open("lib6.txt",ios_base::binary);	
				fout.write(reinterpret_cast<char*>,sizeof(int))
				fout.close();
			}
		}		
	}	

void fill(int &nref)  {
scan_info *type = new scan_info [nref];
 for (int i = 0; i < nref; i++)  {
 	cout << i+1 << " type scan: " << endl;
 	cout << "model:" << endl;
 		cin >>  type[i].model;
	cout << "price:" << endl;
		cin >>  type[i].price;
	cout << "x:" << endl;
		cin >>  type[i].x_size;	 
	cout << "y: " << endl;
		cin >>  type[i].y_size;	
	cout << "optr:" << endl;
		cin >>  type[i].optr;
	cout << "grey:" << endl;
		cin >>  type[i].grey;
	}
	write(nref,type);
}


int main() {
	int n;
	int &nref = n;
	cout << "Enter the number of scanners:" << endl;
	cin >> n;
	fill(nref);
	
	return 0;
    }
