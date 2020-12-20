#include <bits/stdc++.h>
using namespace std;

vector<int> weights;
vector<int> subset;
vector<vector<int>> subsets;

int diff(int ssn, int pos)
{
    int suma = 0;
    int sumb = 0;
    for (int i = 0; i < weights.size(); i++)
    {
        if (i < pos)
        {
            suma += weights[subsets[ssn][i]];
        }
        else
        {
            sumb += weights[subsets[ssn][i]];
        }
    }
    return abs(suma - sumb);
}

void gen_subsets(int k)
{
    if (subset.size() == weights.size())
    {
        subsets.push_back(subset);
        return;
    }
    else
    {
        for (int i = 0; i < weights.size(); i++)
        {
            if (count(subset.begin(), subset.end(), i) == 0)
            {
                subset.push_back(i);
                gen_subsets(k + 1);
                subset.pop_back();
            }
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.setf(ios::fixed);

    int n;
    cin >> n;

    int input;
    for (int i = 0; i < n; i++)
    {
        cin >> input;
        weights.push_back(input);
    }

    int temp;
    int smallest;
    gen_subsets(0);

    for (int i = 0; i < subsets.size(); i++)
    {
        for (int j = 0; j < weights.size(); j++)
        {
            temp = diff(i, j);
            if (smallest > temp)
            {
                smallest = temp;
            }
        }
    }

    cout << smallest;

    return 0;
}