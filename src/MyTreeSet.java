public class MyTreeSet<E extends Comparable<E>> {
	private MyTreeMap<E, Object> map;
	private final Object dummy = new Object();
	
	public MyTreeSet() {
		this.map = new MyTreeMap<>();
	}
	public boolean put(E element) {
		if(!isElementPresent(element)) {
			map.put(element, dummy);
		}
		return !isElementPresent(element);
	}
	public void remove(E element) {
		map.remove(element);
	}
	public boolean isElementPresent(E element) {
		return map.get(element) != null;
	}
}

