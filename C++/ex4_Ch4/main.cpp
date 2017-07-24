#include <bits/stdc++.h>
using namespace std;

typedef struct Node{
    int data;
    struct Node *left;
    struct Node *right;
} node_t;

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

}

int nrChildren(node_t *root) {
    int l,r;
    if(root == NULL) return -1;

    l = nrChildren(root -> left);
    if( l == -2) return -2;
    else
        l += 1;

    r = nrChildren(root -> right);
    if( r == -2) return -2;
    else
        r+=1;

    if(abs( l- r) > 1)
        return -2;
    else
        return abs( l- r);
}

void checkBalanced(node_t *root) {
    if(nrChildren(root) == -2)
        cout<<"Tree is not balanced";
    else
        cout << "Tree is balanced";
}

int main()
{
    node_t * root = (node_t *)malloc(sizeof(node_t));
    //insert at the root
    root -> data = 23;
    root -> left = NULL;
    root -> right = NULL;
    inserBS(root,15);
    inserBS(root,45);
    inserBS(root,12);
    inserBS(root,5);
    checkBalanced(root);
    return 0;
}
