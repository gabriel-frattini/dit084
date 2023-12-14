function fact(n : nat): nat
	requires n > 0
  	decreases n
{
	if (n == 1) then 1 else n * fact(n-1)
}



method ComputeFact(n : nat) returns (res : nat)
  requires n > 0
  ensures res == fact(n)
 {
  res := 1;
  var i := 2;
  while (i <= n) 
   invariant 1 < i < n + 2
   invariant res == fact(i-1)
  {
    res := res * i;
    i := i + 1;
  }
 }
