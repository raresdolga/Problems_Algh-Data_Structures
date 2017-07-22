#ifndef DFS_BFS_H_INCLUDED
#define DFS_BFS_H_INCLUDED
using namespace std;

typedef struct adList {
    vector<int> adjNodes ;
}node_t;

void runBFS(vector<node_t> arr, int s, int t);
void runDFS(vector<node_t> arr, int s, int t);
void DFS_recursivly(vector<node_t> arr, int s, int t);
#endif // DFS_BFS_H_INCLUDED
