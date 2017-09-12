

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
  AO("AO"),
  PGR("PGR"),
  G("G"),
  LiveUnclassified("Live/Unclassified");

  private final static Map<String, Certification> byLabel = new HashMap<>();

  public final String label;

  private Certification(String label)
  {
    this.label = label;
  }

  @JsonCreator
  public static Certification fromLabel(final String key)
  {
    return byLabel.computeIfAbsent(key, k -> Stream.of(values()).filter(e -> e.label.equals(key)).findAny().orElseThrow(IllegalArgumentException::new));
  }

  @JsonValue
  public String getLabel()
  {
    return label;
  }

//  @Override
//  public String toString()
//  {
//    return this.name().toLowerCase();
//  }
}
