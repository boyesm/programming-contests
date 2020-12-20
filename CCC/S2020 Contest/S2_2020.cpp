#include <bits/stdc++.h>
using namespace std;

int r;
int c;

vector<vector<int>> maze;

vector<vector<bool>> visited;

bool is_integer(float k)
{
    return floor(k) == k;
}

vector<vector<int>> factor_pairs(float n)
{
    vector<vector<int>> pairs;
    double val;
    int val_int;
    int i_int;

    for (double i = 1; i <= n; i++)
    {
        val = n / i;
        if (is_integer(val))
        {
            val_int = val / 1;
            i_int = i / 1;

            pairs.push_back({i_int, val_int});
        }
    }

    return pairs;
}

void crawl_maze(vector<int> coords)
{
    if (coords[0] == r && coords[1] == c)
    {
        cout << "yes\n";
    }
    else
    {
        vector<vector<int>> pairs = factor_pairs(maze[coords[0]][coords[1]]);

        // cout << maze[1][2] << "\n";

        // for (int i = 0; i < pairs.size(); i++)
        // {
        //     for (int j = 0; j < pairs[i].size(); j++)
        //     {
        //         cout << pairs[i][j] << " ";
        //     }
        //     cout << "\n";
        // }

        for (int i = 0; i < pairs.size(); i++)
        {
            // cout << pairs[i][0] << " " << r << "    " << pairs[i][1] << " " << c << "\n";

            if (pairs[i][0] <= 3 && pairs[i][1] <= 4 && visited[pairs[i][0]][pairs[i][1]] == false)
            {
                visited[pairs[i][0]][pairs[i][1]] = true;
                // cout << pairs[i][0] << " " << pairs[i][1] << "\n";
                crawl_maze({pairs[i][0], pairs[i][1]});
                visited[pairs[i][0]][pairs[i][1]] = false;
            }
        }
    }
}

void print_maze()
{
    for (int i = 0; i < maze.size(); i++)
    {
        for (int j = 0; j < maze[i].size(); j++)
        {
            cout << maze[i][j] << " ";
        }
        cout << "\n";
    }
}

int main()
{
    cin >> r;
    cin >> c;
    int temp;

    for (int i = 0; i < r; i++)
    {
        maze.push_back({});
        for (int j = 0; j < c; j++)
        {
            cin >> temp;
            maze[i].push_back(temp);
        }
    }

    for (int i = 0; i < r; i++)
    {
        visited.push_back({});
        for (int j = 0; j < c; j++)
        {
            visited[i].push_back(false);
        }
    }

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    // for (int i = 0; i < maze.size(); i++)
    // {
    //     for (int j = 0; j < maze[i].size(); j++)
    //     {
    //         cout << maze[i][j] << " ";
    //     }
    //     cout << "\n";
    // }

    crawl_maze({1, 1});

    return 0;
}