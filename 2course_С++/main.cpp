#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <cstring>

using namespace std;

char input[1000];
int len;

int find_mistake()
{
    int i, mistake = 0;
    for (i = 0; i < len; i++)
    {
        if (input[i] == '1')
        {
            mistake ^= i + 1;
        }
    }
    return mistake;
}

int main()
{
    int i, mistake = 0;

    printf("Enter code: ");
    scanf("%s", input, 40);
    len = strlen(input);
    for (i = 0; i < len; i++)
        if (input[i] != '0' && input[i] != '1')
        {
            printf("Invalid code.\n");
            return -1;
        }

    mistake = find_mistake();
    if (mistake)
    {
        input[mistake - 1] ^= '0' ^ '1';
        mistake = find_mistake();

        if (mistake)
        {
            printf("Invalid code.\n");
            return -1;
        }
    }

    printf("Fixed code: %s\n", input);
}
