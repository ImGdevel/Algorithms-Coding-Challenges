#include<iostream>
#include<vector>

using namespace std;

class Node {
public:
    Node* left = nullptr;
    Node* right = nullptr;
    int value;
    Node(int value) : value(value) {}
};

class Tree {
public:
    Node* first = nullptr;

    Tree() {}

    void add(int n) {
        Node* newNode = new Node(n);
        if (first == nullptr) {
            first = newNode;
        }
        else {
            Node* point = first;
            while (point != nullptr) {
                if (point->value > n) {
                    if (point->left == nullptr) {
                        point->left = newNode;
                        break;
                    }
                    point = point->left;
                }
                else {
                    if (point->right == nullptr) {
                        point->right = newNode;
                        break;
                    }
                    point = point->right;
                }
            }
        }
    }


    void printBack(Node* node) {

        if (node == nullptr) return;
        printBack(node->left);
        printBack(node->right);
        cout << node->value << "\n";
     
    }

};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);  cout.tie(NULL);
    
    Tree tree;
    int num;
    while (cin >> num) {
        tree.add(num);
    }

    tree.printBack(tree.first);
}