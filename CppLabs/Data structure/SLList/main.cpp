#include <iostream>
#include <string>

using namespace std;

struct Node
{
    int data;
    Node* next;
    Node(int data) {
        this->data = data;
    }
};



class LinkedList {
private:
    Node* head;
    Node* tail;
    int length = 0;

public:

    LinkedList() {
        head = NULL;
        tail = 0;
        length = 0;
    }

    ~LinkedList() {
        tail = head;
        length = 0;
        while (tail != 0) {
            head = head->next;
            delete tail;
            tail = head;
        }
    }

    void addNode(int d) {
        Node *tmp;
        tmp = new Node(d);

        tmp->next = NULL;
        if (head == NULL && tail == 0) {
            head = tmp;
            tail = tmp;
            length++;
        }
        else {
            tail->next = tmp;
            tail = tmp;
            length++;
        }
    }

    void addFirst(int d) {
        Node *tmp;
        tmp = new Node(d);

        tmp->next = 0;
        if (head == NULL && tail == 0) {
            head = tmp;
            tail = tmp;
            length++;
        }
        else {
            tmp->next = head;
            head = tmp;
            length++;
        }
    }



    int size() {
        return this->length;
    }


    void display() {
        Node* temp = this->head;
        if(temp==NULL)
        {
            cout<<"List is empty"<<endl;
        }
        else
        {
            while(temp!=NULL)
            {
                cout<<temp->data<<" ";
                temp=temp->next;
            }
            cout<<endl;
        }

    }

    void insert(int index, int data) {
        Node* addme;
        Node* traverse = head;
        int i = 0;
        addme = new Node(data);

        while (traverse != NULL && i != index-1 ) {
            traverse = traverse->next;
            i++;
        }
        if (traverse == 0) {
            cout << data << " NULL" << endl;
        }

        addme->next = traverse->next;
        traverse->next = addme;
    }


    void remove(int index) {
        Node* next;
        Node* traverse = head;
        Node* prev;
        int i = 0;

        while (traverse != NULL && i != index -1) {
            traverse = traverse->next;
            i++;
        }
        if (traverse == 0) {
            cout <<  " NULL" << endl;
        }

        prev = traverse;
        while (traverse != NULL && i != index ) {
            traverse = traverse->next;
            i++;
        }
        if (traverse == 0) {
            cout << " NULL" << endl;
        }
        next = traverse->next;

        prev->next = next;
        delete traverse;

    }
    int & operator[](int index){
        if(this->head==NULL)
        return this->head->data;
        if(index < this->length){
            Node* temp = this->head;
            for(int i = 0;i<=index;i++){
                if(i==index){
                    return temp->data;
                }
                temp=temp->next;
            }
        }
    }

};


int main() {

    LinkedList a;

    a.addNode(3);
    a.addNode(4);
    a.addNode(5);
    a.addFirst(788);
    a.display();

    a.remove(1);
    a.insert(2,66);
    a.display();

    cout<<a[1]<<endl;

    return 0;
}