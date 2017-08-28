#include <bits/stdc++.h>
using namespace std;
stack<int> a1; stack<int> aux; stack<int> b1;

void afis(stack<int> b1){
     while(!b1.empty()){
        cout<<b1.top()<<" ";
        b1.pop();
    }
    cout<<"\n";
}
void hanoi(stack<int> arr[],int n,int q,int y, int z ){
  if(n > 0){
    hanoi(arr,n-1, q, z, y);
    int a = arr[q].top();
    arr[q].pop();
    arr[y].push(a);
    hanoi(arr,n-1, z, y, q);
   }
}

void hanoi2(int n, char a,char b, char c){
    if(n == 1){
        cout << a <<" ->" <<b<<"\n";
        return ;
    }
    hanoi2(n-1,a,c,b);
    cout << a <<" ->" <<b<< "\n";
    hanoi2(n-1,c,b,a);
}

int main()
{
    stack<int> a1,aux,b1;
    a1.push(1); a1.push(2); a1.push(3);
    stack<int> arr[]={a1,aux,b1};
    hanoi(arr,3,0,1,2);
    hanoi2(3,'a','b','c');
    while(!aux.empty()){
        cout<<aux.top();
        aux.pop();
    }
    afis(arr[1]);
    return 0;
}
