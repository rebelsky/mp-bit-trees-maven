package edu.grinnell.csc207.util;

/**
 * Nodes in a bit tree.
 *
 * @author Samuel A. Rebelsky
 */
public interface BitTreeNode {
  /**
   * Determine if the node is a leaf.
   *
   * @return true if it's a leaf and false otherwise.
   */
  public boolean isLeaf();
} // interface BitTreeNode
