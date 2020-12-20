#include <bits/stdc++.h>
using namespace std;

#define MAX_INT ;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    long long int n;
    long long int m;

    cin >> n;
    cin >> m;

    vector<vector<pair<long long int, long long int>>> adj(n);

    long long int tempA;
    long long int tempB;
    long long int tempC;

    for (long long int i = 0; i < m; i++)
    {
        cin >> tempA;
        cin >> tempB;
        cin >> tempC;

        adj[tempA - 1].push_back({tempB - 1, tempC});
    }

    long long int distance[n];
    bool processed[n];

    fill_n(distance, n, 9223372036854775807);
    fill_n(processed, n, false);

    priority_queue<pair<long long int, long long int>> q;

    distance[0] = 0;
    q.push({0, 0});
    while (!q.empty())
    {
        long long int a = q.top().second;
        q.pop();
        if (processed[a])
            continue;
        processed[a] = true;
        for (auto u : adj[a])
        {
            long long int b = u.first, w = u.second;
            if (distance[a] + w < distance[b])
            {
                distance[b] = distance[a] + w;
                q.push({-distance[b], b});
            }
        }
    }

    for (long long i = 0; i < sizeof(distance) / sizeof(distance[0]); i++)
    {
        cout << distance[i] << " ";
    }

    return 0;
}
