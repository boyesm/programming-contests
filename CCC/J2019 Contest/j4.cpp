#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    vector<vector<int>> grid;
    string all_flips;

    cin >> all_flips;

    int v_flips = count(all_flips.begin(), all_flips.end(), 'V') % 2;
    int h_flips = count(all_flips.begin(), all_flips.end(), 'H') % 2;

    if (v_flips == 1)
    {
        grid = {{2, 1}, {4, 3}};
    }
    else
    {
        grid = {{1, 2}, {3, 4}};
    }

    if (h_flips == 1)
    {
        vector<vector<int>> grid_temp = grid;
        grid = {{grid_temp[1][0], grid_temp[1][1]}, {grid_temp[0][0], grid_temp[0][1]}};
    }

    cout << grid[0][0] << " " << grid[0][1] << "\n"
         << grid[1][0] << " " << grid[1][1];

    return 0;
}