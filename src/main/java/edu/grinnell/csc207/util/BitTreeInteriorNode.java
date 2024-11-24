package edu.grinnell.csc207.util;

/**
 * Interior nodes in a bit tree.
 *
 * @author Samuel A. Rebelsky
 */
public class BitTreeInteriorNode implements BitTreeNode {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The left subtree.
   */
  BitTreeNode left;

  /**
   * The right subtree.
   */
  BitTreeNode right;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Createa  new node with both subtrees.
   */
  public BitTreeInteriorNode(BitTreeNode l, BitTreeNode r) {
    this.left = l;
    this.right = r;
  } // BitTreeInteriorNode(BitTreeNode, BitTreeNode)

  /**
   * Create a new node with no subtrees.
   */
  public BitTreeInteriorNode() {
    this(null, null);
  } // BitTreeInteriorNode()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Determine if the node is a leaf. (It's not.)
   *
   * @return false.
   */
  public boolean isLeaf() {
    return false;
  } // isLeaf()

  /**
   * Get the left subtree.
   *
   * @return the node at the root of the left subtree.
   */
  public BitTreeNode getLeft() {
    return this.left;
  } // getLeft()

  /**
   * Get the right subtree.
   *
   * @return the node at the root of the right subtree.
   */
  public BitTreeNode getRight() {
    return this.right;
  } // getRight()

  /**
   * Set the left subtree.
   *
   * @param l
   *   The root of the left subtree.
   */
  public void setLeft(BitTreeNode l) {
    this.left = l;
  } // setLeft(BitTreeNode)

  /**
   * Set the right subtree.
   *
   * @param r
   *   The root of the right subtree.
   */
  public void setRight(BitTreeNode r) {
    this.right = r;
  } // setRight(BitTreeNode)
} // class BitTreeInteriorNode
