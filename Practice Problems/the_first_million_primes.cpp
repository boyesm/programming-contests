#include <bits/stdc++.h>
using namespace std;

bool isPrime(int n)
{
    if (n < 2)
        return false;
    for (long long int x = 2; x * x <= n; x++)
    {
        if (n % x == 0)
            return false;
    }
    return true;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n = 1000000;

    cout << "1,000,000 Primes:\n";

    vector<bool> primes;

    long long int i = 0;

    while (primes.size() < n)
    {
        bool p = isPrime(i);
        if (p)
        {
            primes.push_back(p);
            cout << primes.size() << ": " << i << "\n";
        }
        i++;
    }

    return 0;
}