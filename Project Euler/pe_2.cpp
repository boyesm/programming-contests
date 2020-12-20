#include <bits/stdc++.h>
using namespace std;

int limit = 4000000;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    long long int total = 0;
    int n = 1;
    int n1 = 1;
    int temp = 0;

    while (n < limit)
    {
        temp = n1;
        n1 = n;
        n += temp;
        if (n % 2 == 0)
        {
            total += n;
        }
    }

    cout << total;

    return 0;
}