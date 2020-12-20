#include <iostream>
using namespace std;

int main()
{
    int p, n, r;
    int d = 0;
    cin >> p >> n >> r;
    int t = n;
    while (t <= p)
    {
        n *= r;
        t += n;
        d++;
    }
    cout << d;
    return 0;
}