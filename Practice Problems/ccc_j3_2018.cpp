#include <bits/stdc++.h>
using namespace std;

int distances[5];
int output[5][5];

int sumOf(int start, int numSumComponents)
{
    int total = 0;
    for (int i = start; i < numSumComponents; i++)
    {
        total += distances[i];
    }

    return total;
}

int sumOfRev(int start, int numSumComponents)
{
    int total = 0;
    for (int i = start; i > 5 - numSumComponents; i--)
    {
        total += distances[i - 1];
    }

    return total;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    distances[0] = 0;
    for (int i = 1; i < 5; i++)
    {
        cin >> distances[i];
    }

    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            output[i][j] = 0;
        }
    }

    for (int i = 5; i > 0; i--)
    {
        for (int j = 5; j > 0; j--)
        {
            output[i - 1][j - 1] = (sumOfRev(i, 5 - j));
        }
    }

    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            if (output[i][j] == 0)
            {
                output[i][j] = (sumOf(i + 1, j + 1));
            }
        }
    }

    for (int i = 0; i < 5; i++)
    {
        for (int j = 0; j < 5; j++)
        {
            cout << output[i][j] << " ";
        }
        cout << "\n";
    }

    return 0;
}