#include <iostream>
#include <fstream>
#include <string>

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
				ofstream fout;
				fout.open("lib6.txt",ios_base::binary);	
				fout.write((char*)count, sizeof(long)) ;
				fout.write((char*)type[i].model, 25*sizeof(char)) ;
				fout.write((char*)type[i].price, sizeof(int)) ;
				fout.write((char*)type[i].x_size, sizeof(double)) ;
				fout.write((char*)type[i].y_size, sizeof(double)) ;
				fout.write((char*)type[i].optr, sizeof(int)) ;
				fout.write((char*)type[i].grey, sizeof(int)) ; 
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
