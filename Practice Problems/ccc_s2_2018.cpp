#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> inputMatrix(int n)
{
    int temp;
    vector<vector<int>> matrix;
    for (int i = 0; i < n; i++)
    {
        vector<int> row;
        for (int j = 0; j < n; j++)
        {
            cin >> temp;
            row.push_back(temp);
        }
        matrix.push_back(row);
    }

    return matrix;
}

vector<vector<int>> rotateMatrix(vector<vector<int>> matrix)
{
    int n = matrix.size();
    for (int i = 0; i < n; ++i)
        for (int j = i + 1; j < n; ++j)
            swap(matrix[i][j], matrix[j][i]);

    for (int i = 0; i < n; ++i)
        for (int j = 0; j < n / 2; ++j)
            swap(matrix[i][j], matrix[i][n - j - 1]);

    return matrix;
}

void printMatrix(vector<vector<int>> matrix)
{
    int n = matrix.size();
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << matrix[i][j] << " ";
        }
        cout << "\n";
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    // input

    int n;
    cin >> n;

    vector<vector<int>> matrix;

    matrix = inputMatrix(n);

    // sort

    int pos1 = matrix[0][0];
    int pos2 = matrix[0][n - 1];
    int pos3 = matrix[n - 1][0];
    int pos4 = matrix[n - 1][n - 1];

    vector<int> corners;

    corners.push_back(pos1);
    corners.push_back(pos2);
    corners.push_back(pos3);
    corners.push_back(pos4);

    sort(corners.begin(), corners.end());

    // find smallest corner and rotate

    if (pos2 == corners[0])
    {
        matrix = rotateMatrix(matrix);
        matrix = rotateMatrix(matrix);
        matrix = rotateMatrix(matrix);
    }
    else if (pos3 == corners[0])
    {
        matrix = rotateMatrix(matrix);
    }
    else if (pos4 == corners[0])
    {
        matrix = rotateMatrix(matrix);
        matrix = rotateMatrix(matrix);
    }

    // print matrix

    printMatrix(matrix);

    return 0;
}