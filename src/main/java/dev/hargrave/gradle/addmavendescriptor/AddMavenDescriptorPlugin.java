package dev.hargrave.gradle.addmavendescriptor;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.bundling.Jar;

/**
 * AddMavenDescriptorPlugin for Gradle.
 * <p>
 * The plugin name is {@code dev.hargrave.addmavendescriptor}.
 * <p>
 * This plugin applies the maven-publish plugin to a project
 * and adds the AddMavenDescriptorPluginExtension to the project
 * and adds the AddMavenDescriptorJarExtension to all Jar
 * tasks.
 */
public class AddMavenDescriptorPlugin implements Plugin<Project> {
	/**
	 * Name of the plugin.
	 */
	public static final String PLUGINID = "dev.hargrave.addmavendescriptor";

	/**
	 * Apply the plugin to the specified project.
	 */
	@Override
	public void apply(Project project) {
		// Apply maven-publish plugin to the project
		project.getPluginManager()
			.apply("maven-publish");

		// Add project extension
		AddMavenDescriptorPluginExtension pluginExtension = project.getExtensions()
			.create(AddMavenDescriptorPluginExtension.NAME, AddMavenDescriptorPluginExtension.class, project);

		// Add Jar task extensions
		project.getTasks()
			.withType(Jar.class)
			.configureEach(task -> task.getExtensions()
				.create(AddMavenDescriptorTaskExtension.NAME, AddMavenDescriptorTaskExtension.class, task, pluginExtension));
	}
}
