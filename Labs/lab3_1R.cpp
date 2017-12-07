#include <iostream>
#include <cmath>

using namespace std;

double summass(double a, int i, int ii) {
	double sum;
	if (ii < i)
		sum = abs(a);
	return sum;
} 

int writemass() {
	int a;
	cin >> a;
	return a;
}

template <int ia, int iia>
double fillmass(double (&array)[ia][iia], int &i, int &ii) {
	int del=1, m=10;
	double sum = array[i][ii];
		if(i-1 >= 0 ){
				sum+=array[i-1][ii];
				del+=1;
			}			
			if(iia-1 >= 0){
			sum+=array[i][ii-1];
			del+=1;	
			}		
			if(iia+1 < m){
				sum+=array[i][ii+1];
				del+=1;
			}			
			if(i+1 < m){
				sum+=array[i+1][ii];
				del+=1;
			}			
			
			
	return sum/del;
}

int main() {
	int m=10;
	double array[m][m];
	cout << "Enter array element: " << endl;
	for (int i = 0 ; i < m ; i++)	{
		for (int ii = 0 ; ii < m ; ii++)	{
		array[i][ii]=writemass();
		}					
	}
	double sum,arrays[m][m];
		for (int i = 0 ; i < m ; i++)	{
			for (int ii = 0 ; ii < m ; ii++)	{
	arrays[i][ii]=fillmass(array,i,ii);
	
		}					
	}
	double suml = 0;
	int flag = 0;
	for (int i = 0 ; i < m ;i++)	{
			for (int ii = 0 ; ii < m ; ii++)	{
			a=arrays[i][ii];	
			suml+=summass(a,i,ii);		 
		}
					
	}
	
	cout <<"sum = "<< suml << endl;
	system("pause");
	exit(0);
    return 0;
}
