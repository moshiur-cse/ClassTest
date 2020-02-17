
package com.moshiurcse.classtest.shape_file_json;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GeoJsonData {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;
    @SerializedName("features")
    @Expose
    private List<Feature> features = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

}
