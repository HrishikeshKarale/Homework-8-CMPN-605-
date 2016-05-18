
/**
* TreeSet.java
*
* @version   $Id: TreeSet.java,v_1.0 2014/10/19 10:32:00
*
* @author    hhk9433 (Hrishikesh Karale)
* @author    ap8185 (Atir Petkar)
*
* Revisions:
*      Initial revision
*/



/**
 *this class replicates the behavior of a TreeSet and is used to implement 
 *methods like add(), remove(), contains(), isEmpty() and various other methods
 * from the TreeSet class.   
 *
 */
public class TreeSet extends Iterator
{
	int size=0;
	static TreeSet tree_set_object = new TreeSet();;
    static String array[];
    static int index=0; 
    Iterator iterator_object;
    final int max =300000;
    static boolean b=false;
  
    //default constructor
    public TreeSet()
	{
		array = new String[max];
	}
   
    
    
    //checks if the array is Empty
    public boolean isEmpty()
    {
    	if(tree_set_object.size()!=0)
    		return false;
    	return true;
    }
    
    /*
     *this method returns object of type Iterator and is used to iterate 
     *through the array
     */
    public Iterator iterator()
    {
    	iterator_index=0;
    	return tree_set_object;
    }
    @Override
    public boolean hasNext()
	{
    	size = tree_set_object.size();	
    	if(iterator_index++ <size)
    	{
    		return true;
    	}
		return false;
	}
    
    @Override
	public String next()
    {
    	size = tree_set_object.size();
    	if(index++ <size)
    	{
    		return array[iterator_index-1];
    	}
    	return null;
	}
    
    @Override
	public void remove()
	{	
    	tree_set_object.remove(array[iterator_index]);
	}
	
	/*
	 * this method returns the position where the new object should be placed
	 * @return  int value
	 */
    public int place(String object, int start, int end)
    {
    	int mid=(start+end+1)/2;
    	
    	//checks if only on element exists in the array;
    	if(end==start)
    	{
    		/*
    		 * if found true it then checks for various conditions so as to 
    		 * find the position of the newly entered object.  
    		 */
    		if(Integer.parseInt(object) == Integer.parseInt(array[start]))
    			return (start+1);	
    		if(Integer.parseInt(object)<Integer.parseInt(array[start]))
    			return (start);
    		else
    			return (start+1);
    	}
    	//checks if only two element exists in the array;
    	else if( start == end-1)
    	{
    		/*
    		 * if found true it then checks for various conditions so as to 
    		 * find the position of the newly entered object.  
    		 */
    		if(Integer.parseInt(object) == Integer.parseInt(array[start]))
    				return (start+1);
    		else if(Integer.parseInt(object)<Integer.parseInt(array[start]))
    			return start;
    		else if(Integer.parseInt(object)>Integer.parseInt(array[start]) &&Integer.parseInt(object)<Integer.parseInt(array[end]))
    			return end;
    		else
    			return end+1;
    	}
    	//checks if more than two elememts element exists in the array;
    	else if(end > start)
    	{
    		/*
    		 * if found true it then checks for various conditions so as to 
    		 * find the position of the newly entered object using recursion.  
    		 */
    		if(Integer.parseInt(object) == Integer.parseInt(array[mid]))
    			return mid+1;
    		if(Integer.parseInt(object)<Integer.parseInt(array[mid]))
    		{
    			return tree_set_object.place( object, start, mid);
    		}
    		else if( Integer.parseInt(object) > Integer.parseInt(array[mid]) )
    		{
    			return tree_set_object.place(object, mid, end);
    		}
    	}
    	return -1;
    }
    
    /*
     * this methods Excepts an String Object and returns a boolean value 
     * indicating if the object has been added to the array or not.
     * @return boolean
     */
	public boolean add(String object)
    {
		String tempo;
		//calculated the size of the array and stores it in the variable.
		size = tree_set_object.size();
		//checks if object is null or if it already exista in the array.
    	if(object != null && tree_set_object.contains(object, size) == -1)
    	{
    		if(size==0)
    			array[0]=object;
    		else
    		{
    			//calls place() so as to find position of new object to be placed
	    		int position =  tree_set_object.place(object, 0, size-1);
	    		//copies the (n) object to (n-1) position till we reach the position 
	    		for(int index=size; index>position; index--)
	    		{
		    		array[index]=array[index-1];
		    	}
	    		array[position]= object;
	    	}
   		return true;
    	}
    	return false;
        
    }
	
	/*
	 * removes an object from the array
	 * @return boolean 
	 */
	public boolean remove(String object)
	{
		size = tree_set_object.size();
		//checks if object is present in the array and if found stores its position
		int position = tree_set_object.contains(object, size);
		
		//checks if object id null or if its not in the array.
		if(object != null &&  position != -1)
		{
			//copies the array from nth position to n-1 position
			for(int index=position; index<size-1; index++)
				array[index]= array[index+1];
			array[tree_set_object.size()-1]= null;
			return true;
		}
		return false;
	}
	
	/*
	 * this method deletes all the objects from the array.
	 */
	public void clear()
	{
		size = tree_set_object.size();
		for(int index=0; index<size; index++)
			array[index]=null;
	}
	
	/*
	 * calculates the size of the array.
	 * @return  int
	 */
	public int size()
	{
		int size=0;
		for (int index=0; index<max; index++)
		{
			if(array[index] != null)
				size++;
			else
				break;
		}
		return size;
	}
	
	/*
	 * checks if the object already exists in the array
	 * @return boolean
	 */
	public boolean contains(String object)
	{
		size = tree_set_object.size();
		if(object != null && size != 0)
			for(int index=0; index<size; index++)
				if(array[index].equals(object))
					return true;
		return false;
	}
	
	/*
	 * checks if the object already exists in the array
	 * @return int
	 */
	public int contains(String object, int size)
	{
		if(object != null && size >= 0)
			for(int index=0; index<size; index++)
				if(array[index].equals(object))
					return index;
		return -1;
	}

}
