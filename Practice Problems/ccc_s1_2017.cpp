#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int k = 3;
    // cin >> k;

    vector<int> team1 = {1, 3, 3};
    vector<int> team2 = {2, 2, 6};

    // int temp;

    // for (int i = 0; i <= k; i++)
    // {
    //     cin >> temp;
    //     team1[i] = temp;
    // }
    // for (int i = 0; i <= k; i++)
    // {
    //     cin >> temp;
    //     team2[i] = temp;
    // }

    int bigk = 0;
    long long int sum1 = 0;
    long long int sum2 = 0;

    for (int i = 0; i <= k; i++)
    {
        sum1 += team1[i];
        sum2 += team2[i];
        if (sum1 == sum2)
        {
            bigk++;
        }
    }

    cout << bigk;

    return 0;
}