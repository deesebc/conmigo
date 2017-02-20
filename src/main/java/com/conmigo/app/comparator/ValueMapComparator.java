package com.conmigo.app.comparator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ValueMapComparator<K, V extends Comparable<V>> implements Comparator<V> {

	Map<K, V> map = new HashMap<K, V>();

	public ValueMapComparator( final Map<K, V> map ) {
		this.map.putAll( map );
	}

	@Override
	public int compare( final V o1, final V o2 ) {
		return map.get( o1 ).compareTo( map.get( o2 ) );// descending order
	}
}
