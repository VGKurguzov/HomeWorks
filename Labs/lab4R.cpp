#include <iostream>

using namespace std;
int main() {
int count,x,y;
cout << "Enter n" << endl;
cin >> count;
count*=3;
int xpoint[count];
int ypoint[count];
cout << endl;
for (int i = 0;i<count;i++){
	cout<<"x: ";
	cin >> xpoint[i];
	cout<<"y: ";
	cin >> ypoint[i];
}
int xmax=xpoint[0];
int ymax=ypoint[0];
for (int i = 0;i<count;i++){
	if (xpoint[i]>xmax)
		xmax=xpoint[i];
	if (ypoint[i]>ymax)
		ymax=ypoint[i];
}
int zone[xmax][ymax];   
for (int g = 0;g<count;g++) {
	for (int j = 0;j<xmax;j++) {
		for (int i = 0;i<ymax;i++) {
			if (xpoint[g] == j && ypoint[g] == i)
			zone[j][i]=1;
			else
			zone[j][i]=0;	
}
	}
		}
/* int l=1;
for (int j = 0;j<xmax;j++){
	for (int i = 0;i<ymax;i++){ 
		if(zone[j][i] ==1) {
			if (l==1) 
				cout << l <<" triangle: ";
			cout <<"["<< j <<";"<<i<<"]"<< endl;
				l++;	
								
		if (l==4)
		l=1;
}		
	}
		}  */	
		
for (int j = 0;j<xmax;j++) {
	cout << endl;
		for (int i = 0;i<ymax;i++) {
			cout << zone[j][i];	}}


    return 0;  
}
