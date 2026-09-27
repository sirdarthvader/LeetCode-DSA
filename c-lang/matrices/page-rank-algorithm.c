/**
There is a famous algorithm in graph mining theory known as "PageRank." The purpose of this algorithm is to find out the
most "important" page in a network on the web. This is a very useful algorithm, and the Google search engine uses an
advanced version of the same.

For the purpose of this problem, you need not know the details of the algorithm. You should know that, in the iterative
step of the simplest variant of this algorithm, we perform a matrix multiplication between two matrices, A and P_i, to
obtain P_i1, which then gets used in the next iteration to compute P_i2, and so on.

Here, A is a matrix having an equal number of rows and columns (equal to the number of web pages in the network), and P
is a column matrix having the number of rows equal to the number of web pages in the network.
 
Considering the matrices A and P_i at a particular iteration i, you need to perform the iterative step of the PageRank
(just one iteration) algorithm to obtain the P_i1 matrix. It is important to note that this step is just one single
matrix multiplication that you need to compute.

0 1 0 1 0
1 0 1 0 1
1 1 0 1 1
0 0 1 0 1
0 1 1 1 0

**/

#include <stdio.h>

// Given a square matrix of nxn and a column vector of n values perform matrix multiplication on them

int main(void) {
  int A[5][5] = {{0, 1, 0, 1, 0}, {1, 0, 1, 0, 1}, {1, 1, 0, 1, 1}, {0, 0, 1, 0, 1}, {0, 1, 1, 1, 0}};
  float P_i[5] = {0.75, 0.666, 0.45, 0.33, 0.832};
  float P_i1[5];

  // Code here for multiplying the matrix A and P_i
  // This will create hte P_i1 matirx

  for(int i = 0; i< 5; i++){

  }
}
