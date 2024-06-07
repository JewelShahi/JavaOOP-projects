@FunctionalInterface
interface IFilterMovie<T, D> {
	public void filter(T t, D d);
}
