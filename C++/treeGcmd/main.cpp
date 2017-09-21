#include <bits/stdc++.h>

using namespace std;
int mini = 0;

int euclid(int a, int b)
{
    int c;
    while (b) {
        c = a % b;
        a = b;
        b = c;
    }
    return a;
}

void BFS(vector<int> children[],int gcmd_parent[], int parent[], int key[], int nr_nodes){
    queue<int> visit;
    visit.push(0);
    int now;
    bool visited[nr_nodes];
    for(int i = 0; i < nr_nodes; i++)
        visited[i] = false;
    visited[0] = true;
    while(!visit.empty()){
        now = visit.front();
        visit.pop();
        gcmd_parent[now] = euclid(gcmd_parent[parent[now]], key[now]);

        for(int i = 0; i < children[now].size(); i++){
            if(!visited[(children[now]).at(i)])
                visit.push((children[now]).at(i));
        }
    }
}

int main()
{
    int nr_nodes, i,a,b;
    cin >> nr_nodes;
    int gcmd_parent[nr_nodes];
    int key[nr_nodes];
    vector<int> children[nr_nodes];
    for(i = 0; i < nr_nodes; i++){
        cin >>key[i];
        if(key[i] < key[mini] ) mini = i;
        children[i] = (vector<int> ());
    }
    int parent[nr_nodes];
    gcmd_parent[0] = key[0];
    // change just one key to 0 (i.e the minimum one)
    if(nr_nodes > 1)
        key[mini] = 0;
    parent[0] = 0;
    for(i = 0; i < nr_nodes - 1; i++){
        cin >>a>>b;
        // start from 0
        children[a - 1].push_back(b - 1);
        parent[b - 1] = a - 1;
    }
    BFS(children, gcmd_parent, parent, key,nr_nodes);
    cout<<"\n";
    for(i = 0; i < nr_nodes; i++){
        cout<<gcmd_parent[i]<< " ";
    }
    return 0;
}
