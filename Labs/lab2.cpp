#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int n, pos;
    double moduleMax;
    cout << "Enter n: ";
    cin >> n;
    double array[n];

    for (int i = 0; i < n; i++) {
        cin >> array[i];
        if (abs(array[i]) >= abs(moduleMax)) {
            moduleMax = array[i];
            pos = i;
        }
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
        if (array[i] > 0) {
            int k = i + 1;
            while (array[k] <= 0) {
                sum += array[k];
                k++;
            }
        }
    }

    int j = n - 1;
    for (int i = 0; i < j; i++) {
        if (array[i] == 0) {
            double temp;
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            j -= 1;
        }
    }

    cout << "The maximum number on the module is " << moduleMax << " on position " << pos + 1 << endl;
    cout << "The sum of the elements of the array between the positive numbers = " << sum << endl;
    cout << "Massive: " << endl;
    for (int i = 0; i < n; i++) {
        cout << array[i] << " ";
        cout << endl;
        }
        system("pause");
	exit(0);
    
    return 0;
}
