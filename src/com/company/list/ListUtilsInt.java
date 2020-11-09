package com.company.list;

import java.util.List;

public interface ListUtilsInt<T> {
  public int search(T item);
  public List<T> remove(T item);
}
