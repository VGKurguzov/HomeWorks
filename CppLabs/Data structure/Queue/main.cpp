#include<iostream>
using namespace std;
class Node{
public:
    int data;
    Node*next;
    Node()
    {
        next=NULL;
    }
};
class Queue{
public:
    Node *head;
    Node*tail;
    Queue(){
        head=NULL;
        tail=NULL;
    }
    void push(int value){
        Node*temp=new Node;
        temp->data=value;
        if (head==NULL){
            head=temp;
        }
        else{
            tail->next=temp;
        }
        tail=temp;
    }
    void pop(){
        Node*temp;
        temp=head;
        head=temp->next;
        delete temp;
    }
    int size(){
        Node *curr=head;
        int i=0;
        while(curr!=NULL){
            curr=curr->next;
            i++;
        }
        return i;
    }
    void display(){
        Node*curr=head;
        while(curr!=NULL){
            cout<<curr->data<<"<-";
            curr=curr->next;
        }
        cout<<endl;
    }
};

int main(){
    Queue q;
    for(int i =1; i<5; i++)
        q.push(i);
    q.display();
    q.size();
    q.pop();
    q.display();
    q.push(8);
    q.display();

    return 0;

}