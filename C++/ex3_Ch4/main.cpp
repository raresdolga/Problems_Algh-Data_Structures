#include <bits/stdc++.h>
using namespace std;

typedef struct Node {
    int data;
    struct Node *left;
    struct Node *right;
    int index;
}node_t;

typedef struct linkedL {
    int data;
    struct linkedL *next;
}lin_list;

typedef struct setLinkedL {
    lin_list *head;
    struct setLinkedL *next;
}setL;

setL *headS;

void insertLinkedL(lin_list **head1, int data) {
     lin_list *temp = (lin_list *) malloc(sizeof(lin_list));
     temp -> data = data;
     temp -> next = (*head1);
     (*head1) = temp;
}
/*
setL* branches(node_t *root) {
   if(root -> left != NULL || root -> right != NULL) {
        setL *temp = ( setL*) malloc(sizeof(setL));
        temp -> head = NULL;
        if(root -> left != NULL) {
            insertLinkedL(&temp -> head,root -> left -> data);
        }
         if(root -> right != NULL) {
            insertLinkedL(&temp -> head,root -> right -> data);
        }
        temp -> next = headS;
        headS = temp;

   }
}
*/

void DFS(node_t * root, ) {

}

void BFS(node_t *current) {
  queue<node_t *> a;
  a.push(current);
  node_t *nod;
  while(!a.empty()) {
    nod = a.front();
    a.pop();
    if(nod -> left != NULL){
        a.push(nod -> left);
    }
  }
}
void insertBS() {

}
int main()
{
    headS = (setL *) malloc(sizeof(setL));
    cout << "Hello world!" << endl;
    return 0;
}
