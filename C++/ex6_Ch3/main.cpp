#include <iostream>
#include <stdlib.h>
using namespace std;

 class Animal {
    public :
    int age;
    string name;
    void virtual set_value(int age1, string name1){
     age = age1;
     name = name1; };
};

typedef struct Queue {
    Animal data;
    struct Queue *next;
} node_t;
    //create separate queues fir cats and dogs(more efficient in time terms, but inefficient in space;
    node_t **headD;
    node_t **lastD;
    node_t **headC;
    node_t **lastC;

//these 2 classes are useless at the moment, but just to use different c ++ classes
class Cat : public Animal {

};

class Dog : public Animal {

};

void afis() {
    node_t *currentD = *headD;
    node_t *currentC = *headD;

    while(currentD != NULL) {
        cout<< currentD -> data.name<<" ";
        currentD = currentD -> next;
    }
    cout << "\n";
     while(currentC != NULL) {
        cout<< currentC -> data.name<<" ";
        currentC = currentC -> next;
    }
    cout<<"\n";
}


void enqueue(Animal *data, string type) {
    node_t *current = (node_t *) malloc(sizeof(node_t ));
    current -> data = *data;
    current -> next = NULL;
    node_t **head;
    node_t **last;
    if(type.compare("dog") != 0) {
        cout << "intra";
        head = headD;
        last = lastD;
    }
    else if(type.compare("cat") != 0) {
        head = headC;
        last = lastC;
    }
    // instead of my usual insertHead function, more inefficient,
    // but the user does not have to manually choose the right functions
    if(*headD == NULL) {
        *last = *headD = current;
    }
    else {
        (*lastD) -> next = current;
        *lastD = current;
    }
}
string dequeue(string type) {
    string aux;
    node_t **head, **last;

    if(type.compare("dog") == 1) {
        head = headD;
        last = lastD;
    }

else if(type.compare("cat") == 1) {
    head = headC;
    last = lastC;
}
 else cout<< "not a valid key\n";
    if(*head == *last && *head != NULL) {
        //memory still needed for the head as not allocated in the main function
        aux = (*head) -> data.name;
        *head = *last = NULL;
        return aux;
    }
    else if( *head == NULL) {
        cout<< "queue is empty, nothing to delete\n";
    }
    else {
        //release memory here
        aux = (*last) -> data.name;
        free(last);
        return aux;
    }
}

int main()
{
    headD = (node_t **) malloc(sizeof(node_t *));
    lastD = (node_t **) malloc(sizeof(node_t *));
    headC = (node_t **) malloc(sizeof(node_t *));
    lastC = (node_t **) malloc(sizeof(node_t *));
    *headD = NULL;
    *lastD = NULL;
    *headC = NULL;
    *lastC = NULL;
    Animal *dog = new Dog();
    dog ->set_value(5,"tessco");
    enqueue(dog,"dog");
    dog -> name = "dati";
    enqueue(dog,"cat");
    Animal *cat = new Cat();
    cat -> set_value(7,"Marco");
    enqueue(cat,"cat");
    /*enqueue(17);
    enqueue(7);
    enqueue(-221);*/
    afis();
    //cout<<dequeue("dog")<<" ";

    return 0;
}
