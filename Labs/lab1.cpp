#include <iostream>

using namespace std; 

int main() {
	double a, b, c, x, xend, dx,f;	
	cout << "Enter a,b,c,x, x end and dx:" << endl;
    cin >> a >> b >> c >> x >> xend >> dx;
    while(x<=xend) {
    if ((a < 0 ) && (x != 0))
    f = (a*x*x) + (b*b*x);
    if ((a > 0 ) && (x == 0))
    f = x-(a/(x-c));
    else
    f = 1+(x/c);
    			if ((~(int(c) || int(b)) && (int(b) || int(c)))==0)
    			f= int(f);
    			cout <<"x = " << x << '\t' <<"f = " << f << endl;
    			x += dx;
     				}	
     				system("pause");
     				exit(0);
    return 0;
}
