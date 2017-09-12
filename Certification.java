

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author maysow
 *         $Id$
 */
public enum Certification
{
    AO,
    PGR,
    G,
    LiveUnclassified;

    private static Map<String, Certification> certificationMap = new HashMap<String, Certification>();

    static {
        certificationMap.put("AO", AO);
        certificationMap.put("PGR", PGR);
        certificationMap.put("G", G);
        certificationMap.put("Live/Unclassified", LiveUnclassified);
    }

//    @JsonCreator
//    public static Certification forValue(String value) {
//        return certificationMap.get(value.toLowerCase());
//    }

    @JsonValue
    public String toValue() {
        for (Map.Entry<String, Certification> entry : certificationMap.entrySet()) {
            if (entry.getValue().toString().toLowerCase().equals(this.toString()))
                return entry.getKey();
        }

        return "bidon";
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
