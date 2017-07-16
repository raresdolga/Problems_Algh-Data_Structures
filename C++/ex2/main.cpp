#include <iostream>
#include<stdlib.h>
using namespace std;
// I inserted at the last but kept a reference to the previous
    typedef struct stackNode {
        int data;
        stackNode *prev;
        int miniSubStack;
    } node_t;

    void insertHead(int n, node_t **top){
        (*top) -> data = n;
        (*top) -> miniSubStack = n;
        (*top) -> prev = NULL;
    }

    void insertS(int n, node_t **top) {
        node_t * newNode = (node_t *) malloc(sizeof(node_t));
        newNode->data = n;
        //double pointer to update the head locally in the function body
        if( n < (*top) -> miniSubStack)
            newNode -> miniSubStack = n;
        else
            newNode -> miniSubStack = (*top) -> miniSubStack;

         node_t *aux  = *top;
         *top = newNode;
         (*top)->prev = aux;
    }

    int popS (node_t **top) {
        node_t *aux = *top;
        *top = (*top)->prev;

        return aux->data;
    }


    int minim(node_t **top) {
        return (*top) -> miniSubStack;
    }

    int main()
    {
        // head already declared so we use just one * as the reference
       node_t *top = (node_t *) malloc(sizeof(node_t));
       insertHead(-1,&top);

       insertS(5,&top);
       insertS(7,&top);
       insertS(-3,&top);
       cout<<popS(&top)<<"\n";
       cout<<minim(&top);
        return 0;
    }
