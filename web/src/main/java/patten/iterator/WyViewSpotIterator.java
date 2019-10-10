package patten.iterator;

import java.util.ArrayList;

/**
 * 具体迭代器：婺源景点迭代器
 */
public class WyViewSpotIterator implements ViewSpotIterator {
    private ArrayList<WyViewSpot> list = null;
    private int index = -1;
    WyViewSpot obj = null;

    public WyViewSpotIterator(ArrayList<WyViewSpot> list) {
        this.list = list;
    }

    public boolean hasNext() {
        if (index < list.size() - 1) {
            return true;
        } else {
            return false;
        }
    }

    public WyViewSpot first() {
        index = 0;
        obj = list.get(index);
        return obj;
    }

    public WyViewSpot next() {
        if (this.hasNext()) {
            obj = list.get(++index);
        }
        return obj;
    }

    public WyViewSpot previous() {
        if (index > 0) {
            obj = list.get(--index);
        }
        return obj;
    }

    public WyViewSpot last() {
        index = list.size() - 1;
        obj = list.get(index);
        return obj;
    }

}
