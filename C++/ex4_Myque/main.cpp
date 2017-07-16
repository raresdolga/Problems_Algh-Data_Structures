#include <iostream>
#include <stdlib.h>
using namespace std;

typedef struct stackNode {
    int data;
    stackNode *next;
} node_t;

node_t *head2;

void insertHead(int data1, node_t **head1) {
  //  node_t *newNode ;//= (node_t*) malloc(sizeof(node_t));
   // (newNode) -> data = data1;
   // (newNode) -> next = NULL;
    (*head1) ->data = data1;
    (*head1) -> next = NULL;
}

void insertS(int data1, node_t **head) {
    node_t *newNode = (node_t*) malloc(sizeof(node_t));
    newNode -> data = data1;
    newNode -> next = *head;
    *head = newNode;
}

bool stackIsEmpty (node_t *head) {
    if(head == NULL)
        return true;
    else
        return false;
}

void coppyS(node_t **head1, node_t *head) {
    // atentie dc puneai head2 la parametru nu head, atunci nu ii aloca memorie global (nu stia ce param global sa prim mem)
    head2 = (node_t *) malloc(sizeof(node_t ));
    node_t *current = (*head1) -> next;
    insertHead((*head1) -> data, &head2);
    while(current != NULL) {
        insertS(current -> data, &head2);
        current = current -> next;
    }
}

int popS(node_t ** head1) {
        if(stackIsEmpty(head2)) {
            coppyS(head1, head2);
        }
        node_t *aux = head2 -> next;
        int data = head2 -> data;
        free(head2 -> next);
        head2 = aux;
        return data;
    }

void popSequence(int nr, node_t **head1) {
 int i;
 for(i = 1; i <= nr; i++)
    popS(head1);
 coppyS(&head2,*head1);
}

void afis(node_t *head) {
    // we do not pass a double pointer so the outer head is not affected
    while(head != NULL) {
        cout<< head -> data <<" ";
        head = head -> next;
    }
    cout<<"\n";
}

int main()
{
    node_t *head1 = (node_t *) malloc(1*sizeof(node_t));
    /* test data */
    // we pass a double pointer for global change so we must use & in case if a single pointer declared
    insertHead(1,&head1);
    insertS(-3,&head1);
    insertS(97, &head1);
   afis(head1);
   cout<<popS(&head1);
   //afis(head2);
    return 0;
}
