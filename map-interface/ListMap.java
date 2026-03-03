import java.util.*;

public class ListMap<K, V> implements Map<K, V>
{
    List<Map.Node<K, V>> list;
    
    public ListMap()
    {
        list = new ArrayList<Map.Node<K, V>>();
    }
    
    public int size()
    {
        return list.size();
    }
    
    public boolean isEmpty()
    {
        return list.size() == 0;
    }
    public V put(K key, V value)
    {
        Map.Node<K, V> n = new Map.Node<K, V>(key, value);
        for (Map.Node<K, V> i : list)
        {
            if (i.getKey().equals(key))
            {
                V ret = i.getValue();
                i.setValue(value);
                return ret;
            }
        }
        list.add(n);
        return null;
    }
    public V get(Object key)
    {
        for (Map.Node<K, V> i : list)
        {
            if (i.getKey().equals(key))
            {
                return i.getValue();
            }
        }
        return null;
    }
    public List<V> values()
    {
        List<V> ret = new ArrayList<V>();
        for (Map.Node<K, V> i : list)
        {
            ret.add(i.getValue());
        }
        return ret;
    }
    public Set<K> keySet()
    {
        Set<K> ret = new ListSet<K>();
        for (Map.Node<K, V> i : list)
        {
            ret.add(i.getKey());
        }
        return ret;
    }
    public boolean containsKey(Object key)
    {
        for (Map.Node<K, V> i : list)
        {
            if (i.getKey().equals(key))
                return true;
        }
        return false;
    }
    public boolean containsValue(Object value)
    {
        for (Map.Node<K, V> i : list)
        {
            if (i.getValue().equals(value))
                return true;
        }
        return false;
    }   
    public V remove(Object key)
    {
        for (Map.Node<K, V> i : list)
        {
            if (i.getKey().equals(key))
            {
                V ret = i.getValue();
                list.remove(i);
                return ret;
            }
        }
        return null;
    }
    
}

