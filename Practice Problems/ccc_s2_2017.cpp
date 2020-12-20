#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    double n;
    cin >> n;

    vector<int> tides;
    int temp;

    for (int i = 0; i < n; i++)
    {
        cin >> temp;
        tides.push_back(temp);
    }

    sort(tides.begin(), tides.end());

    vector<int> tides_sorted;

    int m = ceil(n / 2);

    int i = 0;
    int j = 0;
    while (i < n)
    {
        tides_sorted.push_back(tides[m - j - 1]); // low-tides
        i++;
        if (i < n)
        {
            tides_sorted.push_back(tides[m + j]); // high-tides
            i++;
            j++;
        }
    }

    for (int i = 0; i < n; i++)
    {
        cout << tides_sorted[i] << " ";
    }

    return 0;
}

// { 1, 2, 3, 4, 5, 6, 7 }
// { 4, 5, 3, 6, 2, 7, 1 }