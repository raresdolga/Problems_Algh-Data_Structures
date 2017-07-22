/*This algorithm constructs a balanced Binary tree using a sorted array in increasing order*/
#include <bits/stdc++.h>
using namespace std;
typedef struct Node{
    int data;
    struct Node *left;
    struct Node *right;
}node_t;
//recursive divide & conquer function
node_t* constructBinTree(int *arr, int l, int r) {
    node_t * newN = (node_t *) malloc(sizeof(node_t));
 //special case array with one element
  /* if(l==r) {
        newN -> data = *(arr + l);
        newN -> left = NULL;
        newN -> right = NULL;
        return newN;
   }
   //special case array with  2 elements => assign to right
   if(l+1 == r) {
     newN -> data = *(arr + l);
     newN -> right = constructBinTree(arr,r,r);
     newN -> left = NULL;
     return newN;
   }*/
   if(r < l){return NULL;}
   int m = (l + r)/2;
   newN -> data = *(arr + m);
   newN -> left = constructBinTree(arr,l,m - 1);
   newN -> right = constructBinTree(arr,m+1,r);
   return newN;
}
void inOrder(node_t *root) {
    if(root != NULL) {
        inOrder(root -> left);
        cout<< root -> data <<"\n";
        inOrder(root -> right);
    }
}
void preOrder(node_t *root) {
    if(root != NULL) {
        cout<< root -> data <<"\n";
        inOrder(root -> left);
        inOrder(root -> right);
    }
}
int main()
{
    int n;
    int *arr = (int *) malloc(sizeof(int)*100);
    cin >>n;
    for(int i = 0; i < n; i++)
        cin>> *(arr + i);
    node_t *temp = constructBinTree(arr,0,n-1);
    //inOrder(temp);
    preOrder(temp);
    return 0;
}
