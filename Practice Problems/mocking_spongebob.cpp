#include <iostream>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n, ul;
    char c;
    string in, out;
    cin >> n;
    for (int i = 0; i <= n; i++)
    {
        getline(cin, in);
        out = "";
        ul = 0;
        for (int j = 0; j < in.length(); j++)
        {
            c = in[j];
            if (ul % 2 == 0)
            {
                if ((65 <= c) && (c <= 90))
                {
                    out += tolower(c);
                }
                else if ((97 <= c) && (c <= 122))
                {
                    out += c;
                }
                else
                {
                    out += c;
                    continue;
                }
                ul++;
            }
            else
            {
                if ((65 <= c) && (c <= 90))
                {
                    out += c;
                }
                else if ((97 <= c) && (c <= 122))
                {
                    out += toupper(c);
                }
                else
                {
                    out += c;
                    continue;
                }
                ul++;
            }
        }
        cout << out << "\n";
    }
    return 0;
}