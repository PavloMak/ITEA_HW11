package ua.itea;

public class Dependency {
	
	private String groupId;
	private String artifactId;
	private String version;

	public Dependency(String groupId, String artifactId, String version) {
		super();
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
	}

	@Override
	public String toString() {
		return "Dependency [groupId=" + groupId + ", artifactId=" + artifactId + ", version=" + version + "]";
	}

}
