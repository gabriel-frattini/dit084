// class CircularMemory
// This class implements a cicular buffer with with 2 int typed pointers
class CircularMemory
{
  var cells : array<int>
  var read_position : int
  var write_position : int
  var isFlipped : bool

  constructor Init(cap : int) 
    requires cap > 0
    ensures cells.Length == cap
    ensures read_position == 0
    ensures write_position == 0
    ensures !isFlipped
    ensures fresh(cells);
    ensures Valid()
  {
    cells := new int[cap];
    read_position, write_position := 0, 0;
    isFlipped := false;
  }

  predicate Valid() 
       reads this
  {
       cells.Length >= 0 &&
       read_position >= 0 &&
       write_position >= 0 &&
       cells.Length > write_position
       
  }

  predicate isEmpty()
     reads this
  {
       !isFlipped && write_position == read_position
  }

  predicate isFull()
     reads this
  {
       isFlipped && read_position < write_position
  }


  method Read() returns (isSuccess : bool, content : int)

    modifies this, this.cells
    requires Valid()
    ensures  Valid()
    ensures  isSuccess ==> old(read_position) + 1 == read_position
    ensures !isSuccess ==> old(read_position) == read_position && content == 0
  {
     
     if((!isFlipped && write_position == read_position)  || read_position >= cells.Length)
     {
          isSuccess := false;
          content := 0;
     }
     else
     {
          isSuccess := true;
          content := cells[read_position];       
          read_position := read_position + 1;
     }
  }

  method Write(input : int) returns (isSuccess : bool)
    modifies this, this.cells
    requires Valid()
    ensures  Valid()
    ensures  isSuccess ==> 
    ((old(write_position) + 1 == write_position && write_position < cells.Length) 
    ||
    (write_position == 0 && old(write_position) == cells.Length - 1))
     && 
     input == cells[old(write_position)]
    ensures !isSuccess ==> old(write_position) == write_position 
  {

       if(isFlipped && read_position == write_position)
       {
            isSuccess := false;
       }
	
        else 
	{
	isSuccess := true;
	cells[write_position] := input;

       if(write_position == cells.Length - 1) 
       {
          write_position := 0;
       }

       else
       {
          write_position := write_position + 1;
       }

      }
     }

	method Main() 
    {
   	 
    var buff := new CircularMemory.Init(5);

    res := buff.Write(1);  
    res := buff.Write(2);  
    res := buff.Write(3); 

    var x,y := buff.Read();
    x,y := buff.Read();
    x,y := buff.Read();
  }

}

