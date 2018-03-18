#include <iostream>

using namespace std;

class Warrior
{
public:
	virtual void say() = 0;
	
};

class Soldier: public Warrior
{
	public:
	void say() override
		{
			cout << "Soldier!!!" <<endl;
		}
	
};

class Ninja: public Soldier
{
public:
	void say() override
	{
		cout << "Ninja!!!" <<endl;	
	}
	
};

class Swordsman: public Soldier
{
public:
	void say() override
	{
		cout << "Swordsman!!!" <<endl;	
	}
	
};


class Human
{
public:
	void say(Warrior *warrior)
	{
		warrior->say();	
	}
	
};

int main()
{
 Soldier soldier;
 Swordsman swordsman;
 Human human;
 human.say(&soldier);
 human.say(&swordsman);

	return 0;
}
