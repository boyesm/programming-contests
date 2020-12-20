#include <bits/stdc++.h>
using namespace std;

int sumOfVector(vector<int> vec)
{
    int sum = 0;
    int s = vec.size();

    for (int i = 0; i < s; i++)
    {
        sum += vec[i];
    }

    return sum;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n = 1000;
    vector<int> multiples;

    for (int i = 1; i < n; i++)
    {
        if (i % 3 == 0 || i % 5 == 0)
        {
            multiples.push_back(i);
        }
    }

    cout << sumOfVector(multiples);

    return 0;
}