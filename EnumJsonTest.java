

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author maysow
 *         $Id$
 */
public class EnumJsonTest
{
  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  public void test() throws Exception
  {
    // test stand alone
    Certification cert = Certification.LiveUnclassified;
    String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(cert);
    System.out.println(json);
    Certification actualCert = objectMapper.readValue(json, Certification.class);
    assertEquals(cert, actualCert);

    // test wrapped in other object
    CertificationParent parent = new CertificationParent();
    parent.setCert(cert);
    json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(parent);
    System.out.println(json);

    CertificationParent actualParent = objectMapper.readValue(json, CertificationParent.class);
    assertEquals(parent.getCert(), actualParent.getCert());
  }
}
