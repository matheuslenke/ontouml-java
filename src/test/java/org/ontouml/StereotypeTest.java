package org.ontouml;

import org.ontouml.model.ClassStereotype;
import org.ontouml.model.PropertyStereotype;
import org.ontouml.model.RelationStereotype;
import org.ontouml.model.Stereotype;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth8.assertThat;

public class StereotypeTest {

  @Test
  void findKindByName() {
    assertThat(Stereotype.findByName(ClassStereotype.class, "kind")).hasValue(ClassStereotype.KIND);
  }

  @Test
  void findRoleMixinByName() {
    assertThat(Stereotype.findByName(ClassStereotype.class, "roleMixin"))
        .hasValue(ClassStereotype.ROLE_MIXIN);
  }

  @Test
  void findMaterialByName() {
    assertThat(Stereotype.findByName(RelationStereotype.class, "material"))
        .hasValue(RelationStereotype.MATERIAL);
  }

  @Test
  void findExternalDependenceByName() {
    assertThat(Stereotype.findByName(RelationStereotype.class, "externalDependence"))
        .hasValue(RelationStereotype.EXTERNAL_DEPENDENCE);
  }

  @Test
  void findBeginByName() {
    assertThat(Stereotype.findByName(PropertyStereotype.class, "begin"))
        .hasValue(PropertyStereotype.BEGIN);
  }

  @Test
  void findEndByName() {
    assertThat(Stereotype.findByName(PropertyStereotype.class, "end"))
        .hasValue(PropertyStereotype.END);
  }

  @Test
  void findByNameCaseSensitive() {
    assertThat(Stereotype.findByName(ClassStereotype.class, "Kind")).isEmpty();
  }

  @Test
  void findByNameSpaceSensitive() {
    assertThat(Stereotype.findByName(RelationStereotype.class, "role Mixin")).isEmpty();
  }
}
