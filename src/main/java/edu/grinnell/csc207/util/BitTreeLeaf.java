package edu.grinnell.csc207.util;

/**
 * Leaves in a bit tree.
 *
 * @author Samuel A. Rebelsky
 */
public class BitTreeLeaf implements BitTreeNode {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The value stored in the leaf.
   */
  String value;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new leaf.
   *
   * @param str
   *   The string to store in the leaf.
   */
  public BitTreeLeaf(String str) {
    this.value = str;
  } // BitTreeLeaf(String)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Determine if the node is a leaf.
   *
   * @return true
   */
  public boolean isLeaf() {
    return true;
  } // isLeaf()

  /**
   * Get the value in the leaf.
   *
   * @return the value in the leaf.
   */
  public String getValue() {
    return this.value;
  } // getValue()
} // class BitTreeLeaf
