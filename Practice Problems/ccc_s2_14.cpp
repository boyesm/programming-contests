#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    // get input

    int n;
    cin >> n;

    vector<string> p_1;
    vector<string> p_2;

    string temp;

    for (int i = 0; i < n; i++)
    {
        cin >> temp;
        p_1.push_back(temp);
    }

    for (int i = 0; i < n; i++)
    {
        cin >> temp;
        p_2.push_back(temp);
    }

    // sort input

    map<string, string> partners;

    for (int i = 0; i < n; i++)
    {
        partners.insert({p_1[i], p_2[i]});
    }

    // check input

    vector<bool> hmm(n, false);

    for (int i = 0; i < n; i++)
    {
        partners[p_1[i]] ==
    }

    return 0;
}