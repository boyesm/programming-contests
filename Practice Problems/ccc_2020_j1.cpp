#include <bits/stdc++.h>
using namespace std;

int find_happiness(vector<int> treats)
{
    int hap_val = 0;

    for (int i = 0; i < treats.size(); i++)
    {
        hap_val += (treats[i] * (i + 1));
    }

    return hap_val;
}

void happy_or_not(int happiness)
{
    if (happiness >= 10)
    {
        cout << "happy\n";
    }
    else
    {
        cout << "sad\n";
    }
    return;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    vector<int> treats;

    int temp;

    for (int i = 0; i < 3; i++)
    {
        cin >> temp;
        treats.push_back(temp);
    }

    int happiness;

    happiness = find_happiness(treats);

    happy_or_not(happiness);

    return 0;
}