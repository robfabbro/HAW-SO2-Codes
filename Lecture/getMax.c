#include <stdio.h>

int sum(int a) {
  int sum = 0;
  for (int i = 0; i < a; i++)
  {
    sum += i;
  }
  return sum;
}

int getMax(int a, int b)
{
  if (a > b)
  {
    return a;
  }
  else
  {
    return b;
  }
}

int compare(int a, int b)
{
  return getMax(a, b);
}

int main()
{

  for (int i = 0; i < 10; i++)
  {
    printf("Hello World\n");
  }

  return 0;
}