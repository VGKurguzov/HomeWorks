#include <iostream>

using namespace std;

class Time
{
private:
	int h;
	int m;
	int s;	
public:
	static int count;
	Time()
	{
		h = m = s = 0;
		
	}
	
		Time(int h,int m, int s)
		{
			this->s = s;
			this->m = m;
			this->h = h;
			
		}
		
		Time(const Time &object)
		{
			this->h=object.h;
			this->m=object.m;
			this->s=object.s;			
		}
	

	void show()
	{
		cout << h << ":" << m << ":" << s <<endl;
	
	}
	
	void countTime()
	{
		cout<< Time::count << " operations performed." <<endl;
	
	}
	
	
	Time operator+ (Time obj)
	{
		Time result;
		result.s=s+obj.s;
		if (result.s >=60)
		{
			result.s-=60;
			result.m =1;	
		}
		result.m+=m+obj.m;	
		if (result.m >=60)
		{
			result.m-=60;
			result.h =1;	
		}
		result.h+=h+obj.h;
		count++;
		return result;
	}

	Time operator- (Time obj)
	{
		Time result;
		result.s=s-obj.s;
		if (result.s < 0)
		{
			result.m-=1;
			result.s +=60;	
		}
		result.m+=m-obj.m;	
		if (result.m < 0)
		{
			result.m+=60;
			result.h-=1;	
		}
		result.h+=h-obj.h;
		count++;
		return result;	
	}
	bool operator> (Time obj)
	{
		int l = h*3600 + m*60 + s;
		int r = obj.h*3600 + obj.m*60 + obj.s;
		count++;
		return (l > r) ? true : false;
	}
	
	bool operator< (Time obj)
	{
		int l = h*3600 + m*60 + s;
		int r = obj.h*3600 + obj.m*60 + obj.s;
		count++;
		return (l < r) ? true : false;
	}
	
	
};

int Time::count=0;


int main()
{
 Time a(3, 0, 0);
 Time b(0, 54, 25);
 Time c;
 c=a-b;
 c.show();
 c=a+b;
 c.show();
 if (a>b)
 	cout << "true" << endl;
else
	cout << "false" << endl;
	
if (a<b)
 	cout << "true" << endl;
else
	cout << "false" << endl;	
c.countTime();
a=b;
a.show();

	return 0;
}
