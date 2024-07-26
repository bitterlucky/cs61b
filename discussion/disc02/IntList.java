//public class IntList {
//	public String first;
//	public IntList rest;
//	public IntList(String first, IntList rest) {
//		this.first = first;
//		this.rest = rest;
//	}
//	public static void main(String[] args) {
//		IntList L = new IntList("eat", null);
//		L = new IntList("shouldn't", L);
//		L = new IntList("you", L);
//		L = new IntList("sometimes", L);
//		IntList M = L.rest;
//		IntList R = new IntList("many", null);
//		R = new IntList("potatoes", R);
//		R.rest.rest = R;
//		M.rest.rest.rest = R.rest;
//		L.rest.rest = L.rest.rest.rest;
//		L = M.rest;
//	}
//	public static IntList square(IntList L) {
//		if (L == null) {
//			return null;
//		} else {
//			return new IntList(L.first * L.first, square(L.rest));
//		}
//	}
//	public static IntList squareMutative(IntList L) {
//		if (L == null) {
//			return null;
//		} else {
//			L.first = L.first * L.first;
//			squareMutative(L.rest);
//			return L;
//		}
//	}
//}