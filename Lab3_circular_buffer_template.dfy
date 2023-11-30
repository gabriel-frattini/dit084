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
    ensures Valid()
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

  predicate isEmpty()
     reads this
  {
       !isFlipped && write_position == read_position
  }

  predicate isFull()
     reads this
  {
       isFlipped
  }


  method Read() returns (isSuccess : bool, content : int)
    modifies this
    requires Valid()
    ensures  Valid()
    ensures  isSuccess ==> old(read_position) + 1 = read_position
    ensures !isSuccess ==> old(read_position) = read_position

   
    var isSuccess: bool = false;
    var content: int = 0;
     
    if(!isFlipped && write_position == read_position)
    {
         return;
    }

    content := cells[read_position];       
    read_position := read_position + 1;
    isSuccess := true;
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
