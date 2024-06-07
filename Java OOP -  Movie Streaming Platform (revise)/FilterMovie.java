@FunctionalInterface
interface FilterMovie<T, D> {
	public void filter(T t, D d);
}
