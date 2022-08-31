package ua.itea;

public class Plugin {

	private String artifactId;
	private String version;

	public Plugin(String artifactId, String version) {
		super();
		this.artifactId = artifactId;
		this.version = version;
	}

	@Override
	public String toString() {
		return "Plugin [artifactId=" + artifactId + ", version=" + version + "]";
	}

}
