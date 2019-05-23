#include <stdio.h>
#include <stdlib.h>
#include <clocale>

int main() {

    setlocale(LC_ALL, "");

    if (!system(NULL)) {
        puts("Error");
        exit(EXIT_FAILURE);
    }

    system("cp -R old_folder new_folder");

    return 0;
}