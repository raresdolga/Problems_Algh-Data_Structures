#include<bits/stdc++.h>
using namespace std;
typedef struct Node {
    int data;
    struct Node *left;
    struct Node *right;
    Node *parent;
}node_t;

void inserBS(node_t *root, int data){
    node_t *newN = (node_t *) malloc(sizeof(node_t));
    newN -> data = data;
    newN -> left = NULL;
    newN -> right = NULL;
    node_t *aux;
    while(root != NULL) {
        aux = root;
        if(root -> data > data) {
            root =  root -> left;
        }
        else
        if(root -> data <= data) {
            root = root -> right;
        }
    }
    if(aux -> data > data)
        aux -> left = newN;
    else
        aux -> right = newN;
    newN -> parent = aux;

}

void preOrder(node_t *root) {
    if(root != NULL) {
        cout << root -> data<<" ";
        preOrder(root -> left);
        preOrder(root -> right);
    }
}
