#ifndef BINARYTREE_H_INCLUDED
#define BINARYTREE_H_INCLUDED

typedef struct Node {
    int data;
    struct Node *left;
    struct Node *right;
    Node *parent;
}node_t;

void inserBS(node_t *root,int data);
void preOrder(node_t *root);
#endif // BINARYTREE_H_INCLUDED
