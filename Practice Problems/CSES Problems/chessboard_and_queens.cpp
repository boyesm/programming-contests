#include <bits/stdc++.h>
using namespace std;

int possible = 0;

int length = 10;
int numOfQueens = 10;

vector<vector<int>> restricted;
vector<vector<int>> placed;

bool isLegal(vector<int> newpos)
{
    for (int i = 0; i < placed.size(); i++)
    {
        if (placed[i][0] == newpos[0])
        {
            return false;
        }
        else if (placed[i][1] == newpos[1])
        {
            return false;
        }
        else if (abs(placed[i][0] - newpos[0]) == abs(placed[i][1] - newpos[1]))
        {
            return false;
        }
    }
    return true;
}

bool isNotRestricted(vector<int> newpos)
{
    for (int i = 0; i < restricted.size(); i++)
    {
        if (newpos == restricted[i])
        {
            return false;
        }
        // else if (restricted[i][0] > newpos[0])
        // {
        //     return true;
        // }
    }
    return true;
}

void placeQueen(int col)
{
    if (col == length)
    {
        possible++;
        // cout << "SUCCESS!"
        //      << "\n";
        return;
    }
    else
    {
        for (int row = 0; row < length; row++)
        {
            if (isNotRestricted({col, row}) && isLegal({col, row}))
            {
                placed.push_back({col, row});
                placeQueen(col + 1);
                placed.pop_back();
            }
            else
            {
                continue;
            }
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    for (int i = 0; i < length; i++)
    {
        string input = "";
        cin >> input;

        for (int j = 0; j < length; j++)
        {
            if (input[j] == '*')
            {
                restricted.push_back({j, i});
            }
        }
    }

    placeQueen(0);

    cout << possible;

    return 0;
}