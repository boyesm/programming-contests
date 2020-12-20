#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    // input

    vector<int> friends_adj[10000];
    vector<vector<int>> check_for_these;

    int students;

    cin >> students;

    int temp1;
    int temp2;

    for (int i = 0; i < students; i++)
    {
        cin >> temp1;
        cin >> temp2;

        friends_adj[temp1].push_back(temp2);
    }

    while (true)
    {
        cin >> temp1;
        cin >> temp2;

        if (temp1 == 0 && temp2 == 0)
        {
            break;
        }
        else
        {
            check_for_these.push_back({temp1, temp2});
        }
    }

    // find if nodes connected and find their seperation distance

    queue<int> q;

    for (int i = 0; i < check_for_these.size(); i++)
    {
        vector<bool> visited(10000, false);
        vector<int> node_seperation(10000, 0);

        visited[check_for_these[i][0]] = true;
        node_seperation[check_for_these[i][0]] = 0;
        q.push(check_for_these[i][0]);

        while (!q.empty())
        {
            int s = q.front();
            q.pop();

            for (auto u : friends_adj[s])
            {
                if (visited[u])
                    continue;
                visited[u] = true;
                node_seperation[u] = node_seperation[s] + 1;
                q.push(u);
            }
        }

        if (visited[check_for_these[i][1]])
        {
            cout << "Yes " << node_seperation[check_for_these[i][1]] - 1 << "\n";
        }
        else
        {
            cout << "No\n";
        }
    }

    return 0;
}