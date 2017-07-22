#include <bits/stdc++.h>
using namespace std;

typedef struct Node {
    int data;
    struct Node *left;
    struct Node *right;
    struct Node *parent;
}node_t;

typedef struct linkedL {
    int data;
    struct linkedL *next;
}lin_list;

typedef struct setLinkedL {
    lin_list *head;
    struct setLinkedL *next;
}setL;

setL *headS = NULL;
int maxLevels;

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

void BFS( queue<node_t *> a) {
 if(a.size() == 0) {
    return;
 }
  queue<node_t*> b;
  node_t *nod;
  lin_list *node ;
  setL *set_elem = (setL *)malloc(sizeof(setL));
  set_elem -> head = NULL;
  while(!a.empty()) {
    nod = a.front();
    a.pop();
    node = (lin_list *) malloc(sizeof(lin_list));
    insertLinkedL(&set_elem -> head, nod -> data);
    if(nod -> left != NULL){
        b.push(nod -> left);
    }
    if(nod -> right != NULL){
        b.push(nod -> right);
    }
  }
  set_elem -> next = headS;
  headS = set_elem;
  maxLevels ++;
  BFS(b);
}
void insertBS(node_t *root, int data) {
    node_t *newN = (node_t *)malloc(sizeof(node_t));
    newN -> data = data;
    newN -> left = NULL;
    newN -> right = NULL;
    node_t *aux ;
    node_t *current = root;
    while(current != NULL) {
       if((current) -> data > data){
            aux = current;
            (current) = (current) -> left;
       }
       else
       if((current) -> data <= data) {
            aux = current;
            current = (current) -> right;
       }

    }
    //aux will point to the same node as in the tree because it is not allocated with new memory
    if(aux -> data > data) {
        aux -> left = newN;
    }
    else
        aux -> right = newN;
}

void preOrder(node_t *root) {
    if(root != NULL) {
        cout<< root -> data <<"\n";
        preOrder(root -> left);
        preOrder(root -> right);
    }
}

void afishLevel() {
    setL *arr = headS;
    while(arr != NULL){
        lin_list *head = arr -> head;
        while(head != NULL) {
            cout<< head -> data<<" ";
            head = head -> next;
        }
        arr = arr -> next;
        cout<<"\n";
    }
}
void afishLevel(int level) {
    setL *arr = headS;
    int i = maxLevels;
    while(arr != NULL && i > level){
        i--;
        arr = arr -> next;
    }
    if(arr == NULL || i != level) {
        cout<<"the level does not exist\n";
        return ;
    }
    lin_list *head = arr -> head;
        while(head != NULL) {
            cout<< head -> data<<" ";
            head = head -> next;
        }
        cout <<"\n";
}
int main()
{

    queue<node_t *> a;
    node_t *root = (node_t *) malloc(sizeof(node_t));
    root -> left = NULL;
    root -> right = NULL;
    root -> data = 5;
    insertBS(root,4);
    insertBS(root,6);
    insertBS(root,9);
    //preOrder(root);
    a.push(root);
    BFS(a);
    afishLevel(0);
    afishLevel(2);
    afishLevel(4);
    return 0;
}
