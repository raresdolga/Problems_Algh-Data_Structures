#include <bits/stdc++.h>
#include "BinaryTree.h"
using namespace std;

    int treeMin(node_t *root) {
        if(root -> left == NULL)
            return root -> data;

        return treeMin(root -> left);
    }

    int successor(node_t *x) {
        if(x -> right != NULL)
            return treeMin(x -> right);
        node_t * current = x->parent;
        while(current != NULL && current -> right == x) {
            x = x -> parent;
            current = x -> parent;
        }
        return current -> data;
    }
int main()
{   // test data
    /*I need test data, but insert cannot be used for all as I need the reference to some pointers*/
    // I can modify InserBS() to return the address of the new node, or this, as iris a library function made by me
    node_t *root = (node_t *)malloc(sizeof(node_t));
    root -> data = 9;
    root -> parent = NULL;
    node_t *temp = (node_t *)malloc(sizeof(node_t));
    node_t *temp2 = (node_t *)malloc(sizeof(node_t));

    temp2 -> right = NULL;
    temp2 -> left = NULL;
    temp2 -> data = 12;
    temp -> data = 7;
    temp -> parent = root;
    temp2 -> parent = root;

    root -> right = temp2;
    root -> left = temp;

    node_t *ro1 = (node_t *)malloc(sizeof(node_t));
    node_t *ro2 = (node_t *)malloc(sizeof(node_t));
    ro1 -> data = 5;
    ro2 -> data = 8;
    ro1 -> parent = temp;
    ro2 -> parent = temp;
    temp -> right = ro2;
    temp -> left = ro1;
    ro1 -> left = NULL;
    ro2 -> left = NULL;
    ro1 -> right = NULL;
    ro2 -> right = NULL;

    inserBS(root,13);
    inserBS(root,11);

    preOrder(root);
    cout<<"\n"<<successor(ro2)<<"\n";
   return 0;
}
