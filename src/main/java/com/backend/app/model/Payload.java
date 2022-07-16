package com.backend.app.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("payload")
public class Payload extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	public Payload() {

	}

	public <E> Payload(Map<String, Object> map) {
		if (map != null) {
			Iterator<String> mapIt = map.keySet().iterator();

			while (mapIt.hasNext()) {
				String key = (String) mapIt.next();

				this.set(key, map.get(key));
			}
		}
	}

	public <E> Payload set(String key, E obj) {
		super.put(key, obj);
		return this;
	}
}