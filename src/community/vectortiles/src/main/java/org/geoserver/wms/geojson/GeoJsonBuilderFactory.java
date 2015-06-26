package org.geoserver.wms.geojson;

import java.awt.Rectangle;
import java.util.Set;

import org.geoserver.wms.vector.VectorTileBuilder;
import org.geoserver.wms.vector.VectorTileBuilderFactory;
import org.geotools.geometry.jts.ReferencedEnvelope;

import com.google.common.collect.ImmutableSet;

public class GeoJsonBuilderFactory implements VectorTileBuilderFactory {
    public static final String MIME_TYPE = "application/json;type=geojson";

    public static final Set<String> OUTPUT_FORMATS = ImmutableSet.of(MIME_TYPE, "geojson");

    @Override
    public Set<String> getOutputFormats() {
        return OUTPUT_FORMATS;
    }

    @Override
    public String getMimeType() {
        return MIME_TYPE;
    }

    @Override
    public VectorTileBuilder newBuilder(Rectangle screenSize, ReferencedEnvelope mapArea) {
        return new GeoJsonWMSBuilder(screenSize, mapArea);
    }

}
