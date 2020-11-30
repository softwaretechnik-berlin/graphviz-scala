package berlin.softwaretechnik.graphviz

import org.scalatest.funsuite.AnyFunSuite

class GraphvizAcceptanceTest extends AnyFunSuite {

  test("I can run the generator without failing") {
    generator.Generator.main(Array.empty)
    // The actual assertion is checking the working copy work for cleanliness
  }

  test("I can run the example without failing") {
    GraphExample.main(Array.empty)
    // The actual assertion is checking the working copy work for cleanliness
  }

  test("I can render the README.md") {
    Readme.main(Array.empty)
    // This shouldn't change anything
  }
}
