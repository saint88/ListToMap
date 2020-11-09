package com.company.list;

import java.util.ArrayList;
import java.util.List;

public class ListUtils<T> implements ListUtilsInt<T> {

  private List<T> list;

  public ListUtils(List<T> list) {
    this.list = list;
  }

  @Override
  public int search(T item) {
    int innerCounter = 0;

    for(T listItem: list) {

      if(listItem.equals(item)) {
        innerCounter++;
      }
    }

    return innerCounter;
  }

  @Override
  public List<T> remove(T item) {

    int i = 0;
    do {
      i++;

      T lastItem = list.remove(list.size() - 1);
      int index = getIndexItem(list, item);

      if(list.size() == 1) {
        list.remove(0);
        break;
      }

      if(index == -1) {
        break;
      }

      list.set(index, lastItem);
    } while(i < list.size() && getIndexItem(list, item) != -1);

    return list;
  }

  private int getIndexItem(List<T> list, T item) {
    for(int i = 0; i< list.size(); i++) {
      if(list.get(i).equals(item)) {
        return i;
      }
    }

    return -1;
  }
}
