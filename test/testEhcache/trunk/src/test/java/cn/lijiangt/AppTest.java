package cn.lijiangt;

import java.io.Serializable;

import junit.framework.TestCase;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	public static class Son implements Serializable{
		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

	public static class Father implements Serializable{

		private String value;

		private Son rel;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Son getRel() {
			return rel;
		}

		public void setRel(Son rel) {
			this.rel = rel;
		}

	}

	public void testApp(){
		CacheManager singletonManager = CacheManager.create();
		Cache memoryOnlyCache = new Cache("testCache", 1, true, false, 5, 2);
		singletonManager.addCache(memoryOnlyCache);
		Cache test = singletonManager.getCache("testCache");
		test.put(new Element("testtest",""));
		Father f = new Father();
		f.setValue("111");
		Son s = new Son();
		s.setValue("111-222");
		f.setRel(s);
		Element e = null;
		e = new Element("son",s);
		test.put(e);
		e = new Element("father111",f);
		test.put(e);
		
		e = test.get("son");
		s = (Son) e.getObjectValue();
		s.setValue("2222222");
//		e = new Element("son",s);
//		test.put(e);
		e = test.get("father111");
		f = (Father) e.getObjectValue();
		assertEquals("2222222",f.getRel().getValue());
		
	}
}
