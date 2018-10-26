#include <iostream>

using namespace std;

template <class T>
class BinTree{
private:
    class Node{
        friend BinTree;
    private:
        Node *left, *right;
        T value;
    public:
        Node(T val){
            this->left = nullptr;
            this->right = nullptr;
            this->value = val;
        }
    };
    Node *root;

    void AddTo(Node &node, T val) {
        if (val < node.value) {
            if (node.left == nullptr) {
                node.left = new Node(val);
            } else {
                AddTo(*node.left, val);
            }
        }
        else {
            if (node.right == nullptr) {
                node.right = new Node(val);
            } else {
                AddTo(*node.right, val);
            }
        }
    }

public:
    BinTree(T val){
        root->left = nullptr;
        root->right = nullptr;
        root->value = val;
    }

    BinTree(){
        root->left = nullptr;
      root->right = nullptr;
      root->value = nullptr;
   }




    void add(T val){
        if(&root->value == nullptr)
           root = new Node(val);
        else
            AddTo(*root,val);
    }
};

int main() {
    int a;
    BinTree<int> f(5);
    while(true){
        cin >> a;
        f.add(a);
        if(a == 0)
            break;
    }

    return 0;
}