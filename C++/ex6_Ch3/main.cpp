#include <iostream>
#include <stdlib.h>
using namespace std;

typedef struct Queue {
    int data;
    struct Queue *next;
} node_t;
    node_t **head;
    node_t **last;

class Dog {
    public :
    int age;
    string color;
    void set_value(int age1, string color1){
     age = age1;
     color = color1; };
};

class Cat {

public :
    int age;
    string color;
    void set_value(int age1, string color1){
    age = age1;
    color = color1; };
};

void afis() {
    node_t *current = *head;
    while(current != NULL) {
        cout<< current -> data<<" ";
        current = current -> next;
    }
    cout << "\n";
}

void enqueue(int data) {
    node_t *current = (node_t *) malloc(sizeof(node_t )) ;
    current -> data = data;
    current -> next = NULL;
    // instead of my usual insertHead function, more inefficient,
    // but the user does not have to manually choose the right functions
    if(*head == NULL) {
        *last = *head = current;
    }
    else {
        (*last) -> next = current;
        *last = current;
    }
}
int dequeue() {
    int aux;
    if(*head == *last && *head != NULL) {
        //memory still needed for the head as not allocated in the main function
        aux = (*head) -> data;
        *head = *last = NULL;
        return aux;
    }
    else if( *head == NULL) {
        cout<< "queue is empty, nothing to delete\n";
    }
    else {
        //release memory here
        aux = (*last) -> data;
        free(last);
        return aux;
    }
}
int main()
{
    head = (node_t **) malloc(sizeof(node_t *));
    last = (node_t **) malloc(sizeof(node_t *));
    *head = NULL;
    *last = NULL;
    enqueue(5);
    enqueue(-12);
    enqueue(37);
    enqueue(17);
    enqueue(7);
    enqueue(-221);
    afis();
    cout<<dequeue()<<" ";

    return 0;
}
