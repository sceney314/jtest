package patten.iterator;

/**
 * 抽象迭代器：婺源景点迭代器接口
 */
public interface ViewSpotIterator {
    boolean hasNext();
    WyViewSpot first();
    WyViewSpot next();
    WyViewSpot previous();
    WyViewSpot last();
}
