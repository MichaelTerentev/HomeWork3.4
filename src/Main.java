public class Main {
    public static void main(String[] args) {
        MyTreeSet<Integer> set = new MyTreeSet<>();
		set.put(1);
		set.remove(1);
		System.out.println(set.isElementPresent(1));
    }
}
