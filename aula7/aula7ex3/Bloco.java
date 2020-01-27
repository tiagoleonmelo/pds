package lab7ex3;

import java.util.*;

public class Bloco extends Figure {

	private List<Figure> list = new ArrayList<>();
	private String name;
	private String space = "   ";

	public Bloco(String string) {
		this.name = string;

	}

	public void add(Figure f) {
		list.add(f);
	}

	public List<Figure> getList() {
		return list;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	@Override
	public void draw() {
		System.out.println("Window " + name);
		for (int i = 0; i < list.size(); i++) {
			Figure next = list.get(i);
			System.out.print(this.space);
			if (next instanceof Bloco && ((Bloco) next).getList().size() != 0) {
				String nspace = this.space + "   ";
				((Bloco) next).setSpace(nspace);
				next.draw();

			} else {
				next.draw();
			}
		}

	}

}
