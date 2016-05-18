/**
* Iterator.java
*
* @version   $Id: Iterator.java,v_1.0 2014/10/20 21:32:00
*
* @author    hhk9433 (Hrishikesh Karale)
* @author    ap8185 (Atir Petkar)
*
* Revisions:
*      Initial revision
*/


/**
 * this class is parent class of TreeSet and declares methods such as hasNext()
 * , next() and remove()
 *
 */
public class Iterator
{
	static int iterator_index=0;
	
    /**
	 * default Constructor
	 */
	public Iterator()
	{
	
	}
	
	/**
	 * this method had boolean as return type and TreeSet over rides this 
	 * method and uses it to check if next an element is available
	 * @return boolean
	 */
	public boolean hasNext()
	{
		return false;
	}
	
	/**
	 * TreeSet over rides this method and uses it to go to the next an element
	 * @return String
	 */
	public String next()
	{
		return null;
	}
	/**
	 * TreeSet over rides this method and uses it to remove current element 
	 */
	public void remove()
	{	
	}
}
