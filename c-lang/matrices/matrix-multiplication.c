// Multiply two matrices

#include <stdio.h>

int main(void)
{
    int n, m, p; // n x m and m x p matrices
    printf("Enter n: ");
    scanf("%d", &n);
    printf("Enter m: ");
    scanf("%d", &m);
    printf("Enter p: ");
    scanf("%d", &p);

    // Declare 3 matrices
    int a[n][m], b[m][p], c[n][p];
    printf("Enter elements of the first matrix: ");
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            scanf("%d", &a[i][j]);
        }
    }
    printf("Enter elements of the second matrix: ");
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < p; j++)
        {
            scanf("%d", &b[i][j]);
        }
    }

    // fresultant matrix loop,
    // outter loop is for rows
    for(i = 0; i < n; i++){
      // inner loop is for columns
      for(j = 0; j < p; j++){
        c[i][j] = 0;
        // 
        // final loop for dpt product
        for(k = 0; k < m; k++){
          c[i][j] += a[i][k] * b[k][j];
        }
      }
    }


    printf("The product of the matrices is: ");
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < p; j++)
        {
            printf("%d ", c[i][j]);
        }
        printf("\n");
    }
}
