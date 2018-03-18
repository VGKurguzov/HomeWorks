#include <iostream>
#include <string>
#include <cstdlib>
#include <ctime>

using namespace std;
/////////////////////////////////        Class Person
class Person
{
protected:
    double hp;
public:
    Person(double hp)
    {
        this->hp=hp;
    }
    Person()
    {
        this->hp=100;
    }
    ~Person(){}
};
///////////////////////////////         Class Player
class Player:virtual protected Person
{
protected:
    double gold;
    double attack;
public:
    Player(double hp,double attack,double gold):Person(hp)
    {
        this->attack=attack;
        this->gold=gold;
    }
    void infoP()
    {
        cout<<hp<<endl;
        cout<<attack<<endl;
        cout<<gold<<endl;
    }
    double GetHpP()
    {
        return Player::hp;
    }
    void SetHpP(double x)
    {
        Player::hp=x;
    }
    double GetAtP()
    {
        return Player::attack;
    }

friend void bonus(Player player);
};
////////////////////////////////// Class Enemy
class Enemy :virtual protected Person, virtual protected Player
{
public:
    Enemy(double hp,double attack, double gold):Person(hp),Player(hp,attack,gold)
    {
    }
    void infoE()
    {
        cout<<Player::hp<<endl;
        cout<<attack<<endl;
        cout<<Enemy::gold<<endl;
    }


    double GetHpE()
    {
        return Enemy::hp;
    }
    void SetHpE(double x)
    {
        Enemy::hp=x;
    }

    double GetAtE()
    {
        return Enemy::attack;
    }

};

double battle(Player hero,Enemy unit) 
{
    double fin,buf,attack;
    while (1)
    {
      attack=hero.GetAtP();
      buf=unit.GetHpE()-attack;
      unit.SetHpE(buf);
      if(unit.GetHpE()<=0)
      {
        fin=1;
        break;
      }
      attack=unit.GetAtE();
      buf=hero.GetHpP()-attack;
      hero.SetHpP(buf);
      if(hero.GetHpP()<=0)
      {
        fin=0;
        break;
      }
    }
    return fin;
}

void bonus(Player player) 
{
    int a = 100 + rand() % 200;
    int b = 81 + rand() % 200;
    int rez=0;
    cout << a << " + " << b << endl;
    cin >> rez;
    if(rez == a+b)
    player.gold+=45;
}
int main()
{
    srand(time(NULL));
    int hpE,atE,goE,select;
    repeatGame:
    Player player(100,8,0);
    repeat:
    hpE=1+rand()%50;
    atE=1+rand()%10;
    goE=1+rand()%60;
    Enemy enemy(hpE,atE,goE);
    cout<<"1-stats,2-attack enemy:";
    cin>>select;
    switch(select)
    {
    case 1:
        {
        player.infoP();
        cout<<"0-Back"<<endl;
        cin >> select;
        if (select == 0)
            goto repeat;
        break;
        }
    case 2:
        {
        cout<<"Your enemy:"<<endl;
        enemy.infoE();
        int result=battle(player,enemy);
        if(result==1)
            {
            bonus(player);
            player.SetHpP(100);
            enemy.SetHpE(100);
            goto repeat;
            }
        else
            {
            system("clr");
            cout<<"Вы погибли..."<<endl;
            cout << "1-Начать сначала"<<endl;
            cin >> select;
            if (select == 0)
                goto repeatGame;
            }
        break;
        }
    }

    return 0;
}
