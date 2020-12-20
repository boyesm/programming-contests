#include <bits/stdc++.h>
using namespace std;

int possible = 0;
int length = 3;
int numOfQueens = 2;

vector<vector<int>> restricted;
vector<vector<int>> placed;

void placeQueen(int col)
{
    if (col == length)
    {
        for (auto x : placed)
        {
            cout << x[0] << " ";
            cout << x[1] << "\n";
        }
        cout << "SUCCESS!"
             << "\n";
        return;
    }
    else
    {
        for (int row = 0; row < length; row++)
        {
            placed.push_back({col, row});
            placeQueen(col + 1);
            placed.pop_back();
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    // for (int i = 0; i < length; i++)
    // {
    //     string input = "";
    //     cin >> input;

    //     for (int j = 0; j < length; j++)
    //     {
    //         if (input[j] == '*')
    //         {
    //             restricted.push_back({j, i});
    //         }
    //     }
    // }

    placeQueen(0);

    // cout << "\n"
    //      << possible;

    return 0;
}