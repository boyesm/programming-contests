#include <bits/stdc++.h>
using namespace std;

// int numberOfRules = 4;
// int numberOfIterations = 5;
// string axiom = "AD";

// map<char, string> rules = {{'A', "AC"}, {'B', "ACA"}, {'C', "BD"}, {'D', "B"}};

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int numberOfRules;
    int numberOfIterations;
    string axiom;

    map<char, string> rules;

    for (int i = 0; i < 10; i++)
    {
        cin >> numberOfRules;
        cin >> numberOfIterations;
        cin >> axiom;

        char key;
        string element;

        for (int r = 0; r < numberOfRules; r++)
        {
            cin >> key;
            cin >> element;

            rules.insert({key, element});
        }

        string currentString = axiom;
        for (int i = 0; i < numberOfIterations; i++)
        {
            string tempString = "";
            for (long unsigned int j = 0; j < currentString.length(); j++)
            {
                tempString.append(rules[currentString[j]]);
            }
            currentString = tempString;
        }

        int len = currentString.length();
        cout << currentString[0] << currentString[len - 1] << " " << len << "\n";

        rules.clear();
    }

    return 0;
}