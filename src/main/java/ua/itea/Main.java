package ua.itea;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("pom.xml"));

		NodeList nlModelVersion = document.getElementsByTagName("modelVersion");
		NodeList nlName = document.getElementsByTagName("name");
		NodeList nlGroupId = document.getElementsByTagName("groupId");
		NodeList nlArtifactId = document.getElementsByTagName("artifactId");
		NodeList nlVersion = document.getElementsByTagName("version");

		Project proj = new Project();
		List<Dependency> dependencies = new ArrayList<Dependency>();
		List<Plugin> plugins = new ArrayList<Plugin>();
		int numberOFPlagin = nlArtifactId.getLength() - nlGroupId.getLength();

		for (int i = 0; i < nlArtifactId.getLength(); i++) {
			Node nodeArtifactId = nlArtifactId.item(i);
			Node nodeVersion = nlVersion.item(i);
			Element eArtifactId = (Element) nodeArtifactId;
			Element eVersion = (Element) nodeVersion;

			if (i < nlGroupId.getLength()) {
				Node nodeGroupId = nlGroupId.item(i);
				Element eGroupId = (Element) nodeGroupId;

				if (i == 0) {
					Node nodeModelVersion = nlModelVersion.item(0);
					Element eModelVersion = (Element) nodeModelVersion;
					Node nodeName = nlName.item(0);
					Element eName = (Element) nodeName;

					proj.setMainFields(eModelVersion.getTextContent(), eName.getTextContent(), eGroupId.getTextContent(), eArtifactId.getTextContent(),
							eVersion.getTextContent());
				} else {
					dependencies.add(new Dependency(eGroupId.getTextContent(), eArtifactId.getTextContent(),
							eVersion.getTextContent()));
				}
			} else {
				plugins.add(new Plugin(eArtifactId.getTextContent(), eVersion.getTextContent()));
			}
		}
		
		proj.setDependencies(dependencies);
		proj.setPlugins(plugins);

		System.out.println(proj);

	}

}
