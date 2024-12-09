package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;

public class LogicsImpl implements Logics {

	private final int size;
	private final List<Integer> values;
	private final List<Boolean> enablings = new ArrayList<>();

	public LogicsImpl(int size) {
		this.size = size;
		values = new ArrayList<>();
		for(int i = 0; i < this.size; i++) this.values.add(0);
		for(int i = 0; i < this.size; i++) this.enablings.add(true);
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public List<Integer> values() {
		return new ArrayList<>(values);
	}

	@Override
	public List<Boolean> enablings() {
		return new ArrayList<>(enablings);
	}

	@Override
	public int hit(int elem) {
		int val = this.values.get(elem) + 1;
		this.values.set(elem, val);
		if (val == this.size) {
			this.enablings.set(elem, false);
		}
		return val;
	}

	@Override
	public String result() {
		String result = this.values.toString().replace("[", "<<")
		.replace("]", ">>").replaceAll(", ", "|");
		return result;
	}

	@Override
	public boolean toQuit() {
		int tmp = this.values.get(0);
		for (var e : this.values) {
			if (e != tmp) return false;
		}
		return true;
	}
}
