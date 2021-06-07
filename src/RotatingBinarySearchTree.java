
public class RotatingBinarySearchTree<E extends Comparable<E>> extends BinarySearchTree<E>
{
	protected Node<E> rotateLeft(Node<E> node)
	{
		Node<E> temp=node.right;
		node.right=temp.left;
		temp.left=node;
		return temp;
	}
	
	protected Node<E> rotateRight(Node<E> node)
	{
		Node<E> temp=node.left;
		node.left=temp.right;
		temp.right=node;
		return temp;
	}
}
