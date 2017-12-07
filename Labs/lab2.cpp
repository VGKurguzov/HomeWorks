#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int n, pos = -1;
    double moduleMax = -1;
    cout << "Enter n: ";
    cin >> n;
 // double array[n];
 	float arr[] = new int[n];
	

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        if (abs(arr[i]) >= abs(moduleMax)) {
            moduleMax = arr[i];
            pos = i;
        }
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] > 0) {//
            int k = i + 1;
            while (arr[k] <= 0) {
                sum += arr[k];
                k++;
            }
        }
    	break; 
    }

    int j = n - 1;
    for (int i = 0; i < j; i++) {
        if (arr[i] == 0) {
            double temp;
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j -= 1;
        }
    }
    cout << "The maximum number on the module is " << moduleMax << " on position " << pos + 1 << endl;   	
    cout << "The sum of the elements of the array between the positive numbers = " << sum << endl;
    cout << "Massive: " << endl;
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
        cout << endl;
        }
        system("pause");
	exit(0);
    
    return 0;
}
