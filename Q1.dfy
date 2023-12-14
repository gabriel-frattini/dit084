/* 
Answer Question 1a here:
The error message is saying that the postcondition i.e. `ensures > b` might not hold if y == x. In that case a will be assigned to y, and b to x, which leads to a == b, breaking the postcondition.
*/
method M(x : int, y : int) returns (a : int, b : int) 
  requires  x != y;
  ensures a > b;
{
  if (x > y)
   {a:= x;
    b := y;}
  else
   {a := y; 
    b := x;}
}

