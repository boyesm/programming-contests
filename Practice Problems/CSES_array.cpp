#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;

    cin >> n;

    vector<int> el;
    int temp;

    for (int i = 0; i < n; i++)
    {
        cin >> temp;
        // cout << temp << "\n";
        el.push_back(temp);
    }
    // cout << "\n";

    sort(el.begin(), el.end());

    long long int turns = 0;

    for (int i = 0; i < n - 1; i++)
    {
        // cout << el[i + 1] - el[i] << "\n";
        turns += (el[i + 1] - el[i]);
        // cout << turns << "\n";
    }

    cout << turns;

    return 0;
}