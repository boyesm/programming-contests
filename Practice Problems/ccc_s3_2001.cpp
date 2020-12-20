#include <bits/stdc++.h>
using namespace std;

const int N = 26;
vector<int> adj[N];
vector<int> cycles[1000000];
vector<int> disconnected[N];
int color[N];
int par[N];
int mark[N];
int cyclenumber = 0;

void dfs_cycle(int u, int p, int color[], int mark[], int par[], int &cyclenumber)
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
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string alpha_key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // input

    string new_line;

    while (true)
    {
        cin >> new_line;

        if (new_line == "**")
        {
            break;
        }

        adj[alpha_key.find(new_line[0])].push_back(alpha_key.find(new_line[1]));
        adj[alpha_key.find(new_line[1])].push_back(alpha_key.find(new_line[0]));
    }

    // detect cycles

    dfs_cycle(1, 0, color, mark, par, cyclenumber);

    for (int i = 1; i <= (sizeof(mark) / sizeof(mark[0])); i++)
    {
        if (mark[i] != 0)
        {
            cycles[mark[i]].push_back(i);
        }
    }

    // remove cycles

    for (int i = 0; i < cyclenumber; i++) // loops through cycles vector
    {
        for (int j = 0; j < N; j++) // loops through adj vector
        {
            if (adj[]) // if cycle matches adj then dont add to disconnected
        }
    }

    return 0;
}