#include <bits/stdc++.h>
using namespace std;

void find_cycles(string s, vector<string> cycles)
{
    signed int b;
    for (int i = 0; i < cycles.size(); i++)
    {
        b = s.find(cycles[i]);
        if (b >= 0)
        {
            cout << "yes";
            return;
        }
    }
    cout << "no";
    return;
}

vector<string> gen_cycles(string cc)
{
    vector<string> output;
    for (int i = 0; i < cc.length(); i++)
    {
        output.push_back(cc);
        cc.push_back(cc[0]);
        cc.erase(cc.begin());
    }

    return output;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string s, cycle;
    cin >> s >> cycle;

    find_cycles(s, gen_cycles(cycle));

    return 0;
}