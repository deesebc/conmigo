package com.conmigo.app.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import com.conmigo.app.aware.CustomMessageSourceAware;
import com.conmigo.app.comparator.ValueMapComparator;

public final class ComboUtil {

	private ComboUtil() {
		super();
	}

	public static Map<String, String> getEventTypes( final Locale locale ) {
		Map<String, String> map = new HashMap<String, String>();
		map.put( "event.type.concert", CustomMessageSourceAware.getMessage( "event.type.concert", null, locale ) );
		map.put( "event.type.cinema", CustomMessageSourceAware.getMessage( "event.type.cinema", null, locale ) );
		map.put( "event.type.teather", CustomMessageSourceAware.getMessage( "event.type.teather", null, locale ) );

		ValueMapComparator<String, String> comparator = new ValueMapComparator<String, String>( map );

		Map<String, String> result = new TreeMap<String, String>( comparator );
		result.putAll( map );

		return result;
	}
}
