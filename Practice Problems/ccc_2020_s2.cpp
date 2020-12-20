#include <bits/stdc++.h>
using namespace std;

int rows, columns;
vector<vector<int>> factors(1000001, {0});
vector<int> values;

int cv_crds(int r, int c)
{
    return (((r - 1) * columns) + c);
}

void find_factors(int x)
{
    if (factors[x][0] == 0)
    {
        vector<int> result;
        int i = 1;
        while (i * i <= x)
        {
            if (x % i == 0)
            {
                result.push_back(i);
                if (x / i != i)
                    result.push_back(x / i);
            }
            i++;
        }
        for (int j = result.size() - 1; j >= 0; j--)
            result.push_back(result[j]);
        factors[x] = result;
    }
    return;
}

vector<bool> visited;

void dfs(vector<int> adj[], int nodes, int s)
{
    if (visited[s])
        return;
    visited[s] = true;
    if (s == nodes)
    {
        cout << "yes\n";
        exit(0);
    }
    find_factors(values[s]);
    for (int n = 0; n < factors[values[s]].size(); n += 2)
    {
        if ((factors[values[s]][n] <= rows) && (factors[values[s]][n + 1] <= columns))
            adj[s].push_back(cv_crds(factors[values[s]][n], factors[values[s]][n + 1]));
    }
    for (auto u : adj[s])
        dfs(adj, nodes, u);
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> rows >> columns;
    int nodes = cv_crds(rows, columns);
    visited.assign(nodes + 1, false);
    vector<int> adj[nodes + 1];
    int t;

    values.push_back(0);
    for (int n = 0; n < nodes; n++)
    {
        cin >> t;
        values.push_back(t);
    }

    dfs(adj, nodes, 1);

    cout << "no\n";

    return 0;
}