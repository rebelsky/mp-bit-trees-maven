package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length
 * sequences of bits and corresponding values.
 *
 * @author Samuel A. Rebelsky
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The height of the tree.
   */
  int height;

  /**
   * The root of the tree.
   */
  BitTreeNode root;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new bit tree of the given height.
   *
   * @param n
   *   The height of the tree.
   */
  public BitTree(int n) {
    this.root = null;
    this.height = n;
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+

  /**
   * Check the length of a bit string, throwing an exception if it's
   * incorrect.
   *
   * @param bits
   *   The string to check.
   */
  void check(String bits) {
    if (bits.length() != this.height) {
      throw new IndexOutOfBoundsException(String.format(
          "bit string %s is wrong length (expected %d, got %d)",
          bits, this.height, bits.length()));
    } // if
  } // check(String)

  /**
   * Dump the subtree starting at a particular node given the path to
   * that node.
   *
   * @param pen
   *   Where to dump the subtree.
   * @param node
   *   The root of the subtree.
   * @param bits
   *   The path to that node.
   */
  void dump(PrintWriter pen, BitTreeNode node, String bits) {
    if (node == null) {
      return;
    } else if (node instanceof BitTreeLeaf) {
      pen.println(bits + "," + ((BitTreeLeaf) node).getValue());
    } else {
      dump(pen, ((BitTreeInteriorNode) node).left, bits + "0");
      dump(pen, ((BitTreeInteriorNode) node).right, bits + "1");
    } // if/else
  } // dump(PrintWriter, BitTreeNode, String)

  /**
   * Get the value in the leaf given by following the path given by bits
   * and starting at node.
   *
   * @param node
   *   The root of the subtree.
   * @param bits
   *   The path to take.
   *
   * @return the value at the leaf.
   */
  String get(BitTreeNode node, String bits) {
    if (null == node) {
      throw new IndexOutOfBoundsException("No corresponding value");
    } else if ("".equals(bits)) {
      return ((BitTreeLeaf) node).getValue();
    } else {
      char bit = bits.charAt(0);
      if ('0' == bit) {
        return get(((BitTreeInteriorNode) node).left, bits.substring(1));
      } else if ('1' == bit) {
        return get(((BitTreeInteriorNode) node).right, bits.substring(1));
      } else {
        throw new IndexOutOfBoundsException("Invalid bit in bit string: "
            + bit);
      } // if/else
    } // /if/else
  } // get(BitTreeNode, String)

  /**
   * Set the leaf given by following the path given by bits and starting
   * at node to `value`.
   *
   * @param node
   *   The root of the subtree.
   * @param bits
   *   The path to take.
   * @param value
   *   The value to set.
   *
   * @return the modified tree.
   */
  BitTreeNode set(BitTreeNode node, String bits, String value) {
    if ("".equals(bits)) {
      return new BitTreeLeaf(value);
    } else {
      if (null == node) {
        node = new BitTreeInteriorNode();
      } // if
      char bit = bits.charAt(0);
      BitTreeInteriorNode inode = (BitTreeInteriorNode) node;
      if ('0' == bit) {
        inode.setLeft(set(inode.getLeft(), bits.substring(1), value));
      } else if ('1' == bit) {
        inode.setRight(set(inode.getRight(), bits.substring(1), value));
      } else {
        throw new IndexOutOfBoundsException("Invalid bit in bit string: "
            + bit);
      } // if/else
      return node;
    } // if/else
   } // set(BitTreeNode, String, String)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Set the value given by bits to value.
   *
   * @param bits
   *   The bits that serve as the key.
   * @param value
   *   The corresponding value.
   *
   * @throws IndexOutOfBoundException
   *   if bits is the wrong length for the tree or contains a value
   *   other than 0 or 1.
   */
  public void set(String bits, String value) {
    this.check(bits);
    this.root = this.set(this.root, bits, value);
  } // set(String, String)

  /**
   * Get the value set by bits.
   *
   * @param bits
   *   The sequence of bits that serve as the key.
   *
   * @return the corresponding value.
   *
   * @throws IndexOutOfBoundException
   *   if bits is the wrong length for the tree, contains a value
   *   other than 0 or 1, of has not previously been set.
   */
  public String get(String bits) {
    this.check(bits);
    return this.get(this.root, bits);
  } // get(String, String)

  /**
   * Dump the tree, printing all the key/value pairs.
   *
   * @param pen
   *   Where to dump the tree.
   */
  public void dump(PrintWriter pen) {
    dump(pen, this.root, "");
  } // dump(PrintWriter)

  /**
   * Load the tree (or parts thereof).
   *
   * @param source
   *   The source of the lines for the tree.
   */
  public void load(InputStream source) {
    BufferedReader r = new BufferedReader(new InputStreamReader(source));
    String line;
    try {
      while ((line = r.readLine()) != null) {
        String[] parts = line.split(",", 2);
        this.set(parts[0], parts[1]);
      } // while
    } catch (IOException e) {
      // Do nothing.
    } // try/catch
  } // load(InputStream)

} // class BitTree
