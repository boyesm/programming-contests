#include <bits/stdc++.h>
using namespace std;

const int N = 100000;
vector<int> adj[N];
vector<int> cycles[N];

void dfs_cycle(int u, int p, int color[],
               int mark[], int par[], int &cyclenumber)
{
    if (color[u] == 2)
    {
        return;
    }

    if (color[u] == 1)
    {

        cyclenumber++;
        int cur = p;
        mark[cur] = cyclenumber;

        while (cur != u)
        {
            cur = par[cur];
            mark[cur] = cyclenumber;
        }
        return;
    }
    par[u] = p;
    color[u] = 1;

    for (int v : adj[u])
    {
        if (v == par[u])
        {
            continue;
        }
        dfs_cycle(v, u, color, mark, par, cyclenumber);
    }

    color[u] = 2;
}

int main()
{
    int color[N];
    int par[N];
    int mark[N];
    int cyclenumber = 0;

    dfs_cycle(1, 0, color, mark, par, cyclenumber);

    for (int i = 1; i <= (sizeof(mark) / sizeof(mark[0])); i++)
    {
        if (mark[i] != 0)
        {
            cycles[mark[i]].push_back(i);
        }
    }
}