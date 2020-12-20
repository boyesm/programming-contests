// #include <bits/stdc++.h>
// using namespace std;

// int main()
// {
//     ios_base::sync_with_stdio(0);
//     cin.tie(0);

//     // input

//     int t;
//     int r;
//     int c;

//     cin >> t;

//     int current_pos = 0;
//     string new_row;

//     for (int n = 0; n < t; n++) // loop for all cases
//     {

//         // generate graph

//         cin >> r;
//         cin >> c;

//         int max_pos = r * c;

//         vector<int> adj[max_pos + 1];

//         string map;
//         string new_row;

//         // create map string
//         for (int i = 0; i < r; i++)
//         {
//             cin >> new_row;
//             map += new_row;
//         }

//         for (int i = 0; i < r; i++)
//         {
//             for (int j = 0; j < c; j++)
//             {
//                 current_pos = (i * r) + j + 1;
//                 if (map[current_pos - 1] == '+') // above, below, left, right
//                 {
//                     if (current_pos - r > 0 && map[current_pos - r - 1] != '*') // above
//                     {
//                         adj[current_pos].push_back(current_pos - r);
//                     }
//                     cout << current_pos + r << " " << max_pos << " " << map[current_pos + r - 1] << "\n";
//                     if (current_pos + r <= max_pos && map[current_pos + r - 1] != '*') // below
//                     {
//                         adj[current_pos].push_back(current_pos + r);
//                     }
//                     if (current_pos < c * (i + 1) && map[current_pos] != '*') // right
//                     {
//                         adj[current_pos].push_back(current_pos + 1);
//                     }
//                     if (current_pos - 1 > c * i && map[current_pos - 2] != '*') //left
//                     {
//                         adj[current_pos].push_back(current_pos - 1);
//                     }
//                 }
//                 else if (map[current_pos - 1] == '|')
//                 {
//                     if (current_pos - r > 0 && map[current_pos - r - 1] != '*') // above
//                     {
//                         adj[current_pos].push_back(current_pos - r);
//                     }
//                     if (current_pos + r <= max_pos && map[current_pos + r - 1] != '*') // below
//                     {
//                         adj[current_pos].push_back(current_pos + r);
//                     }
//                 }
//                 else if (map[current_pos - 1] == '-')
//                 {
//                     if (current_pos < c * (i + 1) && map[current_pos] != '*') // right
//                     {
//                         adj[current_pos].push_back(current_pos + 1);
//                     }
//                     if (current_pos - 1 > c * i && map[current_pos - 2] != '*') //left
//                     {
//                         adj[current_pos].push_back(current_pos - 1);
//                     }
//                 }
//             }
//         }

//         // process graph

//         queue<int> q;
//         vector<bool> visited(max_pos + 1, false);
//         vector<int> distance(max_pos + 1, 0);

//         visited[1] = true;
//         distance[1] = 0;
//         q.push(1);

//         while (!q.empty())
//         {
//             int s = q.front();
//             q.pop();

//             // process node s

//             for (auto u : adj[s])
//             {
//                 if (visited[u])
//                     continue;
//                 visited[u] = true;
//                 distance[u] = distance[s] + 1;
//                 q.push(u);
//             }
//         }

//         // for (int i = 1; i <= c * r; i++)
//         // {
//         //     cout << visited[i] << " " << distance[i] << "\n";
//         // }

//         for (int i = 1; i < (r * c) + 1; i++)
//         {
//             cout << i << ": ";
//             for (auto u : adj[i])
//             {
//                 cout << u << " ";
//             }
//             cout << "\n";
//         }

//         // cout << distance[max_pos] << "\n";
//     }

//     return 0;
// }

#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    // input

    int t;
    int r;
    int c;

    cin >> t;

    int current_pos = 0;
    string new_row;

    for (int n = 0; n < t; n++) // loop for all cases
    {

        // generate graph

        cin >> r;
        cin >> c;

        int max_pos = r * c;

        vector<int> adj[max_pos + 1];

        string map;
        string new_row;

        // create map string
        for (int i = 0; i < r; i++)
        {
            cin >> new_row;
            map += new_row;
        }

        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                current_pos = (i * r) + j + 1;
                if (map[current_pos - 1] == '+') // above, below, left, right
                {
                    adj[current_pos].push_back(current_pos - r); // above
                    adj[current_pos].push_back(current_pos + r); // below
                    adj[current_pos].push_back(current_pos + 1); // right
                    adj[current_pos].push_back(current_pos - 1); // left
                }
                else if (map[current_pos - 1] == '|')
                {
                    adj[current_pos].push_back(current_pos - r); // above
                    adj[current_pos].push_back(current_pos + r); // below
                }
                else if (map[current_pos - 1] == '-')
                {
                    adj[current_pos].push_back(current_pos + 1); // right
                    adj[current_pos].push_back(current_pos - 1); // left
                }
            }
        }

        // process graph

        // queue<int> q;
        // vector<bool> visited(max_pos + 1, false);
        // vector<int> distance(max_pos + 1, 0);

        // visited[1] = true;
        // distance[1] = 0;
        // q.push(1);

        // while (!q.empty())
        // {
        //     int s = q.front();
        //     q.pop();

        //     // process node s

        //     for (auto u : adj[s])
        //     {
        //         if (visited[u])
        //             continue;
        //         visited[u] = true;
        //         distance[u] = distance[s] + 1;
        //         q.push(u);
        //     }
        // }

        // for (int i = 1; i <= c * r; i++)
        // {
        //     cout << visited[i] << " " << distance[i] << "\n";
        // }

        for (int i = 1; i < (r * c) + 1; i++)
        {
            cout << i << ": ";
            for (auto u : adj[i])
            {
                cout << u << " ";
            }
            cout << "\n";
        }

        // cout << distance[max_pos] << "\n";
    }

    return 0;
}