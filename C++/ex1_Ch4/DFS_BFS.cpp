#include<bits/stdc++.h>
using namespace std;

typedef struct adList {
    vector<int> adjNodes;
}node_t;

void runBFS(vector<node_t> arr, int s, int t) {
    queue<int> a;
    int nr;
    unsigned i;
    bool visited[arr.size()];
    //initialize
     for(i = 0; i < arr.size(); i++) {
        visited[i] = false;
    }
    visited[s] = true;
    a.push(s);

    while(!a.empty()) {
        nr = a.front();
        a.pop();
        vector<int> temp = arr.at(nr).adjNodes;
        for(i = 0; i < temp.size(); i++ ) {
            if(visited[temp.at(i)] == false) {
                if(t == temp.at(i)) {
                    cout<<"there is a path from a to b";
                    return ;
                }
                a.push(temp.at(i));
                visited[temp.at(i)] = true;
            }
        }
    }
    cout<<"there is no path from a to b";
}

void runDFS(vector<node_t> arr, int s, int t) {
    stack<int> b;
    int i,nr;
    vector<int> temp;
    bool visited[arr.size()];
    //initialize
    for(i = 0; i < arr.size(); i++) {
        visited[i] = false;
    }
    b.push(s);
    while(!b.empty()) {
        nr = b.top();
        b.pop();
        if(visited[nr]) continue;
        visited[nr] = true;
        // we have to add the adjacent nodes in reverse order to mimic the recursion
        temp = arr.at(nr).adjNodes;
        for(i = temp.size() - 1; i >= 0; i--) {
            if(visited[temp.at(i)] == false) {
                if(temp.at(i) == t) {
                    cout<<"there is a path from a to b";
                    return;
                }
                b.push(temp.at(i));
            }
        }
    }
    cout<<"there is no path from a to b";
}

bool runDFS_rec(vector<node_t> arr, int s, int t, bool visited[]) {
    unsigned i;
    vector<int> temp;

    visited[s] = true;
    temp = arr.at(s).adjNodes;
    for( i = 0; i < temp.size(); i++){
        if(visited[temp.at(i)] == false) {
            if(temp.at(i) == t)
                return true;
           return  runDFS_rec(arr,temp.at(i),t,visited);
        }
    }
    return false;

}
void DFS_recursivly(vector<node_t> arr, int s, int t) {
    int i;
    bool visited[arr.size()];
    for(i = 0; i < arr.size(); i++) {
        visited[i] = false;
    }
   // visited[s] = true;
   if(runDFS_rec(arr,s,t,visited))
        cout<<"there is a path from a to b";
    else
        cout<<"there is no path from a to b";
}
