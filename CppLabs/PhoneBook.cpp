#include <iostream>
#include <string>
#include <vector>

using namespace std;

class PhoneBook{
private:
    class StrPhoneBook{
    private:
        int id;
        string from;
        string to;
        string date;
        string time;
        int duration;
    public:

        StrPhoneBook(int id, string from, string to, string date, string time, int duration){
            this->id = id;
            this->from = from;
            this->to = to;
            this->date = date;
            this->time = time;
            this->duration = duration;
        }
        int getId(){ return this->id; }
        string getFrom(){ return this->from; }
        string getTo(){ return this->to; }
        string getDate(){ return this->date; }
        string getTime(){ return this->time; }
        int getDuration(){ return this->duration; }

    };
    vector<StrPhoneBook> phonebook;
    int numId = 1;

public:
    void show(){
        cout << "ID\t\tFrom\t\tTo\t\tDate\t\tTime\t\tDuration" << endl;
        cout << "-----------------------------------------------------------------------------------------" << endl;
        for (int i = 0; i < this->phonebook.size(); i++)
            cout << phonebook[i].getId() << "\t\t" << phonebook[i].getFrom() << "\t\t" << phonebook[i].getTo() << "\t\t" << phonebook[i].getDate() << "\t" << phonebook[i].getTime() << "\t\t"
                 << phonebook[i].getDuration() << endl;
        cout << endl;
    }

    void add(string from, string to, string date, string time, int duration){
        StrPhoneBook temp(numId++,from,to,date,time, duration);
        phonebook.push_back(temp);
    }

    void del(int searchId){
        for(int i = 0;i < phonebook.size();i++){
            if (phonebook[i].getId() == searchId){
                phonebook.erase(phonebook.begin() + i);
            }
        }
    }

    void sortByFrom() {
        for (int i = 0; i < phonebook.size() - 1; i++) {
            for (int j = 0; j < phonebook.size() - 1 - i; j++) {
                if (phonebook[j].getFrom() > phonebook[j + 1].getFrom())
                    swap(phonebook[j], phonebook[j+1]);
            }
        }
    }

    void sortByTime() {
        for (int i = 0; i < phonebook.size() - 1; i++) {
            for (int j = 0; j < phonebook.size() - 1; j++) {
                if (phonebook[j].getTime() > phonebook[j + 1].getTime())
                    swap(phonebook[j], phonebook[j + 1]);
            }
        }
    }

    void sortByDuration() {
        for (int i = 0; i < phonebook.size() - 1; i++) {
            for (int j = 0; j < phonebook.size() - 1; j++) {
                if (phonebook[j].getDuration() > phonebook[j + 1].getDuration())
                    swap(phonebook[j], phonebook[j + 1]);
            }
        }
    }

    void searchToFrom(string from){
        bool flag = false;
        for (int i = 0; i < phonebook.size() ; i++) {
            if (phonebook[i].getFrom() == from){
                    cout << "ID\t\tFrom\t\tTo\t\tDate\t\tTime\t\tDuration" << endl;
                    cout << "-----------------------------------------------------------------------------------------" << endl;
                    cout << phonebook[i].getId() << "\t\t" << phonebook[i].getFrom() << "\t\t" << phonebook[i].getTo() << "\t\t" << phonebook[i].getDate() << "\t" << phonebook[i].getTime() << "\t\t"
                         << phonebook[i].getDuration() << endl;
                     cout << endl;
                    flag = true;
            }
        }
        if(flag == false)
            cout << "There is no such value for the 'From' field" << endl;
    }

    void searchToTo(string to){
        bool flag = false;
        for (int i = 0; i < phonebook.size() ; i++) {
            if (phonebook[i].getTo() == to){
                cout << "ID\t\tFrom\t\tTo\t\tDate\t\tTime\t\tDuration" << endl;
                cout << "-----------------------------------------------------------------------------------------" << endl;
                cout << phonebook[i].getId() << "\t\t" << phonebook[i].getFrom() << "\t\t" << phonebook[i].getTo() << "\t\t" << phonebook[i].getDate() << "\t" << phonebook[i].getTime() << "\t\t"
                     << phonebook[i].getDuration() << endl;
                cout << endl;
                flag = true;
            }
        }
        if(flag == false)
            cout << "There is no such value for the  'To'  field" << endl;
    }
};

int main()
{
    PhoneBook book;
    book.add("Petya", "Vasya", "11.03.2018", "19:00", 9);
    book.add("Vitya", "Vlad", "19.09.2007", "20:07", 19);
    book.add("Rita", "Dmitry", "11.03.2012", "07:13", 4);
    book.add("Jonny", "Bob", "13.02.2015", "13:20", 69);
    book.del(3);
    book.show();

    book.searchToFrom("Elena");
    book.searchToTo("Bob");

    book.sortByDuration();
    book.show();

    book.sortByTime();
    book.show();

    book.sortByFrom();
    book.show();

    return 0;
}