#include <iostream>
#include<stdlib.h>
using namespace std;

typedef struct stackNode {
   int data;
   struct stackNode *next ;
} node_t;
node_t *head1;
void insertHead(int data1, node_t **head1) {
    (*head1) ->data = data1;
    (*head1) -> next = NULL;
}

void insertS(int data1, node_t **head) {
    node_t *newNode = (node_t*) malloc(sizeof(node_t));
    newNode -> data = data1;
    newNode -> next = *head;
    *head = newNode;
}

 node_t* popS (node_t **top) {
        node_t *aux = *top;
        free((*top) -> next);
        *top = aux -> next;

        return aux;
    }


node_t* afis(node_t *head) {
    // we do not pass a double pointer so the outer head is not affected
    node_t * current = head;
    while(head  != NULL) {
        cout<< head -> data <<" ";
        current = head;
        head = head -> next;

    }
    cout<<"\n";
    return current;
}

void swap1( node_t * a , node_t * b) {
    int aux = a -> data;
    a -> data = b -> data;
    b -> data = aux;
 }

void bubleSortStack(node_t **head) {
    node_t *current;
   // node_t * val ;
    int ok = 0;
    do {
        ok  = 1;
        current = *head;
        while(current -> next != NULL) {
            if(current -> data > current -> next -> data ) {
                ok = 0;
                swap(current ->data, current -> next -> data); //  my unused function, swap1(current, current -> next);
            }
            current = current -> next;
        }
    } while(ok == 0);
}

void joinStacks(node_t *head1, node_t *last2) {
    last2 -> next = head1;
}
 node_t *pivot(node_t *head, node_t * last) {
    node_t *p = head -> next;
    node_t * current = head -> next;
    node_t *prev = head;
    while(current != last) {
        if(current -> data < head -> data) {
             prev = p;
            swap(current -> data, p -> data);
            p = current;
            cout<<"DA";
        }
        current = current -> next;
    }

    //if(p != NULL && head != NULL)
    swap(p -> data, head -> data);
    return prev ;
 }
void quickSortStack(node_t *head, node_t *last) {
    if(head == last) {
           cout << "here it should exit";
           return;
       }
       else {
   // cout<< ++ index ;
    node_t *piv = pivot(head, last);
    quickSortStack(head, piv);
    quickSortStack(piv -> next, last);
 }
}

void sort2Stacks() {
    node_t *head2 = NULL;
    node_t *current;
    node_t *temp;
    node_t *current2;
    while(head1 != NULL) {
        temp = popS(&head1);
        current2 = head2;
        while(current2 != NULL && (current2) -> data > temp -> data) {
            insertS(popS(&current2) -> data, &head1);
        }
        insertS(temp -> data, &current2);
        cout<< current2 -> data;
        // copy elements back
        current = current2;
        while(current != NULL) {
            insertS(popS(&current) -> data, &head1);
        }
    }
}

int main()
{
     head1 = (node_t *) malloc(1*sizeof(node_t));
    /* test data */
    // we pass a double pointer for global change so we must use & in case if a single pointer declared
    //insertHead(1,&head1);
    insertS(-3,&head1);
    insertS(97, &head1);
    insertS(1021,&head1);
   // node_t *last =  afis(head1);
    //bubleSortStack(&head1);
  //  quickSortStack(head1, last);
  sort2Stacks();
    afis(head1);
    return 0;
}
