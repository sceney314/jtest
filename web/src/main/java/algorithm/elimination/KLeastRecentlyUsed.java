package algorithm.elimination;

/**
 * LRU-K
 * 原理：LRU-K中的K代表最近使用的次数，因此LRU可以认为是LRU-1。LRU-K的主要目的是为了解决LRU算法“缓存污染”的问题，其核心思想是将“最近使用过1次”的判断标准扩展为“最近使用过K次”。
 *
 * 相比LRU，LRU-K需要多维护一个队列，用于记录所有缓存数据被访问的历史。只有当数据的访问次数达到K次的时候，才将数据放入缓存。当需要淘汰数据时，LRU-K会淘汰第K次访问时间距当前时间最大的数据。详细实现如下：
 * 1. 数据第一次被访问，加入到访问历史列表；
 * 2. 如果数据在访问历史列表里后没有达到K次访问，则按照一定规则（FIFO，LRU）淘汰；
 * 3. 当访问历史队列中的数据访问次数达到K次后，将数据索引从历史队列删除，将数据移到缓存队列中，并缓存此数据，缓存队列重新按照时间排序；
 * 4. 缓存数据队列中被再次访问后，重新排序；
 * 5. 需要淘汰数据时，淘汰缓存队列中排在末尾的数据，即：淘汰“倒数第K次访问离现在最久”的数据。
 *
 * LRU-K具有LRU的优点，同时能够避免LRU的缺点，实际应用中LRU-2是综合各种因素后最优的选择，LRU-3或者更大的K值命中率会高，但适应性差，需要大量的数据访问才能将历史访问记录清除掉。
 *
 * 2020-04-17 20:34
 */
public class KLeastRecentlyUsed {
    private int maxCapacity = 5;

    private CacheNode cache;
    private CacheNode tail;
    private int capacity = 5;

    private CacheNode history;
    private CacheNode historyTail;
    private int hCapacity = 10;



    private class CacheNode{
        private int val;

        private int num;

        private CacheNode prev;

        private CacheNode next;
    }

    public void add(int val){

    }
}
