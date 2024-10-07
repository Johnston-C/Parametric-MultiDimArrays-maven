package edu.grinnell.csc207.util;

/**
 * A structure that acts like a multi dimensional Array
 *
 * @author Samuel A. Rebelsky
 */
public class MultiDimArray<T> {
  // +--------+
  // | Fields |
  // +--------+
  /**
   * The values stored in the multi dimensional array.
   */
  private T[] values;

  /**
   * The size of each dimension of the multi dimenstional array.
   */
  private int[] dimensions;

  // +--------------+
  // | Constructors |
  // +--------------+
  
  @SuppressWarnings({"unchecked"})
  public MultiDimArray(int[] dims) {
    this.dimensions = dims;
    int sizeOf=1;
    for (int i = 0; i < this.dimensions.length; i++) {
      sizeOf *= this.dimensions[i];
    } // for [i]
    this.values = (T[]) new Object[sizeOf];
  } // MultiDimArray(int[])

  // +---------+
  // | Methods |
  // +---------+

  public T get(int[] indecies) throws Exception {
    int index = 0;
    for (int i = 0; i < this.dimensions.length; i++) {
      if ((indecies[i] < 0) || (indecies[i] >= this.dimensions[i])) {
        throw new Exception("Index out of bounds.");
      } // if
      index += indecies[i];
      if (i != this.dimensions.length - 1) {
        index *= this.dimensions[i];
      } // if
    } // for [i]
    return values[index];
  } // get(int[])

  public void set(T item, int[] indecies) throws Exception {
    int index = 0;
    for (int i = 0; i < this.dimensions.length; i++) {
      if ((indecies[i] < 0) || (indecies[i] >= this.dimensions[i])) {
        throw new Exception("Index out of bounds.");
      } // if
      index += indecies[i];
      if (i != this.dimensions.length - 1) {
        index *= this.dimensions[i];
      } // if
    } // for [i]
    values[index] = item;
  } // set(T, int[])

  public String toString() {
    return toStringHelper(0,0);
  } // toString()

  public String toStringHelper(int depth, int curIndex) {
    String output = "{";
    if (depth == dimensions.length - 1) {
      for (int i = 0; i < dimensions[depth]; i++) {
        output += toStringNullObject(values[curIndex + i]);
        if (i != (dimensions[depth] - 1)) {
          output += ", ";
        } // if
      } // for [i]
    } else {
      for (int i = 0; i < dimensions[depth]; i++) {
        output += toStringHelper(depth + 1, (curIndex + i) * dimensions[depth]);
        if (i != (dimensions[depth] - 1)) {
          output += ", ";
        } // if
      } // for [i]
    } // if / else
    return output += "}";
  }

  public String toStringNullObject(T object) {
    if (object == null) {
      return "<null>";
    } else {
      return object.toString();
    }

  }

} // MultiDimArray<T>
