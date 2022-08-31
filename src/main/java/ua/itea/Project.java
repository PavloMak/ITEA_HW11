package ua.itea;

import java.util.List;

public class Project {

	private String modelVersion;
	private String name;
	private String groupId;
	private String artifactId;
	private String version;
	private List<Dependency> dependencies;
	private List<Plugin> plugins;

	public void setMainFields(String modelVersion, String name, String groupId, String artifactId, String version) {
		this.modelVersion = modelVersion;
		this.name = name;
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
	}

	public String getModelVersion() {
		return modelVersion;
	}

	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Dependency> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<Dependency> dependencies) {
		this.dependencies = dependencies;
	}

	public List<Plugin> getPlugins() {
		return plugins;
	}

	public void setPlugins(List<Plugin> plugins) {
		this.plugins = plugins;
	}

	@Override
	public String toString() {
		return "Project [\n modelVersion = " + modelVersion + ",\n name = " + name + ",\n groupId = " + groupId
				+ ",\n artifactId = " + artifactId + ",\n version = " + version + ",\n dependencies = " + dependencies
				+ ",\n plugins = " + plugins + "\n]";
	}

}
