package at.jku.isse.ecco.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * TODO: consider making BaseFeatureInstance and BaseFeatureVersion private classes of this class. And adding feature versions or instances is done only via this class' methods.
 */
public class BaseFeature implements Feature {

	private String name = "";
	private String description = "";

	private List<FeatureVersion> versions = new ArrayList<FeatureVersion>();

	public BaseFeature() {

	}

	public BaseFeature(String name) {
		this.setName(name);
	}

	@Override
	public List<FeatureVersion> getVersions() {
		return this.versions;
	}

	@Override
	public void addVersion(FeatureVersion version) {
		if (!this.versions.contains(version))
			this.versions.add(version);
	}

	@Override
	public FeatureVersion getVersion(FeatureVersion version) {
		for (FeatureVersion featureVersion : this.versions) {
			if (featureVersion.equals(version))
				return featureVersion;
		}
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(final String name) {
		checkNotNull(name);
		checkArgument(!name.isEmpty(), "Expected a non-empty name but was empty.");

		this.name = name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(final String description) {
		checkNotNull(description);

		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) return true;
		if (!(obj instanceof BaseFeature)) return false;

		final Feature other = (Feature) obj;
		return name.equals(other.getName());
	}

	@Override
	public String toString() {
		return this.name;
	}

}
