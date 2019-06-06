#include<iostream>
using namespace std;

class Node{
public:
	int data;
	Node*next;
};

class Stack{
public:
	Node*top;
	Stack(){
		top=NULL;
	}

void push(int value){
	Node *temp=new Node;
	temp->data=value;
	if (top==NULL){
		top=temp;
		top->next=NULL;
	}
	else {
		temp->next=top;
		top=temp;
	}
}
void pop(){
	Node *temp;
	temp=top;
	top=temp->next;
	delete temp;
}
int size(){
	Node *current=top;
	int i=0;
	while(current!=NULL){
		current=current->next;
		i++;
	}
	return i;
}
int topPeek(){
	return top->data;
}
		
void display(){
	Node *current=top;
	while(current!=NULL){
		cout<<current->data<<"->";
		current=current->next;
	}
	cout<<endl;
    }



};

int main() {

	Stack stack;
	for (int i = 0; i < 5; i++)
		stack.push(i);
		stack.display();
		stack.size();
		stack.topPeek();
		stack.pop();
		stack.display();

	return 0;
}