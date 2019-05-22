package lab1.backend.other;

public class Greeting {
	private String name;
	private String cumprimento;

	public Greeting(String name, String cumprimento) {
		this.name = name;
		this.cumprimento = cumprimento;
	}

	public String getName() {
		return name;
	}

	public String getCumprimento() {
		return cumprimento;
	}
}
