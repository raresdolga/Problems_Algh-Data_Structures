#include <bits/stdc++.h>

using namespace std;
typedef struct Node {
    int data;
    struct Node *left;
    struct Node *right;
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

}

void preOrder(node_t *root) {
    if(root != NULL) {
        cout << root -> data<<" ";
        preOrder(root -> left);
        preOrder(root -> right);
    }
}


bool checkIf_BS(node_t *root,int mini, int maxi) {
        if(root == NULL) return true;
        if(root -> data >=  mini && root -> data < maxi) {

        if(!checkIf_BS(root->left,mini,root-> data) || !checkIf_BS(root -> right,root -> data,maxi))
                return false;
            else
                return true;
           }
           else
            return false;
}

int main()
{
    node_t *root = (node_t *) malloc(sizeof(node_t));
    root -> data = 5;
    root -> left = NULL;
    root -> right = NULL;
    inserBS(root,4);
    inserBS(root,8);
    //not a binary tree
    node_t *temp = (node_t *) malloc(sizeof(node_t));
    temp -> left = root;
    temp -> data = 6;
    temp -> right = NULL;
    root = temp;
    bool ans = checkIf_BS(root,-999999,999999);
    if(ans == false) {
        cout<<"The tree is not a binary search tree\n";
    }
    else
        cout<< "The tree is a binary search tree\n";
        preOrder(root);
    return 0;
}
