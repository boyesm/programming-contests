#include <bits/stdc++.h>
using namespace std;

bool isPrime(int n)
{
    if (n < 2)
        return false;
    for (int x = 2; x * x <= n; x++)
    {
        if (n % x == 0)
            return false;
    }
    return true;
}

void findComponents(int number)
{
    number *= 2;

    for (int i = 1; i < number; i++)
    {
        if (isPrime(i) && isPrime(number - i))
        {
            cout << number - i << " " << i << "\n";
            return;
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    int numberOfCases;
    cin >> numberOfCases;

    for (int i = 0; i < numberOfCases; i++)
    {
        cin >> n;
        findComponents(n);
    }

    return 0;
}