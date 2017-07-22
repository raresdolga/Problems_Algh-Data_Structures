/*
This algorithm finds out if there is a route between 2 points
I use bidirectional search
*/

#include <bits/stdc++.h>
#include "DFS_BFS.h"
using namespace std;

int nr_nodes;
vector<node_t> arr;

void readGraph() {

    //read from file
   freopen("input.txt","r",stdin);

   //output to file
   freopen("output.txt","w",stdout);
   int neigh, i,j;
  string line;

   cin >>nr_nodes;
   //move to the next line with reading
   cin.get();

   node_t temp;
    for(i = 0; i < nr_nodes; i++) {
        getline(cin,line);
        istringstream iss( line );
        //blank value to be declared
        arr.push_back(temp);
        while(iss >>neigh) {
            (arr[i].adjNodes).push_back(neigh);
        }
    }
   int current;
    for( i = 0; i < nr_nodes; i++) {
         for(j = 0;  j < arr[i].adjNodes.size(); j++){
         current = arr[i].adjNodes.at(j);
        cout<<current<< " ";
        }
    }
}


void BFS(queue<int> *bf, bool isVis[]) {
     int nr = bf -> front();
     bf -> pop();
     int current;
    for( int i = 0; i < (arr [nr]).adjNodes.size(); i++){
         current = (arr[nr]).adjNodes[i];
        if(isVis[current] == false) {
            isVis[current] = true;
            bf -> push(current);
            cout<<current<<" ";
        }
    }
}

bool intersect(bool visA[], bool visB[]) {
    int i = 0;
    while(i < nr_nodes) {
        if(visA[i] == visB[i] && visA[i] == true)
            return true;
        i++;
    }
    return false;
}

void bidirecSearch(int p1, int p2) {
    bool isVis_s[nr_nodes ];
    bool isVis_t[nr_nodes ];
    queue<int> trav1;
    queue<int> trav2;
    // we can have 2 parent array for the 2 way search to remember the trail
    //initialize
    for(int i = 0; i < nr_nodes; i++) {
        isVis_s[i] = false;
        isVis_t[i] = false;
    }
    trav1.push(p1);
    trav2.push(p2);
    isVis_s[p1] = true;
    isVis_t[p2] = true;
    while(!trav1.empty() && !trav2.empty()) {
        BFS(&trav1,isVis_s);
        BFS(&trav2,isVis_t);
        if(intersect(isVis_s,isVis_t)) {
            cout<<"there is a path from a to b";
            return ;
        }
    }
    //in these case this is no more bidsearch, but just a simple search
    while(!trav1.empty()) {
        BFS(&trav1,isVis_s);
        if(intersect(isVis_s,isVis_t)) {
            cout<<"there is a path from a to b";
            return ;
        }
    }
     while(!trav2.empty()) {
        BFS(&trav2,isVis_t);
        if(intersect(isVis_s,isVis_t)) {
            cout<<"there is a path from a to b";
            return ;
        }
    }
    cout<<"there is no path from a to b";

}

int main()
{
   readGraph();
    int p1, p2;
    cin >>p1;
    cin>>p2;
    //I need to use 0 as the start so I subtract 1 to obtain 0
    cout<<"1st file:\n";
    bidirecSearch(p1 ,p2);
    cout<<"\n2nd file:\n";
    runDFS(arr, p1,p2);
    cout<<"\n3rd file:\n";
    runBFS(arr, p1,p2);
    cout<<"\n5th file:\n";
    DFS_recursivly(arr, p1, p2);
    return 0;
}
