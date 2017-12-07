#include <iostream>
#include <cmath>

using namespace std; 

int main() {
	int m=3;
	double array[m][m];
	cout << "Enter array element: " << endl;
	for (int i = 0 ; i < m ; i++)	{
		for (int ii = 0 ; ii < m ; ii++)	{
			cin >> array[i][ii];
		}					
	}
	double sum,arrays[m][m];
	short del=1;
		for (int i = 0 ; i < m ; i++)	{
			for (int ii = 0 ; ii < m ; ii++)	{
			sum = array[i][ii];			
			if(i-1 >= 0 ){
				sum+=array[i-1][ii];
				del+=1;
			}			
			if(ii-1 >= 0){
			sum+=array[i][ii-1];
			del+=1;	
			}		
			if(ii+1 < m){
				sum+=array[i][ii+1];
				del+=1;
			}			
			if(i+1 < m){
				sum+=array[i+1][ii];
				del+=1;
			}			
			arrays[i][ii] = sum/del;
			del=1;
		}					
	}
	double suml = 0;
	int flag = 0;
	for (int i = 0 ; i < m ;i++)	{
			for (int ii = 0 ; ii < m ; ii++)	{
				if (ii < i)
				suml += abs(arrays[i][ii]);					 
		}
					
	}
	
	cout <<"sum = "<< suml << endl;
	system("pause");
	exit(0);
    return 0;
}
