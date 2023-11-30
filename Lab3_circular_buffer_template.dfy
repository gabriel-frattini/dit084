// class CircularMemory
// This class implements a cicular buffer with with 2 int typed pointers
class CircularMemory
{
  var cells : array<int>;
  var read_position : int;
  var write_position : int;
  var isFlipped : bool;

  constructor Init(cap : int) 
    requires cap > 0
    ensures cells.Length == cap
    ensures read_position == 0
    ensures write_position == 0
    ensures !isFlipped
  {
    cells := new int[cap];
    read_position, write_position := 0, 0;
    isFlipped := false;
  }

  predicate Valid() 
       reads this
  {
       cells.Length > 0 &&
       read_position >= 0 &&
       write_position >= 0 &&
       (!isFlipped ==> read_position <= write_position)
  }


  method Read() returns (isSuccess : bool, content : int)
    modifies this
    requires Valid()
    ensures  Valid()
    ensures  isSuccess ==> ...
    ensures !isSuccess ==> ...

  {
    if(isFlipped)
    {
      ...
    }
    else // not flipped
    {
      ...
    }
  }

  method Write(input : int) returns (isSuccess : bool)
    modifies this
    requires Valid()
    ensures  Valid()
    ensures  isSuccess ==> ...
    ensures !isSuccess ==> ...
  {
    if(isFlipped)
    {
      ...
    }
    else // not flipped
    {
      ...
    }
  }


}
